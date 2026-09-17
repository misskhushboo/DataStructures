package prefixsum;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/subarray-sum-equals-k/
 * Use hashmap having <prefixum and count>
 *
 */
public class SubArraySumEqualsK_UnsortedArray {

    static void main(){
        int[] nums = {1,2,3};
        int target=3;

        int count=new SubArraySumEqualsK_UnsortedArray().calculate(nums,target);
        System.out.println("Total count of sub array="+count);
    }

    //brute force way. O(n2).
    private int calculateViaBrute(int[] nums, int k) {
        int count=0;

        for(int i=0 ; i< nums.length-1 ; i++){

            int sumSoFar=0;

            for( int rightIndex=i+1; rightIndex <= nums.length-1; rightIndex++){
                sumSoFar = sumSoFar + nums[rightIndex];
                if(sumSoFar==k) count++;
            }
        }
        return count;
    }

    //Time complexity is O(n) and space is O(n) for hashmap can contain utmost n elements.
    private int calculate(int[] nums, int targetSum) {
        Map<Integer, Integer> map=new HashMap<>();
        map.put(0,1);        //one element of 0;
        int sum=0;
        int count=0;

        for(int i=0 ; i<nums.length ; i++){
            sum=sum+nums[i];

            int find=sum-targetSum;

            if(map.containsKey(find)){
                System.out.println("Got prefixed sum so target exists:"+map.get(find));
                count+=map.get(find);
            }
            System.out.println("Saving sum:"+sum);
            //map.merge(sum, 1, Integer::sum);
            map.put(sum, map.getOrDefault(sum,0)+1);
        }
        return count;
    }
}
/**
 * On each iteration add the new element to the sum and add
 * this prefix to the Hashmap.
 * We are maintaining every prefix count, how many times we have a prefix sum.
 *  int[] nums = {1,2,3};
 *
 * Saving sum:1
 *
 * For 2+1=3 and 3-3=0| 0 exists-> Got prefixed sum so target exists:1
 * Saving sum:3
 *
 * For 6-3=3 | Again 3 exists| Got prefixed sum so target exists:1
 * Saving sum:6
 * Total count of sub array=2
 */
