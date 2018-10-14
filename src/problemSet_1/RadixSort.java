package problemSet_1;

public class RadixSort {
	
	// k = 10 here as we are using Decimal number system.

	public static void main(String[] args) {
		int[] arr = {125, 56, 7894, 478, 257, 45782, 845, 2, 56, 456, 356, 856, 6, 896, 660, 10};
		//int[] arr = {6,6,7,2,5,6,8,1,3,4,9,6,7,0,4,7};
		
		// O(n)
		int max = getMax(arr);
		
		// O( k * (3n + k))
		for(int exp = 1; max/exp > 0; exp *= 10){
			// O(3n + k)
			countingSort(arr, exp);
		} 
		
		// O(n)
		for(int i = 0; i<arr.length; i++)
			System.out.println(arr[i]);
	}
	
	// O(3n + k)
	public static void countingSort(int[] arr, int exp){
		int[] temp = new int[10];
		int[] output = new int[arr.length];
		
		//O(n)
		for(int i = 0; i < arr.length; i++)
			temp[(arr[i]/exp)%10] ++; 
		
		//O(k)
		for(int i = 1; i < temp.length; i++)
			temp[i] += temp[i-1];
		
		// O(n)
		for(int i = arr.length-1; i>=0; i--){
			output[temp[(arr[i]/exp)%10]-1] = arr[i];
			temp[(arr[i]/exp)%10] --;
		}
		
		// O(n)
		for(int i = 0; i<arr.length; i++)
			arr[i] = output[i];
	}
	
	// O(n)
	static int getMax(int[] arr){
		int max = 0;
		for(int i = 0; i < arr.length; i++){
			if(max < arr[i])
				max = arr[i];
		}
		return max;
	}

}
