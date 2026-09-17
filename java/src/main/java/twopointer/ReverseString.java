package twopointer;

import java.util.concurrent.atomic.AtomicInteger;

public class ReverseString {
    /**
     * Time complexity is O(n) and space is O(n)
     * @param args
     */
    public static void main(String[] args){

        String str="This is a String";

        int size=str.length();
        StringBuffer sb=new StringBuffer(str); //StringBuffer is thread safe and hence a bit slow.

        int leftIndex=0;
        int rightIndex=size-1;

        while(leftIndex<rightIndex){

            char temp=sb.charAt(leftIndex);
            sb.setCharAt(leftIndex++,sb.charAt(rightIndex));
            sb.setCharAt(rightIndex--,temp);
        }
        System.out.println("Reversed String: "+sb.toString());
    }
}
