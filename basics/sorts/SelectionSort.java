import java.util.Random;

// Runtime
// Best: O(n^2)
// Average: O(n^2)
// Worst: O(n^2)

// Space
// Worst: O(1)
class SelectionSort {
    
    public static int[] selectionSort(int[] arr) {

        for (int i = 0; i < arr.length - 1; ++i) {
            int iMin = i;

            for (int j = i + 1; j < arr.length; ++j) {
                if (arr[j] < arr[iMin]) {
                    iMin = j;
                }
            }

            if (iMin != i) {
                int temp = arr[i];
                arr[i] = arr[iMin];
                arr[iMin] = temp;
            }
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
        int[] sorted = selectionSort(arr);
        long end = System.nanoTime();
        System.out.println((end - start) / 1000000.0 + "ms");
        for (int i : sorted) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
