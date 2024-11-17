package Google;

// https://leetcode.com/problems/minimum-number-of-changes-to-make-binary-string-beautiful/?envType=company&envId=google&favoriteSlug=google-thirty-days
public class MinimumNumberofChangestoMakeBinaryStringBeautiful2914M {
    public static void main(String[] args) {
        String s = "1001";
        System.out.println(minChanges(s));
    }

    public static int minChanges(String s) {
        int count=0;
        for(int i=0;i<s.length();i+=2){
            if(s.charAt(i)!=s.charAt(i+1)){
                count++;
            }
        }
        return count;
    }
}
