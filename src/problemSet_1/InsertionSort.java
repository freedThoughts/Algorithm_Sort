package problemSet_1;

import java.util.Scanner;

public class InsertionSort {


	// INSERT BY SHIFTING
	// LEFT PART IS ALWAYS SORTED AND RIGHT PART IS UNSORTED
	// INSERT VALUE AT CORRECT POSITION BY MOVING LEFT

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int size = in.nextInt();
		int[] arr = new int[size];
		for(int i = 0; i<arr.length; i++)
			arr[i] = in.nextInt();
		in.close();

		for (int i = 1; i < arr.length; i++) {
			int value = arr[i];                                                    // C1(n-1)          times
			int j = i-1;
			for (; j>= 0 && arr[j] > value; j--) { // Compare with value           // C2 { 1 + 2 .... + (n-1)} times in worse case    // C2(n-1) times in best case
				arr[j+1] = arr[j];                 // Replace with J               // = C2{ n(n-1)/2}
			}
			arr[j+1] = value;                                                      // C3(n-1)
		}

/*
		Time Complexity:
		= (n-1)C1 + n(n-1)/2 C2 + (n-1)C3
		= O(n^2)


		Best case:
		= (n-1)C1 + (n-1)C2 + (n-1)C3
		= O(n)


		Space Complexity:
		= O(1)  for value


*/
		
		//int elementGettingSorted;

/*			elementGettingSorted = arr[i];
			for(int j = i-1; j >= 0; j--){
				if(arr[j] > elementGettingSorted)
					arr[j+1] = arr[j];
				else {
					arr[j] = elementGettingSorted;
					break;
				}

			}*/


/*			for(int j = i-1; j>=0 && arr[j] > arr[j+1]; j--)
				swap(arr, j, j+1);*/

/*		for(int i = 1; i<size; i++){
			int value = arr[i];
			int insertPointIndex = i;
			for( ; insertPointIndex > 0 && arr[insertPointIndex -1] > value; insertPointIndex-- )
				arr[insertPointIndex] = arr[insertPointIndex -1];
			arr[insertPointIndex] = value;*/
			
			for(int k = 0; k<size; k++)
				System.out.print(arr[k] + ", ");
			

		}
	}
