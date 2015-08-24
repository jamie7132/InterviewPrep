import java.util.Random;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.lang.Math;

// Runtime
// Best: O(nk)
// Average: O(nk)
// Worst: O(nk)

// Space
// Worst: O(n+k)
class RadixSort {
    
    public static int[] radixSort(int[] arr) {
        ArrayList<ArrayDeque<Integer>> digits = new ArrayList<ArrayDeque<Integer>>();
        for (int d = 0; d < 10; ++d) {
            digits.add(new ArrayDeque<Integer>());
        }

        // Assuming numbers in the array are less than 1000
        double maxLength = 3.0;

        for (double p = 0.0; p < maxLength; p += 1.0) {
            // Sort the entries into their buckets based upon the digit in question, going least to most significant digit
            for (int i = 0; i < arr.length && digits.size() == 10; ++i) {
                if ((arr[i] / (int) (Math.pow(10.0, p))) % 10 == 0) {
                    digits.get(0).add(arr[i]);
                } else if ((arr[i] / (int) (Math.pow(10.0, p))) % 10 == 1) {
                    digits.get(1).add(arr[i]);
                } else if ((arr[i] / (int) (Math.pow(10.0, p))) % 10 == 2) {
                    digits.get(2).add(arr[i]);
                } else if ((arr[i] / (int) (Math.pow(10.0, p))) % 10 == 3) {
                    digits.get(3).add(arr[i]);
                } else if ((arr[i] / (int) (Math.pow(10.0, p))) % 10 == 4) {
                    digits.get(4).add(arr[i]);
                } else if ((arr[i] / (int) (Math.pow(10.0, p))) % 10 == 5) {
                    digits.get(5).add(arr[i]);
                } else if ((arr[i] / (int) (Math.pow(10.0, p))) % 10 == 6) {
                    digits.get(6).add(arr[i]);
                } else if ((arr[i] / (int) (Math.pow(10.0, p))) % 10 == 7) {
                    digits.get(7).add(arr[i]);
                } else if ((arr[i] / (int) (Math.pow(10.0, p))) % 10 == 8) {
                    digits.get(8).add(arr[i]);
                } else if ((arr[i] / (int) (Math.pow(10.0, p))) % 10 == 9) {
                    digits.get(9).add(arr[i]);
                }
            }
            
            // Merge the queues back together
            int n = 0;
            for (int d = 0; d < 10 && n < arr.length; ++d) {
                while (!digits.get(d).isEmpty()) {
                    arr[n++] = digits.get(d).remove();
                }
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] arr = new int[10];
        Random rand = new Random();
        for (int i = 0; i < 10; ++i) {
            arr[i] = rand.nextInt(1000);
        }
        
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();

        long start = System.nanoTime();
        int[] sorted = radixSort(arr);
        long end = System.nanoTime();
        System.out.println((end - start) / 1000000.0 + "ms");
        for (int i : sorted) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
