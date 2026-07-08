package main.java.slidingwindow;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
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
        int count=new LongestSubStringNoRepeatingCharacters().lengthOfLongestSubstring(" ");
        System.out.println("Count="+count);
    }

    public int lengthOfLongestSubstring(String s) {

        int leftpointer=0, maxLength=0;
        Set<Character> charSet = new HashSet<>();
        char[] ch = s.toCharArray();

        for(int i=0; i<ch.length; i++){

            while(charSet.contains(ch[i])){
                charSet.remove(ch[leftpointer]);
                leftpointer++;
            }
            charSet.add(ch[i]);
            maxLength=Math.max(maxLength, i-leftpointer+1);
        }
        return maxLength;
    }

}
