package Tiktok2025;

// https://leetcode.com/problems/plus-one/?envType=company&envId=tiktok&favoriteSlug=tiktok-six-months
public class PlusOne66E {
    public static void main(String[] args) {
        int[] digits = { 1, 2, 3 };
        System.out.println(plusOne(digits));
    }

    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] newDigits = new int[digits.length + 1];
        newDigits[0] = 1;
        return newDigits;
    }
}
