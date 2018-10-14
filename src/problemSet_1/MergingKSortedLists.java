package problemSet_1;

import java.util.ArrayList;
import java.util.List;

// Time complexity - O(n logk) where k is l.size() and n = result.length
// Space complexity - O(n + l)
public class MergingKSortedLists {

	public static void main(String[] args) {
		int[] arr1 = new int[]{3,6,9,10,55,67,89,100,345,567,789,890,999};
		int[] arr2 = new int[]{0,1,4,6,8,9,10};
		int[] arr3 = new int[]{99, 999, 9999, 9999, 99999, 999999, 999900000};
		int[] arr4 = new int[]{3, 6, 9, 12, 14, 17, 18, 19, 20, 26, 35, 45, 56, 68, 79, 80, 90};
		List<int[]> l = new ArrayList<int[]>();
		l.add(arr1);
		l.add(arr2);
		l.add(arr3);
		l.add(arr4);
		
		int[] result = mergeSort(l);
		for(int i = 0; i<result.length; i++)
			System.out.println(result[i]);
		
		System.out.println(result.length == arr1.length+arr2.length+arr3.length+arr4.length);

	}
	
	// O(log k)
	public static int[] mergeSort(List<int[]> l){
		if(l.size() == 1)
			return l.get(0);
		
		if(l.size() == 2)
			return merge(l.get(0), l.get(1));
	
		List<int[]> fistHalfList = new ArrayList<int[]>();
		List<int[]> secondHalfList = new ArrayList<int[]>();
		int listIndex = 0;
		while(listIndex < l.size()/2){
			fistHalfList.add(l.get(listIndex));
			listIndex ++;
		}
		
		while(listIndex < l.size()){
			secondHalfList.add(l.get(listIndex));
			listIndex ++;
		}
		int[] l1 = mergeSort(fistHalfList);
		int[] l2 = mergeSort(secondHalfList);
		
		return merge(l1, l2);
	}
	
	// O(n)
	public static int[] merge(int[] arr1, int[] arr2){
		
		int[] result = new int[arr1.length + arr2.length];
		
		int arr1Index = 0;
		int arr2Index = 0;
		int resultIndex = 0;
		while(arr1Index < arr1.length && arr2Index < arr2.length){
			if(arr1[arr1Index] < arr2[arr2Index]){
				result[resultIndex++] = arr1[arr1Index++];
			}else{
				result[resultIndex++] = arr2[arr2Index++];
			}
		}
		
		if(arr2Index == arr2.length){
			while(arr1Index < arr1.length)
				result[resultIndex++] = arr1[arr1Index++];
		}else{
			while(arr2Index < arr2.length)
				result[resultIndex++] = arr2[arr2Index++];
		}
		
		return result;
	} 

}
