package DP;

//https://leetcode.com/problems/decode-ways/
public class DecodeWays91M {
    public static void main(String[] args) {
        String s = "226";
        System.out.println(numDecodings(s));
    }

    public static int numDecodings(String s) {
        int[] dp = new int[s.length()+1];
        dp[0]=1;
        dp[1]=1;
        if(s.startsWith("0")){
            return 0;
        }
        if(s.length()==1){
            return 1;
        }
        for(int i=2;i<dp.length;i++){
            if(s.charAt(i-1)-'0'!=0){
                dp[i]+=dp[i-1];
            }

            int tmp = (s.charAt(i-2)-'0')*10+s.charAt(i-1)-'0';
            if(tmp>=10&&tmp<=26){
                dp[i]+=dp[i-2];
            }
        }
        return dp[s.length()];
    }
}
