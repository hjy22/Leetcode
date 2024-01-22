package String;

import java.util.HashMap;
import java.util.Map;
//https://leetcode.com/problems/decode-the-message/
public class DecodetheMessage2325E {
    public static void main(String[] args) {
        String key = "the quick brown fox jumps over the lazy dog";
        String message = "this is a secret";
        System.out.println(decodeMessage(key, message));
    }

    public static String decodeMessage(String key, String message) {
        String ans = "";
        key = key.replace(" ", "");
        Character dict = 'a';
        Map<Character, Character> map = new HashMap<>();
        for (Character c : key.toCharArray()) {
            if (!map.containsKey(c)) {
                map.put(c, dict);
                dict++;
            }
        }
        for (Character c : message.toCharArray()) {
            if (c == ' ') {
                ans += ' ';
            } else {
                ans += map.get(c);
            }
        }
        return ans;
    }
}
