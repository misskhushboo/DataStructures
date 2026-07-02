package twopointer;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once.
 * The relative order of the elements should be kept the same.
 * Consider the number of unique elements in nums to be k. After removing duplicates, return the number of unique elements k.
 * The first k elements of nums should contain the unique numbers in sorted order. The remaining elements beyond index k - 1 can be ignored.
 https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 O(n) time complexity and O(1) space
 */
public class RemoveDuplicatesInSortedArray {

    static void main(){

        int[] nums={0,0,1,1,1,2,2,3,3,4};
        int k=new RemoveDuplicatesInSortedArray().removeDuplicates(nums);
        System.out.println("Number of unique elements= "+k);
    }

    public int removeDuplicates(int[] nums) {

        int leftIndex=0;
        if(nums.length==0) return 0;
        if(nums.length==1) return 1;

        int count=1;
        for(int i=1 ; i <=nums.length-1 ; i++){

            //The array is sorted so duplicates are always adjacent.
            if(nums[i]!=nums[leftIndex]){
                count++;
                int temp=nums[leftIndex+1];
                nums[leftIndex+1]=nums[i];
                nums[i]=temp;

                leftIndex++;
            }

        }
        System.out.println("Unique elements= "+count);
        return count;
    }

    /**
     * Since it doesn't matter what elements are there after k unique elements, we can just override elements
     * Time = 1 ms. For above code running time is 5 ms. Time is taken in swapping elements which is not needed.
     * @param nums
     * @return
     */
    public int removeDuplicates1(int[] nums) {
        if(nums.length ==0){
            return 0;
        }
        int i=0;
        for(int j=1;j<nums.length;j++){
            if(nums[i] != nums[j]){
                i++;
                nums[i]=nums[j];
            }
        }
        return i+1;
    }


}
