package slidingwindow;

/**
 * Given an integer array 'nums' and an integer 'k', find the maximum sum of any contiguous subarray of size
 * exactly k.
 */
public class MaximumSumSubArrayofSizek_FixedWIndow {

    public static void main(String[] args){
        int[] nums = {2,1,5,1,3,2};
        int window=3;               //Output: 9 (subarray [5,1,3])
       new MaximumSumSubArrayofSizek_FixedWIndow().optimizedWay(nums,window);
    }

    private void optimizedWay(int[] nums, int window) {

        int max=Integer.MIN_VALUE;
        int sum=0;
        int[] subArray=new int[2];

        int leftIndex=0;
        for(int i=0;i<nums.length;i++){

            sum=sum+nums[i];

            if(i>=window-1){
                if(sum>max){
                    max=sum;
                    subArray[0]=nums[leftIndex];
                    subArray[1]=nums[i];
                    System.out.println("Max found="+max+" between elements="+subArray[0]+" || "+subArray[1]);
                }
                sum=sum-nums[leftIndex];
                leftIndex++;
            }

        }
        System.out.println("Max sum="+max+" between elements="+subArray[0]+" "+subArray[1]);
    }
}
