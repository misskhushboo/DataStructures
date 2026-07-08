package slidingwindow;

/**
 * https://leetcode.com/problems/minimum-window-substring/description/
 */
public class MinimumWindowSusbstring {

    static void main(){
        String word=new MinimumWindowSusbstring().minimumWindow("ADOBECODEBANC","ABC");
        System.out.println("Minimum string="+word);
    }
    private String minimumWindow(String s1, String s2){

        int left=0;
        StringBuilder mininumStr=new StringBuilder();

        for(int i=0 ; i<s1.length() ; i++){

            if(s2.contains(((Character) s1.charAt(i)).toString())){
                mininumStr.append(s1.charAt(i));
                left=i;
            }
            else{
                mininumStr.delete(0, mininumStr.length()-1);
            }

        }

        return mininumStr.toString();

    }
}
