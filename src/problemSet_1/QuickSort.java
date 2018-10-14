package problemSet_1;

import java.util.Random;
import java.util.Scanner;

// Time complexity - O(n log n)
// Space complexity - O(log n)
public class QuickSort {
	
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
			if(arr[i]<pivotValue){
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
		
		quickSort(arr, 0, size-1);	
		
		//System.out.println("Final array :- ");
		for(int i = 0; i<size; i++)
			System.out.print(arr[i] + ", ");

	}

}
