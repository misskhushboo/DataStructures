package twopointer;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicatesInUnSortedArray {

    public static void main(String[] args) {

        int[] nums={4,6,7,1,3,4,2,6};

        Set<Integer> set=new HashSet<Integer>();
        Set<Integer> duplicates=new HashSet<Integer>();

        for(int num:nums){
            //if num is not present, so add and return true. Else return false.
            if(!set.add(num)){
                duplicates.add(num);
            }

        }
        System.out.println(duplicates);

    }
}
