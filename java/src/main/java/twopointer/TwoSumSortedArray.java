package twopointer;

import java.util.Arrays;

/**
 * You are given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 * Input: nums = [2,7,11,15], target = 9
 */
public class TwoSumSortedArray {

    public static void main(String[] args){
        int[] num={2,7,11,15};
        int target=9;
        int[] result=new TwoSumSortedArray().bruteforceway(num,target);
        System.out.println("Two indices are: "+Arrays.toString(result));

        int[] optResult= new TwoSumSortedArray().optimizedWay(num, target);
        System.out.println("Optimized way: Two indices are: "+Arrays.toString(result));
    }

    //Two pointer approach as the array is sorted
    private int[] optimizedWay(int[] num, int target) {

        int[] resultant=new int[2];
        int leftIndex=0, rightIndex=num.length-1;

        while(leftIndex<rightIndex){
            int sum=num[leftIndex]+num[rightIndex];

            if( sum==target){
                resultant[0]=leftIndex;
                resultant[1]=rightIndex;
                break;
            }
            else if(sum>target){
                rightIndex--;
            }
            else
                leftIndex++;

        }
        return resultant;
    }

    private int[] bruteforceway(int[] num, int target) {
        int[] result = new int[2];

        for(int i=0;i<num.length;i++){
            for(int j=i+1;j<num.length;j++){

                if (num[i] + num[j] == target) {
                    result[0]=i;
                    result[1]=j;
                    break;
                }
            }
        }
        return result;
    }
}
