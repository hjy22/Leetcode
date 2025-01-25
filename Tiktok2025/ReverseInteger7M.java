package Tiktok2025;

// https://leetcode.com/problems/reverse-integer/
public class ReverseInteger7M {
    public static void main(String[] args) {
        int x = -123;
        System.out.println(reverse(x));
    }

    public static int reverse(int x) {
        int ans = 0;
        while (x != 0) {
            int lastDigit = x % 10;
            x = x / 10;
            if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && lastDigit > 7)) {
                return 0;
            }
            if (ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE / 10 && lastDigit < -8)) {
                return 0;
            }
            ans = ans * 10 + lastDigit;
        }
        return ans;
    }
}
