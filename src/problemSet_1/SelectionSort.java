package problemSet_1;

import java.util.Scanner;

public class SelectionSort {

	// SELECT THE MINIMUM FROM REST -- ALGO

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter size of array");
		int size = in.nextInt();
		System.out.println("Enter array elements one by one");
		int[] arr = new int[size];
		for(int i = 0; i< arr.length; i++)
			arr[i] = in.nextInt();
		
		in.close();


		for (int i = 0; i< arr.length-1; i++) {
			int minValueIndex = i;                              // C1 (n-1) times .... O(n)

			for (int j = i+1; j < arr.length; j++){
				if (arr[j] < arr[minValueIndex]){               // C2{(n-1) + (n-2) + (n-3) + .... + 1} times
					minValueIndex = j;                          // C2{ n(n-1)/2} ........ O(n^2)
				}
			}

			if (minValueIndex != i) {                          // C3 (n-1) times ......... O(n)
				int temp = arr[i];
				arr[i] = arr[minValueIndex];
				arr[minValueIndex] = temp;
			}
		}
/*

		Time complexity :
		= (n-1)C1 + n(n-1)/2 C2 + (n-1)C3
		= ~ O(n^2)


		Space Complexity:
		= O(1)  used for minValueIndex and
		= O(1) for temp



*/

		
/*		for(int i = 0; i<size-1; i++){
			int minIndex = i;
			for(int j = i+1; j<size; j++){
				if(arr[j]<arr[minIndex])
					minIndex = j;
			}
			
			if(minIndex != i){
				int temp = arr[minIndex];
				arr[minIndex] = arr[i];
				arr[i] = temp;
			}
		}*/
		
		for(int i = 0; i< arr.length ; i++)
			System.out.print(arr[i] + ", ");
	}

}
