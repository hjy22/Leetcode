package Tiktok2025.Tiktok202504;

// https://leetcode.com/problems/valid-parenthesis-string/?envType=company&envId=tiktok&favoriteSlug=tiktok-three-months
public class ValidParenthesisString678M {
    public static void main(String[] args) {
        String s = "()";
        System.out.println(checkValidString(s));
    }

    public static boolean checkValidString(String s) {
        int low = 0,high=0;
        for(Character c:s.toCharArray()){
            if(c=='('){
                low++;
                high++;
            }else if(c==')'){
                low--;
                high--;
            }else if(c=='*'){
                low--;
                high++;
            }
            if(high<0){
                return false;
            }
            low = Math.max(low, 0);
        }
        return low==0;
    }

}
