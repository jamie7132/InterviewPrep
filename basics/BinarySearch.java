import java.util.Random;
import java.util.Arrays;

class BinarySearch {
   
    // Returns the index of the element or -1 if not present in the array
    // @param arr is a sorted array 
    public static int binarySearchHelper(int[] arr, int iStart, int iEnd, int key) {
        if (iEnd < iStart) {
            return -1;
        } else {
            int iMid = (iStart + iEnd) / 2;

            if (key < arr[iMid]) {
                return binarySearchHelper(arr, iStart, iMid - 1, key);
            } else if (key > arr[iMid]) {
                return binarySearchHelper(arr, iMid + 1, iEnd, key);
            } else {
                return iMid;
            }
        }
    }

    public static int binarySearch(int[] arr, int key) {
        return binarySearchHelper(arr, 0, arr.length - 1, key);
    }

    public static void main(String[] args) {
        int[] arr = new int[10];
        Random rand = new Random();
        for (int i = 0; i < 10; ++i) {
            arr[i] = rand.nextInt(100);
        }
        Arrays.sort(arr);
        
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
        int element = rand.nextInt(100);
        System.out.println(element);

        int index = binarySearch(arr, element);
        System.out.println(Integer.toString(index));

        System.out.println(binarySearch(arr, arr[0]));
        System.out.println(binarySearch(arr, arr[arr.length - 1]));
        int i = rand.nextInt(10);
        System.out.println(binarySearch(arr, arr[i]) + " " + i);
    }
}
