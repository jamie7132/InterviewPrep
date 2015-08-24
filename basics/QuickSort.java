import java.util.Random;

// Runtime
// Best: O(nlogn)
// Average: O(nlogn)
// Worst: O(n^2)

// Space
// Worst: O(logn)
class QuickSort {
    public static int quickSortPartition(int[] arr, int iStart, int iEnd) {
        int pivot = arr[iStart];
        --iStart;
        ++iEnd;
        while (true) {
            do {
                --iEnd;
            } while (iEnd > 0 && arr[iEnd] > pivot);
            
            do {
                ++iStart;
            } while (iStart < arr.length && arr[iStart] < pivot);
            
            if (iStart < iEnd) {
                int temp = arr[iStart];
                arr[iStart] = arr[iEnd];
                arr[iEnd] = temp;
            } else {
                return iEnd;
            }
        }
    }

    public static void quickSortHelper(int[] arr, int iStart, int iEnd) {
        if (iStart < iEnd) {
            int p = quickSortPartition(arr, iStart, iEnd);
            quickSortHelper(arr, iStart, p);
            quickSortHelper(arr, p + 1, iEnd);
        }
    }

    public static int[] quickSort(int[] arr) {
        quickSortHelper(arr, 0, arr.length - 1);
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = new int[10];
        Random rand = new Random();
        for (int i = 0; i < 10; ++i) {
            arr[i] = rand.nextInt(100);
        }
        
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();

        long start = System.nanoTime();
        int[] sorted = quickSort(arr);
        long end = System.nanoTime();
        System.out.println((end - start) / 1000000.0 + "ms");
        for (int i : sorted) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
