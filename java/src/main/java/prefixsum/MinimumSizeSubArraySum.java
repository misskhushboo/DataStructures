package prefixsum;

public class MinimumSizeSubArraySum {

    static void main(){
        int[] nums = {2,7,11,15};
        int target=9;

        new MinimumSizeSubArraySum().calculate(nums);
    }

    private void calculate(int[] nums) {

        int sumSoFar=nums[0];
        int minLength=Integer.MAX_VALUE;
        int leftIndex=0, rightIndex=0;

        for(int index=0 ; index< nums.length ; index++){
            rightIndex=index+1;

            sumSoFar=nums[rightIndex]+sumSoFar;


        }
    }
}
