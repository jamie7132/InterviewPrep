import java.util.Random;

// Runtime
// Best: O(n)
// Average: O(n^2)
// Worst: O(n^2)

// Space
// Worst: O(1)
class InsertionSort {
    
    public static int[] insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; ++i) {
            int x = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > x) {
                arr[j + 1] = arr[j];
                --j;
            }
            arr[j + 1] = x;
        }

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
        int[] sorted = insertionSort(arr);
        long end = System.nanoTime();
        System.out.println((end - start) / 1000000.0 + "ms");
        for (int i : sorted) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
