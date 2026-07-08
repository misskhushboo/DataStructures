package twopointer;

/**
 * https://leetcode.com/problems/valid-palindrome/
 */
public class ValidatePalimdrome {

    static void main(){
        //String s = "A man, a plan, a canal: Panama";
        String s="abae";
        boolean status=new ValidatePalimdrome().isPalindrome(s);
        System.out.println("String is palindrome?="+status);
    }

    public boolean isPalindrome(String s) {
        char[] ch=s.toCharArray();
        int j=ch.length-1;
        int i=0;

        while(i<j){

            if(ch[i]!=ch[j])
                return false;
            i++;
            j--;
        }
        return true;
    }
}
