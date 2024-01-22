package String;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/jewels-and-stones/
public class JewelsandStones771E {
    public static void main(String[] args) {
        String jewels = "aA";
        String stones = "aAAbbbb";
        System.out.println(numJewelsInStones(jewels, stones));
    }

    public static int numJewelsInStones(String jewels, String stones) {
        int ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (Character c : stones.toCharArray()) {
            if (map.keySet().contains(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        for (Character c : jewels.toCharArray()) {
            if (map.containsKey(c)) {
                ans += map.get(c);
            }
        }
        return ans;
    }
}
