package prefixsum;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/subarray-sum-equals-k/
 */
public class SubArraySumEqualsK {

    static void main(){
        int[] nums = {1,2,3};
        int target=3;

        int count=new SubArraySumEqualsK().calculate(nums,target);
        System.out.println("Total count of sub array="+count);
    }

    //brute force way. O(n2).
    private int calculateViaBrute(int[] nums, int k) {
        int count=0;

        for(int i=0 ; i< nums.length-1 ; i++){
            int rightIndex=i+1;
            int sumSoFar=nums[i];

            while(rightIndex <= nums.length-1){
                sumSoFar = sumSoFar + nums[rightIndex];
                if(sumSoFar==k){
                    count++;
                    break;
                }
                rightIndex++;
            }
        }
        return count;
    }

    private int calculate(int[] nums, int targetSum) {
        Map<Integer, Integer> prefixSumCount=new HashMap<>();
        prefixSumCount.put(0,1);        //one element of 0;
        int sum=0;
        int count=0;

        for(int i=0 ; i<nums.length ; i++){
            sum=sum+nums[i];

            int find=sum-targetSum;
            int frequency=prefixSumCount.getOrDefault(find, 0);

            count+=frequency;
            prefixSumCount.merge(sum, 1, Integer::sum);
            //prefixSumCount.put(sum, prefixSumCount.getOrDefault(sum,0)+1);
        }
        return count;
    }
}
