package Top105;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/letter-combinations-of-a-phone-number/?envType=study-plan-v2&envId=top-interview-150
public class LetterCombinationsofaPhoneNumber17M {
    static List<String> ans = new ArrayList<>();

    public static void main(String[] args) {
        String digits = "23";
        System.out.println(letterCombinations(digits));
    }

    public static List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return ans;
        }
        String[] phone = new String[] {
                "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
        };
        String str = "";
        backtrack(digits, 0, str, phone);
        return ans;
    }

    public static void backtrack(String digits, int index, String str, String[] phone) {
        if (str.length() == digits.length()) {
            ans.add(str);
            return;
        }

        String digit = phone[digits.charAt(index) - '0'];
        for (Character c : digit.toCharArray()) {
            str += c;
            backtrack(digits, index + 1, str, phone);
            str = str.substring(0, str.length() - 1);
        }
    }

}
