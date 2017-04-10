/*
*Given a sorted array consisting of only integers where every element appears 
*twice except for one element which appears once. Find this single element that appears only once.
*/
package algorithm.singleelement;

/**
 *
 * @author Tesfay
 */
public class SingleElementSortedArray {

    public static int singleNonDuplicate(int[] nums) {
        int result = nums[0];
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            if (nums[i] == nums[i + 1]) {
                i += 2;
            } else {
                return nums[i];
            }

            if (nums[j] == nums[j - 1]) {
                j -= 2;
            } else {
                return nums[j];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(singleNonDuplicate(new int[]{2, 2, 3, 3, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9}));
        System.out.println(singleNonDuplicate(new int[]{2}));
        System.out.println(singleNonDuplicate(new int[]{2, 2, 3, 3}));
        System.out.println(singleNonDuplicate(new int[]{2, 2}));
        System.out.println(singleNonDuplicate(new int[]{2,2,3,3,4,4,5,5,6,6,7,7,8,8,9,9,10}));
    }
}
