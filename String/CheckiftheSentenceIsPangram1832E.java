package String;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/check-if-the-sentence-is-pangram/
public class CheckiftheSentenceIsPangram1832E {
    public static void main(String[] args) {
        String sentence = "the quick brown fox jumps over the lazy dog";
        System.out.println(checkIfPangram(sentence));
    }

    public static boolean checkIfPangram(String sentence) {
        Set<Character> set = new HashSet<>();
        for(Character c:sentence.toCharArray()){
            set.add(c);
        }

        return set.size()==26;
    }
}
