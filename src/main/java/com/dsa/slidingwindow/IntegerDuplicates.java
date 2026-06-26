package com.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an integer array nums and an integer k,
 * return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.
 *
 Input: nums = [1,2,3,1], k = 3
 Output: true
 Explanation: nums[0] == nums[3] and abs(0 - 3) == 3 which is <= 3, so return true.
 */
public class IntegerDuplicates {

    public static void main(String[] args){
        new IntegerDuplicates().findDuplicates(new int[]{1,2,3,4,5,6,2,8,9}, 5);
    }

    private void findDuplicates(int[] inputArray, int bracket) {

        Map<Integer, Integer> map=new HashMap<>();

        for(int i=0; i<inputArray.length; i++ ){

            if(map.containsKey(inputArray[i])){
               int oldIndex= map.get(inputArray[i]);

                if(i-oldIndex<=bracket){
                    System.out.println("Duplicate found "+inputArray[i]);
                    break;
                }
            }
            map.put(inputArray[i], i);
            if(map.size()>bracket)
                map.remove(inputArray[i-bracket]);
            map.entrySet().stream().forEach(e-> System.out.println(e.getKey()+" | "+e.getValue() +"\n"));
            System.out.println("-------------");
        }
    }
}
