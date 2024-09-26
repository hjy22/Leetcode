package Top105;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/word-pattern/?envType=study-plan-v2&envId=top-interview-150
public class WordPattern290E {
    public static void main(String[] args) {
        String pattern = "abba", s = "dog dog dog dog";
        System.out.print(wordPattern(pattern, s));
    }

    public static boolean wordPattern(String pattern, String s) {
        Map<Character,String> map1 = new HashMap<>();
        Map<String,Character> map2 = new HashMap<>();
        String[] strArray = s.split(" ");

        if(pattern.length()!=strArray.length){
            return false;
        }
        
        for(int i=0;i<pattern.length();i++){
            Character c = pattern.charAt(i);
            String str = strArray[i];
            if(map1.containsKey(c)){
                if(!map1.get(c).equals(str)){
                    return false;
                }
            }else{
                map1.put(c, str);
            }

            if(map2.containsKey(str)){
                if(!map2.get(str).equals(c)){
                    return false;
                }
            }else{
                map2.put(str, c);
            }
        }

        return true;
    }
}
