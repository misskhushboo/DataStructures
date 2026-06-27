package array;

import java.util.Arrays;

/*
Given an integer array nums, return all the triplets
[nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
https://leetcode.com/problems/3sum/description/
*/
public class ThreeSumProblem {

    public static void main(String args[]){
        int[] nums = {-1,0,1,2,-1,-4};
        int target=0;
        int[][] resultant=new ThreeSumProblem().threeSum(nums, target);
        System.out.println("Result indices="+ Arrays.toString(resultant));
    }
    public int[][] threeSum(int[] nums, int target) {

        int[][] resultant=new int[][]{};
        int resultantArrayIndex=0;
        for(int i=0 ; i<nums.length-3; i++){

            int leftIndex=i+1;
            int endIndex=nums.length-1;

            while(leftIndex<endIndex){
                while(nums[i]==nums[leftIndex]) leftIndex++;

                while(nums[i]==nums[endIndex]) endIndex--;

                while(nums[leftIndex]==nums[endIndex]) endIndex--;

                if(nums[i]+nums[leftIndex]+nums[endIndex]==0){
                    resultant[resultantArrayIndex]=new int[]{nums[i],nums[leftIndex],nums[endIndex]};
                    resultantArrayIndex++;
                    System.out.println("Added to array: "+nums[i]+ " "+nums[leftIndex]+" "+nums[endIndex]);
                }
                leftIndex++;
            }

        }
        return resultant;
    }
}
