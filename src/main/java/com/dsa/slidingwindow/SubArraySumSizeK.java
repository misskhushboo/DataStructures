package com.slidingwindow;

import java.util.Arrays;

/**
 * Given an array of integers nums and an integer k, return an array of sums of every contiguous subarray of size k.
 * You must use a sliding window approach to calculate the sums efficiently.
 * The result should contain n - k + 1 elements, where n is the length of nums. The i-th element of the result is the sum of nums[i..i+k-1].
 * Example 1:
 * Input: nums = [1,2,3,4,5], k = 3
 * Output: [6,9,12]
 * Explanation: The subarrays of size 3 are [1,2,3], [2,3,4], [3,4,5] with sums 6, 9, 12.
 * Example 2:
 * Input: nums = [2,-1,5,3,-2,4], k = 2
 * Output: [1,4,8,1,2]
 * Explanation: The subarrays of size 2 are [2,-1], [-1,5], [5,3], [3,-2], [-2,4] with sums 1, 4, 8, 1, 2.
 */
public class SubArraySumSizeK {

    public static void main(String[] args){
        new SubArraySumSizeK().rollingSum(new int[]{1,2,3,4,5}, 3);
    }

    private void rollingSum(int[] inputArray, int k) {

        int[] resultArray = new int[inputArray.length-k+1];

        for(int i=0; i<inputArray.length-2; i++){

            resultArray[i]=inputArray[i]+inputArray[i+1]+inputArray[i+2];
        }
        Arrays.stream(resultArray).forEach(System.out::println);
    }
}
