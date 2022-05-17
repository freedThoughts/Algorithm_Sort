package problemSet_1;

import java.util.Random;
import java.util.Scanner;

// Time complexity - O(n log n)
// Space complexity - O(log n)
public class QuickSort {

	// PARTITIONING LOGIC
	// ANY VALUE WHICH IS LESS THAN PIVOT SHOULD BE LEFT OF PINDEX
	// PINDEX WILL KEEP INCREMENTING AS MANY VALUES WHICH ARE LESSER THAN PIVOT
	// PIVOT WILL BE COMPARED COUNTER I. IF COUNTER VALUE IS LESS THAN PIVOT, SWAP COUNTER VALUE WITH PINDEX VALUE, INCREMENT PINDEX.


	private static void quickSort2(int[] arr, int start, int end) {
		if (start >= end) {
			return;
		}

		int pIndex = partition2(arr, start, end);       // C1.n
		quickSort2(arr, start, pIndex-1);          // T(n/2)
		quickSort2(arr, pIndex+1, end);           // T(n/2)
	}

	private static int partition2(int[] arr, int start, int end) {
		int pivotIndex = new Random().nextInt(end - start) + start;
		swap(arr, pivotIndex, end);
		int pivot = arr[end];
		int pIndex = start;

		for (int i = start; i < end; i++ ) {                     // C1.n times
			if (arr[i] < pivot) {
				swap(arr, pIndex, i);
				pIndex++;
			}
		}
		swap(arr, pIndex, end);
		return pIndex;
	}



	public static void swap(int[] arr, int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static int randamizedPartition(int[] arr, int startIndex, int endIndex){
		int pivotIndex = new Random().nextInt(endIndex - startIndex) + startIndex;
		swap(arr, pivotIndex, endIndex);
		return partition(arr, startIndex, endIndex);
	}
	
	public static int partition(int [] arr, int startIndex, int endIndex){
		int pivotValue = arr[endIndex];
		int index = startIndex;
		for(int i = startIndex; i<endIndex; i++ ){
			if(arr[i] <= pivotValue){
				swap(arr, i, index);
				index++;
			}
		}
		swap(arr, index, endIndex);
		return index;
	}
	
	public static void quickSort(int[] arr, int startIndex, int endIndex){
		if(startIndex < endIndex){
			int pivotIndex = randamizedPartition(arr, startIndex, endIndex);
			quickSort(arr, startIndex, pivotIndex-1);
			quickSort(arr, pivotIndex+1, endIndex);
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int size = in.nextInt();
		int[] arr = new int[size];
		for(int i = 0; i<size; i++)
			arr[i] = in.nextInt();
		in.close();
		
		quickSort2(arr, 0, size-1);
		
		//System.out.println("Final array :- ");
		for(int i = 0; i<size; i++)
			System.out.print(arr[i] + ", ");

	}

}
