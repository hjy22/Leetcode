package Array;

// https://leetcode.com/problems/greatest-common-divisor-of-strings/
public class GreatestCommonDivisorofStrings1071E {
    public static void main(String[] args) {
        String str1 = "ABCABC", str2 = "ABC";
        System.out.println(gcdOfStrings(str1, str2));
    }

    public static String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
            
        }
        int gcdLength = gcd(str1.length(), str2.length());
            return str1.substring(0, gcdLength);
    }

    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
