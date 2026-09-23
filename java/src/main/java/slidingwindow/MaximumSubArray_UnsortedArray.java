package slidingwindow;

/**
 * Given an integer array nums, find the subarray with the largest sum, and return its sum.
 * Integers can be negative and also unsorted array.
 * If its sorted array, then we can use sliding window as 2sum/3sum problem.
 */
public class MaximumSubArray_UnsortedArray {

    public static void main(String[] args) {

        int[] nums={-2,1,-3,4,-1,2,1,-5,4};  //Max sub array sum is 6

        System.out.println("Maximum sub array sum="+ new MaximumSubArray_UnsortedArray().optimzedWay(nums));
    }

    //Time complexity is On^3. Space is O(1)
    private int bruteForce(int[] nums){
        int max=0;
        for(int i=0;i<nums.length;i++){
            for(int j=i;j<nums.length;j++){

                int sum=0;
                for(int k=i;k<=j;k++){   //Just to print the array tree structure -  -2 1, -2 1 3, -2 1 -3 4....

                    System.out.print(nums[k]+" ");

                    sum=sum+nums[k];
                    if(max<sum){
                        max=sum;
                        System.out.println("Maximum sub array sum="+max+ " start index="+i+" end index="+j);
                    }
                    //max=Math.max(max,sum);
                }

                System.out.print("\n");
            }
        }
        return max;
    }

    //Time complexity is On^2. Space is O(1). Still Brute force approach. This will not run in 1-2 second if the input size is 10^8. This will take approx 4-5 seconds.
    private int bruteForce2(int[] nums){
        int max=Integer.MIN_VALUE;
        int sum=0;
        for(int i=0;i<nums.length;i++){
            for(int j=i;j<nums.length;j++){

                sum=sum+nums[j];
                if(max<sum){
                    max=sum;
                    System.out.println("Maximum sub array sum="+max+ " start index="+i+" end index="+j);
                }
            }
            sum=0;
        }
        return max;

    }

    //Time complexity O(n)
    //int[] nums={-2,1,-3,4,-1,2,1,-5,4};
    private int optimzedWay(int[] nums){
        int max=Integer.MIN_VALUE;
        int sum=0;
        for(int i=0;i<nums.length;i++){

            if(sum<0)           //ignore the negative numbers that gives us negative sum
                sum=0;
            sum=sum+nums[i];       //compute the sum, don't stop if we are getting positive integers as the sum will increase.
            max=Math.max(max,sum); //just take the max sum so far. If max decreases going forward, it will not impact max.
        }
        return max;

    }
}
