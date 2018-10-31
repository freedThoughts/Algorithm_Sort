package problemSet_1;


/**
 * Created by Prakash on 23-10-2018.
 */
public class TimSort {
    static int run = 2;
    public static void main(String[] a) {
        int[] arr = {21, 5, 23, 7, 19};
        timSort(arr);

        for (int i = 0; i < arr.length; i++)
            System.out.println(arr[i]);
    }

    private static void timSort(int[] arr) {
        for (int i = 0; i < arr.length; i += run)
            insertionSort(arr, i, Math.min(i+run -1, arr.length-1));

        for (int size = run; size <= arr.length; size *= 2)
            for (int startIndex = 0; startIndex + size < arr.length; startIndex += 2*size)
                merge(arr, startIndex, size);
    }

    // Time complexity - O(2*size) ~~ O(size)
    // Space Complexity - O(2* size) ~~ O(size) ---- for two temporary array A and B.
    private static void merge(int[] arr, int startIndex, int size){
        int[] A = new int[size];
        int[] B = new int[Math.min(size, arr.length - startIndex-size)];
        System.arraycopy(arr, startIndex, A, 0, A.length);
        System.arraycopy(arr, startIndex+size, B, 0, B.length);
        int k = startIndex;
        int m = 0;
        int n = 0;
        while (m < A.length && n < B.length) {
            if (A[m] <  B[n])
                arr[k++] = A[m++];
            else arr[k++] = B[n++];
        }
        if (m == A.length)
            while (n < B.length)
                arr[k++] = B[n++];
        else if (n == B.length)
            while (m < A.length)
                arr[k++] = A[m++];
    }

    // Time Complexity - O(run^2)
    // Space complexity - O(1)
    private static void insertionSort(int[] arr, int startIndex, int endIndex) {
        for (int i = startIndex+1; i <= endIndex; i++) {
            int value = arr[i];
            int j = i-1;
            for (; j >= 0 && arr[j] > value; j--)
                arr[j+1] = arr[j];

            arr[j+1] = value;
        }
    }
}
