/*
Write an efficient program to find the sum of contiguous subarray within a one-dimensional array of numbers which has the largest sum.
e.e A = [-2, -3, 4, -1, -2, 1, 5, -3]
answer = 4 + (-1) + (-2) + 1 + 5 = 7;
 */
package google.phoneinterview;

/**
 *
 * @author Tesfay
 */
public class LargestSubArraySum {

    public static void main(String[] args){
        
        System.out.println(largestSumOfContigiousSubArray(new int[]{-2,-3,4,-1,-2,1,5,-3}));
    }
    // Kadane's algorithm
    public static int largestSumOfContigiousSubArray(int[] a) {

        int maxSoFar = 0;
        int maxEndingHere = 0;

        for (int i = 0; i < a.length; i++) {
            maxEndingHere += a[i];

            if (maxEndingHere < 0) {
                maxEndingHere = 0;
                continue;
            }
            
            if(maxEndingHere > maxSoFar)
                maxSoFar = maxEndingHere;
        }
        return maxSoFar;
    }
}
