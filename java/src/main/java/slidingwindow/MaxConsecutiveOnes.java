package slidingwindow;

/**
 * Since its consecutive, so we will take sliding window approach.
 * https://leetcode.com/problems/max-consecutive-ones/
 */
public class MaxConsecutiveOnes {

    static void main(){
        int[] nums = {1,1,0,0,0,1,1,1};
       System.out.println("Max consecutive 1 count="+ new MaxConsecutiveOnes().longestOnes(nums,2));
    }

    public int longestOnes(int[] nums, int k){

        int leftIndex=0;
        int zerocount=0;
        int maxLength=0;

        for(int i=0; i<nums.length ; i++){

            if(nums[i]!=1)
                zerocount++;

            while(zerocount>2){ //move the left pointer until zerocount is 2
                if(nums[leftIndex]==0)
                    zerocount--;
                leftIndex++;

            }

            maxLength=Math.max(maxLength, i-leftIndex+1);
        }
        return maxLength;
    }
}
