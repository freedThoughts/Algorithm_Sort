package problemSet_1;

import java.util.Scanner;

public class MergeSort {

	private static void mergeSort2(int[] arr) {
		if (arr.length < 2)                                                                // C1
			return;

		int[] leftArr = new int[arr.length/2];
		int[] rightArr = new int[arr.length - arr.length/2];
		System.arraycopy(arr, 0, leftArr, 0, leftArr.length);             // C2.n
		System.arraycopy(arr, leftArr.length, rightArr, 0, rightArr.length);

		mergeSort2(leftArr);                                                              // T(n/2)
		mergeSort2(rightArr);                                                             // T(n/2)

		merge2(arr, leftArr, rightArr);                                                   // C3.n
	}

	private static void merge2(int[] arr, int[] leftArr, int[] rightArr) {
		int i = 0, j = 0, k = 0;
		while (i < leftArr.length && j < rightArr.length) {
			if (leftArr[i] <= rightArr[j])
				arr[k++] = leftArr[i++];
			else
				arr[k++] = rightArr[j++];
		}
		while (i < leftArr.length)
			arr[k++] = leftArr[i++];

		while (j < rightArr.length)
			arr[k++] = rightArr[j++];
	}

/*
	Time Complexity:
	T(n) = 1, when n = 1,  as we simply return
	T(n) = 2.T(n/2) + c.n, When n > 1

	= 2{ 2.T(n/4) + c.n/2} + c.n
	= 4.T(n/4) + 2.c.n
	= 4 { 2.T(n/8) + c.n/4} + 2.c.n
	= 8.T(n/8) + 3.c.n
	= 8 { 2.T(n/16) + c.n/8} + 3.c.n
	= 16.T(n/16) + 4.c.n

	= 2^k.T(n/2^k) + k.c.n

	When n/2^k = 1
	n = 2^k
	log n = log 2^k
	log n = k

	= 2^(log n).T(1) + (log n).c.n
	= n + c.n.log n
	= O(n.log n)


	Space Complexity:
	= n + n/2 + n/4 + ...... n/c^k-1 ... for k levels
	= 2n for infinity progression
	= O(n)


*/


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

		mergeSort2(arr);
		
		System.out.println("Printing final sorted array ");
		
		for(int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + ", ");
		System.out.println();

	}

}

