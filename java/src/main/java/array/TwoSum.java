package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 *Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 *
 */
public class TwoSum {

    public static void main(String args[]){
        int[] nums = {2,7,11,15};
        int target=9;
        int[] resultant=new TwoSum().twoSum(nums, target);
        System.out.println("Result indices="+ Arrays.toString(resultant).toString());
    }
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        for( int i =0 ; i<nums.length; i++){

            boolean matchFound=map.containsKey(nums[i]-target);
            if(matchFound){
                int index2=map.get(nums[i]-target);
                return new int[]{ index2, i};
            }else
                map.put(nums[i], i);
        }
        return new int[]{-1,-1};
    }
}
