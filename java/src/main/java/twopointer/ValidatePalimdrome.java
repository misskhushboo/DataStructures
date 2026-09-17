package twopointer;

/**
 * https://leetcode.com/problems/valid-palindrome/
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and
 * removing all non-alphanumeric characters, it reads the same forward and backward.
 * Alphanumeric characters include letters and numbers.
 * Given a string s, return true if it is a palindrome, or false otherwise.
 */
public class ValidatePalimdrome {

    static void main(){
        String s = "race a car";//"A man, a plan, a canal: Panama"; //amanaplanacanalpanama
        //String s="abae";
        //boolean status=new ValidatePalimdrome().isPalindrome(s);
        //System.out.println("String is palindrome?="+status);

        boolean statusBetter=new ValidatePalimdrome().isPalindromeOptSpace(s);
        System.out.println("String is palindrome?="+statusBetter);
    }

    //O(n) time and O(n) space for the SpringBuilder.
    //Space complexity can be optimized using 2 Pointer approach but this is also good approach.
    //Brute force approach is reverse the string and then call equals() to check all the characters.
    public boolean isPalindrome(String s) {
        char[] ch=s.toCharArray();
        StringBuilder sb=new StringBuilder();

        for(int i=0;i<ch.length;i++){
            if(isAlphanumeric(ch[i]))
                sb.append(Character.toLowerCase(ch[i]));
        }
        //System.out.println(sb);

        for(int i=0;i<sb.length()/2;i++){
            if(sb.charAt(i) != sb.charAt(sb.length()-i-1) )
                return false;
        }
        return true;
    }

    private boolean isAlphanumeric(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')|| (c >= '0' && c <= '9');
    }

    //Time O(n) and space O(1)
    public boolean isPalindromeOptSpace(String sb) {

        int j=sb.length()-1;
        for(int i=0;i<sb.length();){

            while(i<j && !isAlphanumeric(sb.charAt(i))){i++; System.out.println("i="+sb.charAt(i));}
            while(i<j && !isAlphanumeric(sb.charAt(j))){j--; System.out.println("Skipping j to="+sb.charAt(j));}

            System.out.println("comparing: " + sb.charAt(i) + " and " + sb.charAt(j));
            if (Character.toLowerCase(sb.charAt(i)) != Character.toLowerCase(sb.charAt(j))) {
                return false;
            }
            i++;
            j--;

        }
        return true;
    }




}
