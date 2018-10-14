package problemSet_1;

import java.util.Scanner;

public class MergeSort {
	
	private static void  merge(int[] L, int[] R, int[] A){
		int lIndex = 0;
		int rIndex = 0;
		int aIndex = 0;
		while(lIndex < L.length && rIndex < R.length){
			if(L[lIndex] <= R[rIndex]){
				A[aIndex] = L[lIndex];
				lIndex++;
			} else {
				A[aIndex] = R[rIndex];
				rIndex++;
			}
			aIndex++;
		}
		
		while(lIndex< L.length){
			A[aIndex] = L[lIndex];
			lIndex++;
			aIndex++;
		}
		while(rIndex < R.length){
			A[aIndex] = R[rIndex];
			rIndex++;
			aIndex++;
		}
	}
	
	private static void mergeSort(int[] arr){
		if(arr.length <= 1) return;
		
		int[] L = new int[arr.length/2];
		int[] R = new int[arr.length - arr.length/2];
		System.arraycopy(arr, 0, L, 0, L.length);      // O(n) ..  .. Complexity of System.arraycopy( .. ) 
		System.arraycopy(arr, L.length, R, 0, R.length);    // O(n)  .. Complexity of System.arraycopy( .. ) 
		
/*		System.out.println("Printing L array");
		for(int i =0; i < L.length; i++)
			System.out.print(L[i]);
		System.out.println();
		
		System.out.println("Printing R array");
		for(int i =0; i<R.length; i++)
			System.out.print(R[i]);
		System.out.println();*/
		
		mergeSort(L);
		mergeSort(R);
		
/*		System.out.println("After Printing L array");
		for(int i =0; i < L.length; i++)
			System.out.print(L[i]);
		System.out.println();
		
		System.out.println("After Printing R array");
		for(int i =0; i<R.length; i++)
			System.out.print(R[i]);
		System.out.println();*/
		
		merge(L, R, arr); // here we are overlapping original array arr.
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int size = in.nextInt();
		int[] arr = new int[size];
		for(int i = 0; i<arr.length; i++)
			arr[i] = in.nextInt();
		in.close();
		
		mergeSort(arr);
		
		System.out.println("Printing final sorted array ");
		
		for(int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + ", ");
		System.out.println();

	}

}


//Time complexity - O(n log n)
//Space complexity - O(n)
