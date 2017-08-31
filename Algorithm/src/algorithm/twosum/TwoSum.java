/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm.twosum;

/**
 *
 * @author Tesfay
 */
public class TwoSum {
    
    public int[] twoSum(int[] nums, int target)
    {
        for(int i = 0 ; i < nums.length; i++){
            for(int j = i + 1 ; j < nums.length; j++){
                if(nums[i] + nums[j] == target)
                    return new int[] {i, j};
            }
        }
        throw new IllegalArgumentException("Array doesn't have elements that sum up to the target");
    }
    
}
