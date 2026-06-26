package main.java.array;

import java.util.Arrays;

/**
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 *
 * Note that you must do this in-place without making a copy of the array.
 * Input: nums = [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 *
 * if we see a non-zero element, swap it with the zero on the left.
 * nonzeroElement = represents last non-zero element. Start with -1 index.
 * Increment it only if the next element is non-zero.
 * If next element is zero, swap it with the current element.
 * But next element to nonZeroElement should always be non-zero. This is the aim.
 * This way all non-zero elements will be on the left and zeroes will be on the right.
 */
public class MoveZeros {

    public static void main(String[] args){
        int[] arr=new int[]{0,1,0,3,12,5,0};
        new MoveZeros().moveZeroes(arr);
    }

    /**
     * 0 1 0 3 12 => 1 0 0 3 12 => 1 0 0 3 12 => 1 3 0 0 12 =>
     *
     */
    private void moveZeroes(int[] ints) {
        int nonzeroElement=-1;

        for(int i=0; i<ints.length; i++){

            if(ints[i]>0){
                int temp= ints[i];
                ints[i]=ints[nonzeroElement+1];
                ints[nonzeroElement+1]=temp;
                nonzeroElement ++;
            }
        }
        System.out.println(Arrays.stream(ints).mapToObj(String::valueOf).reduce((a,b)->a+","+b).orElse(""));
    }

}
