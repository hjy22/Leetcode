package Tiktok;

// https://leetcode.com/problems/greatest-common-divisor-of-strings/description/?envType=company&envId=tiktok&favoriteSlug=tiktok-thirty-days
public class GreatestCommonDivisorofStrings1071E {
    public static void main(String[] args) {
        String str1 = "ABABAB", str2 = "AB";
        System.out.println(gcdOfStrings(str1, str2));
    }

    public static String gcdOfStrings(String str1, String str2) {
        if(!(str1+str2).equals(str2+str1)){
            return "";
        }
        int length = gcdLength(str1.length(), str2.length());
        return str1.substring(0,length);
    }

    public static int gcdLength(int len1, int len2) {
        while (len2!=0) {
            int tmp = len2;
            len2 = len1%len2;
            len1 = tmp;
        }
        return len1;
    }
}
