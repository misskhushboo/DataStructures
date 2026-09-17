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
    // int count=new LongestSubStringNoRepeatingCharacters().lengthOfLongestSubstring(" ");
    // int count=new LongestSubStringNoRepeatingCharacters().bruteForce("pwwkew");
    int count = new LongestSubStringNoRepeatingCharacters().optimizedWay("1R1T7".toCharArray());
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


    public int bruteForce(String str){
        //"abcabcbb"
        char[] ch=str.toCharArray();
        if(ch.length==1 ){ return 1; }
        if(ch.length==0 ){ return 0; }

        Set set=new HashSet<>();
        int longestSubstring=0;

        for(int i=0 ; i<ch.length-1; i++){
            int count=0;
            set.clear();
            //System.out.println("Clearing set");

            for(int j=i ; j<ch.length; j++){

                if(set.contains(ch[j])){
                    longestSubstring=Math.max(longestSubstring,count);
                    break;
                }
                set.add(ch[j]);
               // System.out.println("Different char:"+set.toString());
                count++;
            }
        }
        return longestSubstring;
    }

    //Time complexity is O(2n)= O(n)
    //Space complexity is O(min(n,k))
    public int optimizedWay(char[] ch){
        //1R1T7
        if(ch.length==1 ){ return 1; }
        if(ch.length==0 ){ return 0; }
        Set seen=new HashSet();

        int longestSubstring=0;
        int start=0;

        for(int end=0 ; end<ch.length; end++){

            while(seen.contains(ch[end])){
                seen.remove(ch[start]);         //pick characters from index 0 and remove from Set until the duplicate element exists. Keep shrinking the window.
                start++;                    //keep sliding left window and shrink window
                System.out.println("Unique substring begins from position="+start);
            }

            seen.add(ch[end]);

            longestSubstring=Math.max(longestSubstring,end-start+1);
            System.out.println("Set: "+seen.toString()+" start="+start+ " longestSubstring="+longestSubstring);
        }

        return longestSubstring;
    }
}

/**
 * end is the right edge of the window, start is the left edge.
 * The while loop shrinks the window from the left (removing characters from seen and incrementing start) until ch[end] is no longer a duplicate.
 * Then ch[end] is added to the set, and longestSubstring is updated with the current window size (end - start + 1).
 */
