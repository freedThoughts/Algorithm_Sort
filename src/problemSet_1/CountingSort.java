package problemSet_1;

public class CountingSort {
	
	int[] countingSort(int[] input, int K){
		int [] result = new int[input.length];
		int [] temp = new int[K];
		for(int i = 0; i<input.length; i++)
			temp[input[i]] ++;
		for(int i = 1; i < temp.length; i++)
			temp[i] = temp[i] +temp[i-1];
		for(int i = 0; i<input.length; i++)
			result[ -- temp[input[i]]] = input[i];
			//result[i] = temp[input[i]]--;
		
		return result;
	}

	public static void main(String[] args) {
		CountingSort obj = new CountingSort();
		int[] input = {3,6,9,1,3,5,7};
		int[] arr = obj.countingSort(input, 10);
		for(int i = 0; i<arr.length; i++)
			System.out.println(arr[i]);
	}

}
