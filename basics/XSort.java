import java.util.Random;

// Runtime
// Best:
// Average: 
// Worst: 

// Space
// Worst:
class XSort {
    
    public static int[] xSort(int[] arr) {
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
        int[] sorted = xSort(arr);
        long end = System.nanoTime();
        System.out.println((end - start) / 1000000.0 + "ms");
        for (int i : sorted) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
