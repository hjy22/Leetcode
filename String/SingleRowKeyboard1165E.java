package String;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/single-row-keyboard/
public class SingleRowKeyboard1165E {
    public static void main(String[] args) {
        String keyboard = "abcdefghijklmnopqrstuvwxyz";
        String word = "cba";
        System.out.println(calculateTime(keyboard, word));
    }

    public static int calculateTime(String keyboard, String word) {
        int ans = 0;
        List<Character> list = new ArrayList<>();
        for(Character c:keyboard.toCharArray()){
            list.add(c);
        }
        int last = 0;
        for (Character c : word.toCharArray()) {
            int index= list.indexOf(c);
            ans += Math.abs(index - last);
            last = index;
        }
        return ans;
    }
}
