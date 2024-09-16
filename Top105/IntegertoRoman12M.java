package Top105;

// https://leetcode.com/problems/integer-to-roman/?envType=study-plan-v2&envId=top-interview-150
public class IntegertoRoman12M {
    public static void main(String[] args) {
        int num = 3749;
        System.out.println(intToRoman(num));

    }

    public static String intToRoman(int num) {
        int[] values = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        String[] symbols = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
        String ans = "";
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                num -= values[i];
                ans += symbols[i];
            }
        }
        return ans;
    }
}
