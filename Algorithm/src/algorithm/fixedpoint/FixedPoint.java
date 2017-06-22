/*
 * Interview Question. Give a o(n) (“little-oh”) algorithm for determining whether a
sorted array A containing n distinct integers contains an element m for which
A[m] = m. You must also provide a proof that your algorithm runs in o(n) time.
 */
package algorithm.fixedpoint;
/**
 *
 * @author Tesfay
 */
public class FixedPoint {

    public static void main(String[] args) {
        System.out.println(gitFixedPoint(new int[]{-1, -11, 2, -2}));
        System.out.println(gitFixedPoint(new int[]{0}));
    }

    public static boolean gitFixedPoint(int[] arr) {
       return binarySearch(arr, 0, arr.length - 1) > -1;
    }

    public static int binarySearch(int arr[], int low, int high) {
        if (high >= low) {
            int mid = (low + high) / 2;
            /*low + (high - low)/2;*/
            if (mid == arr[mid]) {
                return mid;
            }
            if (mid > arr[mid]) {
                return binarySearch(arr, (mid + 1), high);
            } else {
                return binarySearch(arr, low, (mid - 1));
            }
        }

        /* Return -1 if there is no Fixed Point */
        return -1;
    }

}
