package String;

//https://leetcode.com/problems/remove-vowels-from-a-string/
public class RemoveVowelsfromaString1119E {
    public static void main(String[] args) {
        String s = "leetcodeisacommunityforcoders";
        System.out.println(removeVowels(s));
    }

    public static String removeVowels(String s) {
        String ans = "";
        for (char c : s.toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                continue;
            }
            ans += c;
        }
        return ans;
    }
}
