package problemSet_1;

import java.util.Scanner;

public class SelectionSort {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int size = in.nextInt();
		int[] arr = new int[size];
		for(int i = 0; i< arr.length; i++)
			arr[i] = in.nextInt();
		
		in.close();
		
		for(int i = 0; i<size-1; i++){
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
		}
		
		for(int i = 0; i< arr.length ; i++)
			System.out.print(arr[i] + ", ");
	}

}


// Time : O(n^2)
// Space : O(1)