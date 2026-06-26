package main.java.array;

/**
 * Given an integer array nums, return an array answer such that:
 * answer[i] is equal to the product of all the elements of nums except nums[i].
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 */
public class ProductOfArray {

    public static void main(String[] args){
        int[] arr=new int[]{0,1,0,3,12,5,0};
        new ProductOfArray().productArray(arr);
    }

    public void productArray(int[] arr) {
    }
}
