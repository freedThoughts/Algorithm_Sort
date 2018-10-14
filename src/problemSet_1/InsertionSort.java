package problemSet_1;

import java.util.Scanner;

public class InsertionSort {
	
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
		
		//int elementGettingSorted;
		for(int i = 1; i<size; i++){
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

			int value = arr[i];
			int insertPointIndex = i;
			for( ; insertPointIndex > 0 && arr[insertPointIndex -1] > value; insertPointIndex-- )
				arr[insertPointIndex] = arr[insertPointIndex -1];
			arr[insertPointIndex] = value;
			
			for(int k = 0; k<size; k++)
				System.out.print(arr[k] + ", ");
			
			System.out.println();
		}
	}
}
