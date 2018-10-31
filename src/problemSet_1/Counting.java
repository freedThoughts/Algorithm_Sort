package problemSet_1;

public class Counting {

	public static void main(String[] args) {
		
		int MAX_RANGE = 10; // That's means values are between 0 to 9
		int[] arr = {6,6,7,2,5,6,8,1,3,4,9,6,7,0,4,7};
		
		arr = coutingSort(arr, MAX_RANGE);
		for(int i = 0; i<arr.length; i++)
			System.out.println(arr[i]);
	}
	
	public static int[] coutingSort(int[] arr, int MAX_RANGE){
		int[] temp = new int[MAX_RANGE];
		int[] output = new int[arr.length];
		
		for(int i = 0; i < arr.length; i++)
			temp[arr[i]] ++;
		
		for(int i = 1; i < temp.length; i++)
			temp[i] = temp[i] + temp[i-1];
		
		for(int i = arr.length -1; i >= 0; i--){
			output[temp[arr[i]]-1] = arr[i];
			temp[arr[i]] --;
		}
		
		return output;
	}
}

//Time Complexity = O(2n + k)  when we know MAX_RANGE. Otherwise O(3n + k) which includes getting maxValue  ~~ O(max(n, k))
// Space Complexity = O(n + k)
// k = MAX_RANGE