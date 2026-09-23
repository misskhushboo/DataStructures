package slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/
 * Given two strings s and p, return an array of all the start indices of p's anagrams in s.
 * You may return the answer in any order.
 * An anagram is a word or phrase formed by rearranging the letters of another word or phrase,
 * typically using all the original letters exactly once.
 *
 *  we can sort both the strings and then can match - time complexity will be O(nlogn).
 *  We can check the length of both the strings should be same and also
 *  If we match the frequency of the elements, they will be anagrams. The complexity will be O(n)
 */
public class FindAllAnagrams {

    static void main(String[] args){
        String str = "cbaebabacd", substr = "abc";
        List<Integer> indices=new ArrayList<>();

        HashMap<Character,Integer> map=new HashMap<>();

        //create frequency map.
        for (Character ch : substr.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        HashMap<Character,Integer> seen=new HashMap<>();
        int subStrLen=substr.length();

        for(int i=0;i<str.length();i++){

            char ch=str.charAt(i);
            seen.put(ch,seen.getOrDefault(ch,0)+1);
            System.out.println("Seen="+ch);

            if(i>=subStrLen){                           //once we populate seen with the window size=substring, then slide the window and remove the left most character.
                char outChar=str.charAt(i-subStrLen);   //3-3=0, when i is 3 which is 4th character, then remove 0th char.
                int count=seen.get(outChar);

                if(count==1)seen.remove(outChar);
                else seen.put(outChar, count-1);
                System.out.println("Decreasing count of char="+outChar+" count="+(count-1));
            }
            if(i>=subStrLen-1 && map.equals(seen)){      //when i=2 and subStrlen=3, from now onwards, the comparison should happen in every iteration.
                indices.add(i-subStrLen+1);             //add charAt[2-3+1] = charAt[0] if first three chars are anagram.
            }
        }

        System.out.println("All indices="+indices);
    }
}
