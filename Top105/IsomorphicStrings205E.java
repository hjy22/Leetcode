package Top105;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/isomorphic-strings/?envType=study-plan-v2&envId=top-interview-150
public class IsomorphicStrings205E {
    public static void main(String[] args) {
        String s = "badc", t = "baba";
        System.out.print(isIsomorphic(s, t));
    }

    public static boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map1 = new HashMap<>();
        Map<Character, Character> map2 = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            Character c1 = s.charAt(i);
            Character c2 = t.charAt(i);

            if(map1.containsKey(c1)){
                if(map1.get(c1)!=c2){
                    return false;
                }
            }else{
                map1.put(c1, c2);
            }

            if(map2.containsKey(c2)){
                if(map2.get(c2)!=c1){
                    return false;
                }
            }else{
                map2.put(c2, c1);
            }
        }
        return true;
    }
}
