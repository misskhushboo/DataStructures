package twopointer;

import java.util.Arrays;

/**
 * Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
 * Input: nums = [1,2,3,4,5,6,7], k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 * if elements have 7 elements, after 7 iterations, we will get same array. So do modulo to avoid unnecessary iterations.
 *
 * Input: nums = [-1,-100,3,99], k = 2
 * Output: [3,99,-1,-100]
 * Explanation:
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 * Reverse (0, n-1), then Reverse (0, k-1) and then Reverse (k, n-1)
 */
public class RotateArray {

    public static void main(String[] args){
        int inputArray[]={-1,-100,3,99};

        new RotateArray().rotate(inputArray, 2);
    }

    private void rotate(int[] nums, int k) {
        int n=nums.length;
        int[] reverseArray=new int[nums.length];
        if(k>nums.length)
              k=k%nums.length;
        if(k==nums.length)
            return;

        for(int i=0;i<n;i++){
            reverseArray[i]=nums[n-1-i];
        }
        System.out.println("Result "+ Arrays.toString(reverseArray));
        for(int i=0;i<k;i++){
            nums[i]=reverseArray[k-1-i];
        }
        for(int i=k;i<n;i++){
            nums[i]=reverseArray[n-1-(i-k)];
        }

        System.out.println("Result "+ Arrays.toString(nums));
    }
}
