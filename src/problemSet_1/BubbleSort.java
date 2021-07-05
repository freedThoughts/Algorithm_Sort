package problemSet_1;

import java.util.Scanner;

public class BubbleSort {
	
    // WAVE SORTING ALGO
    // CONSECUTIVE WAVES ARE LESS POWERFUL

    // RIGHT PART OF ARRAY IS ALWAYS SORTED AND LEFT PART IS UNSORTED
    // KEEP PUSHING HIGHEST TO RIGHT PART IN EVERY ITERATION
    // WHEN NO PUSH FOR ANY ITERATION, ARRAY IS SORTED ---- IMPROVEMENT FOR SORTED ARRAY
    // OR WHEN DONE WITH ITERATION --- WORSE CASE

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int size = in.nextInt();
		int[] arr = new int[size];
		for(int i = 0; i<arr.length; i++)
			arr[i] = in.nextInt();
		
		in.close();

        boolean isSwapped = true;
		for (int i = arr.length-1; i > 0 && isSwapped; i--){
		    isSwapped = false;                                         // (n-1)C1 times
		    for (int j = 0; j < i; j++) {                              // C2{ (n-1) + (n-2) + (n-3) + .... + 1 }
		        if (arr[j] > arr[j+1]) {                               // = C2{ n(n-1)/2}
		            isSwapped = true;
		            swap(arr, j, j+1);
                }
            }
        }

/*

		Time complexity:
        = (n-1)C1 + n(n-1)/2 C2
        = ~ O(n^2)


        Best case:
        = O(n) ------- when arr is already shorted. Algo will identify by checking isSwapped

        Average case:
        = O(n^2)

        Worse case:
        = O(n^2)


        Space Complexity:
        = O(1)  for isSwapped
        = O(1)  for temp


*/






/*        for(int sortingForIndex = size-1; sortingForIndex > 0; sortingForIndex-- ) {
            boolean isSwapped = false;
            for(int i = 0; i < sortingForIndex; i++){
                if(arr[i] > arr[i+1]){
                    isSwapped = true;
                    swap(arr, i, i+1);
                }
            }
            if (! isSwapped) break;
        }*/
		

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


		
		for(int i = 0; i<size; i++)
			System.out.print(arr[i] + ", ");
	}

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
