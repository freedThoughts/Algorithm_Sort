package problemSet_1;

import java.util.Scanner;

public class BubbleSort {
	
	public static void swap(int[] arr, int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int size = in.nextInt();
		int[] arr = new int[size];
		for(int i = 0; i<arr.length; i++)
			arr[i] = in.nextInt();
		
		in.close();
		

/*		int elementGetSorted = size; // last element get sorted. Last element is first to get sorted.

		while(elementGetSorted > 1) {
			boolean anySwapMade = false;
			for(int i = 0; i < elementGetSorted-1; i++){
				if(arr[i] > arr[i+1]) {
					swap(arr, i, i+1);
					anySwapMade = true;
				}
			}

			if(!anySwapMade) break;
			elementGetSorted --;
		}*/

		for(int sortingForIndex = size-1; sortingForIndex > 0; sortingForIndex-- ) {
			boolean isSwapped = false;
			for(int i = 0; i < sortingForIndex; i++){
				if(arr[i] > arr[i+1]){
					isSwapped = true;
					swap(arr, i, i+1);
				}
			}
			if (! isSwapped) break;
		}
		
		for(int i = 0; i<size; i++)
			System.out.print(arr[i] + ", ");
	}

}


//O(n^2)