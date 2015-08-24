import java.util.Random;
import java.lang.Integer;

// Runtime
// Best: O(nlogn)
// Average: O(nlogn)
// Worst: O(nlogn)

// Space
// Worst: O(n)
class MergeSort {
    public static void mergeSortHelperMerger(Integer[] arr, int iStart, int iMid, int iEnd, Integer[] arr2) {
        int iLeft = iStart;
        int iRight = iMid;
        for (int i = iStart; i < iEnd; ++i) {
            if (iLeft < iMid && (iRight >= iEnd || arr[iLeft] <= arr[iRight])) {
                arr2[i] = arr[iLeft++];
            } else {
                arr2[i] = arr[iRight++];
            }
        }
        
        for (int i = iStart; i < iEnd; ++i) {
            arr[i] = arr2[i];
        }
    }
   
    public static void mergeSortHelper(Integer[] arr, int iStart, int iEnd, Integer[] arr2) {
        if (iEnd - iStart < 2) {
            return;
        }
        
        int iMid = (iStart + iEnd) / 2;
        mergeSortHelper(arr, iStart, iMid, arr2);
        mergeSortHelper(arr, iMid, iEnd, arr2);
        mergeSortHelperMerger(arr, iStart, iMid, iEnd, arr2);
    }
    
    public static void mergeSort(Integer[] arr) {
        Integer[] arr2 = new Integer[arr.length];
        mergeSortHelper(arr, 0, arr.length, arr2);
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[10];
        Random rand = new Random();
        for (int i = 0; i < 10; ++i) {
            arr[i] = rand.nextInt(100);
        }
        
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();

        long start = System.nanoTime();
        mergeSort(arr);
        long end = System.nanoTime();
        System.out.println((end - start) / 1000000.0 + "ms");
        for (Integer i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
