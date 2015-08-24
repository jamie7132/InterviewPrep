import java.util.Random;

// Runtime
// Best: O(n)
// Average: O(n^2)
// Worst: O(n^2)

// Space: O(1)
class BubbleSort {
    
    public static int[] bubbleSort(int[] arr) {
        boolean done;
        
        do {
            done = true;
            
            for (int i = 1; i < arr.length; ++i) {
                if (arr[i-1] > arr[i]) {
                    //fuck java and it's pass by value - would use swap fn in c++
                    int temp = arr[i];
                    arr[i] = arr[i-1];
                    arr[i-1] = temp;
                    done = false;
                }
            }
        } while (!done);

        return arr;
    }

   public static int[] smartBubbleSort(int[] arr) {
        int len = arr.length;
        boolean done;
        
        do {
            done = true;

            for (int i = 1; i < len; ++i) {
                if (arr[i-1] > arr[i]) {
                    int temp = arr[i];
                    arr[i] = arr[i-1];
                    arr[i-1] = temp;
                    done = false;
                }
            }
        } while (!done);

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
        int[] sorted = bubbleSort(arr);
        long end = System.nanoTime();
        System.out.println((end - start) / 1000000.0 + "ms");
        for (int i : sorted) {
            System.out.print(i + " ");
        }
        System.out.println();

        start = System.nanoTime();
        int[] smartSorted = smartBubbleSort(arr);
        end = System.nanoTime();
        System.out.println((end - start) / 1000000.0 + "ms");
        for (int i : smartSorted) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
