package String;

//https://leetcode.com/problems/faulty-keyboard/
public class FaultyKeyboard2810E {
    public static void main(String[] args) {
        String keyboard = "string";
        System.out.println(finalString(keyboard));
    }

    public static String finalString(String s) {
        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'i') {
                ans =reverseString(ans);
            } else {
                ans += s.charAt(i);
            }
        }
        return ans;
    }

    public static String reverseString(String s) {
        char[] charArray = s.toCharArray();
        for (int i = 0, j = charArray.length - 1; i < j; i++, j--) {
            char temp = charArray[i];
            charArray[i] = charArray[j];
            charArray[j] = temp;
        }
        return new String(charArray);
    }
}
