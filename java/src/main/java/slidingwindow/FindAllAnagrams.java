package slidingwindow;

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
       String s = "cbaebabacd", p = "abc";
        new FindAllAnagrams().findAnagram(s,p);
    }

    private void findAnagram(String s, String p){

    }
}
