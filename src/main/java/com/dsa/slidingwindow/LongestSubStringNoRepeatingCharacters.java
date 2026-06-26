package com.slidingwindow;

import java.util.HashSet;
import java.util.Set;

/**
 * Write a program to determine the length of the longest substring without repeating characters, given a string s.
 * Example 1:
 * Input: s = "xyxyxz"
 * Output: 3
 * Explanation: The answer is "yxz", with a length of 3.
 * Example 2:
 * Input: s = "aaaaa"
 * Output: 1
 * Explanation: The answer is "a", with a length of 1.
 * Example 3:
 * Input: s = "ababcde"
 * Output: 5
 * Explanation: The answer is "abcde", with a length of 5.
 * Note that "ababc" is not a valid substring since characters are repeated.
 */
public class LongestSubStringNoRepeatingCharacters {

    public static void main(String[] args){
        new LongestSubStringNoRepeatingCharacters().calculate("xyxyxz");
    }

    private void calculate(String inputStr) {

        int windowStart=0, maxLength=0;
        Set<Character> charSet = new HashSet<>();
       char[] inputCharArray = inputStr.toCharArray();

       for(int i=0; i<=inputStr.length(); i++){

           windowStart=i;
           char c= inputCharArray[i];
           if(charSet.contains(c)){
               windowStart=i;
               charSet.clear();
           }else{
            charSet.add(c);
           }

           if(charSet.contains(c)){

           }
           charSet.add(c);
       }
    }

}
