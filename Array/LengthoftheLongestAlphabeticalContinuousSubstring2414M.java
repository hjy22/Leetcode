package Array;

// https://leetcode.com/problems/length-of-the-longest-alphabetical-continuous-substring/
public class LengthoftheLongestAlphabeticalContinuousSubstring2414M {
    public static void main(String[] args) {
        String s = "abacaba";
        System.out.println(longestContinuousSubstring(s));
    }

    public static int longestContinuousSubstring(String s) {
        int maxLen =1;
        int currentLength = 1;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)-s.charAt(i-1)==1){
                currentLength++;
            }else{
                maxLen = Math.max(maxLen, currentLength);
                currentLength=1;
            }
        }
        return Math.max(maxLen, currentLength); 
    }
}
