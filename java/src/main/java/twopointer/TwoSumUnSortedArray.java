package twopointer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * You are given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 * Input: nums = [3,2,4], target = 6
 *
 * Since it's an unsorted array, I cannot sort as that will scramble their indices. So I cannot use Two pointer approach.
 * I will use HashMap.
 */
public class TwoSumUnSortedArray {

    public static void main(String[] args){

        /*int[] num={2,7,11,15};
        int target=17;*/
        int[] num={3,2,0,1,5};
        int target=6;
        int[] result=new TwoSumUnSortedArray().bruteforceway(num,target);
        System.out.println("Two indices are: "+Arrays.toString(result));

        int[] optResult= new TwoSumUnSortedArray().optimizedWay(num, target);
        System.out.println("Optimized way: Two indices are: "+Arrays.toString(optResult));
    }

    /**
     * Time complexity is O(n)
     * Space complexity is O(n) for worst case. All elements will be stored in the Hashmap.
     */
    private int[] optimizedWay(int[] num, int target) {

        Map<Integer,Integer> seenBefore=new HashMap<>();

        for(int i=0;i<num.length;i++){

            int x=target-num[i];
            if(seenBefore.containsKey(x)){
                return new int[]{seenBefore.get(x),i};
            }else
                seenBefore.put(num[i],i); //if lets say 3 appears to be twice, this will override the last index.
        }
        return new int[]{-1,-1};
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
