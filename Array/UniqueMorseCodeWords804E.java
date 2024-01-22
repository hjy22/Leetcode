package Array;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/unique-morse-code-words/
public class UniqueMorseCodeWords804E {
    public static void main(String[] args) {
        String[] words = { "gin", "zen", "gig", "msg" };
        System.out.println(uniqueMorseRepresentations(words));
    }

    public static int uniqueMorseRepresentations(String[] words) {
        Set<String> ans = new HashSet<>();
        String[] morseArray = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..",
                "--",
                "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.." };
        for (String s : words) {
            String morse = "";
            for (Character c : s.toCharArray()) {
                int index = c - 'a';
                morse += morseArray[index];
            }
            ans.add(morse);
        }
        return ans.size();
    }
}
