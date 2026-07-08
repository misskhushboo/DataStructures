package twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given an integer array nums, return all the triplets.
No duplicate Triplets.
[nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
https://leetcode.com/problems/3sum/description/
Brute force approach is n3 -> the key to unlock this complexity is sort the array first.
Duplicates can be skipped ->Values sit next to each other in sorted array.
Use two pointer approach, infact 3 pointer approach.

Time Complexity:
sorting is O(n log n). Quicksort.
the outer loop is O(n), and for each i the two-pointer scan is O(n) → O(n²) total, which dominates the sort. So overall O(n²).
Add: O(n log n) + O(n2) = Larger wins or dominates for big n. n2 grows much faster than nlogn.
So nlogn gets absorbed by n2.

Space complexity= how much extra memory does the algorithm use beyond the input itself as a function of n.

*/
public class ThreeSumProblem {

    public static void main(String args[]){
        int[] nums = {-1,0,1,2,-1,-4};
        int target=0;
        List<List<Integer>> resultant=new ThreeSumProblem().threeSum(nums, target);
        System.out.println("Result indices="+ resultant.toString());
    }
    public List<List<Integer>> threeSum(int[] nums, int target) {

        Arrays.sort(nums);
        List<List<Integer>> result=new ArrayList<>();

        for(int i=0 ; i<nums.length-2; i++){

            int leftIndex=i+1;
            int endIndex=nums.length-1;

            if(i>0 && nums[i]==nums[i-1]) continue;

            while(leftIndex<endIndex){
                int total=nums[i]+nums[leftIndex]+nums[endIndex];
                if(total==0){
                    result.add(Arrays.asList(nums[i], nums[leftIndex], nums[endIndex]));
                    leftIndex++;
                    endIndex--;

                    //Try this: [-2 -2 0 0 2 2]
                    //We don't want to include repeated number and call contains().
                    //This step eliminates contains and duplcates are avoided
                    while(leftIndex<endIndex && nums[leftIndex]==nums[leftIndex-1]) leftIndex++;
                    while(endIndex>leftIndex && nums[endIndex]==nums[endIndex+1]) endIndex--;
                }
                else if(total<0) leftIndex++;
                else endIndex--;
            }


        }
        return result;
    }
}
