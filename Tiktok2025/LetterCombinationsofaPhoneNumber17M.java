package Tiktok2025;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
public class LetterCombinationsofaPhoneNumber17M {
    static List<String> ans = new ArrayList<>();

    public static void main(String[] args) {
        String digits = "23";
        System.out.println(letterCombinations(digits));
    }

    public static List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) {
            return ans; 
        }
        String[] phone = new String[] {
                "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
        };
        backTrack(digits, "", 0, phone);
        return ans;
    }

    public static void backTrack(String digits, String str, int start, String[] phone) {
        if (str.length() == digits.length()) {
            ans.add(str);
            return;
        }
        char c = digits.charAt(start);
        for (Character character : phone[c - '0'].toCharArray()) {
            backTrack(digits, str+character, start+1, phone);
        }
    }
}
