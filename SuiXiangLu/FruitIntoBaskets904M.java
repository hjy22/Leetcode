package SuiXiangLu;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/fruit-into-baskets/
public class FruitIntoBaskets904M {

    public static void main(String[] args) {
        int[] fruits = { 1, 2, 1 };
        System.out.println(totalFruit(fruits));
    }

    public static int totalFruit(int[] fruits) {
        int left=0,right=0;
        int max =0;
        Map<Integer,Integer> map = new HashMap<>();
        while (right<fruits.length) {
            int f1 = fruits[right];
            map.put(f1, map.getOrDefault(f1, 0)+1);
            while (map.size()>2&&left<right) {
                int f2 = fruits[left];
                map.put(f2, map.get(f2)-1);
                if(map.get(f2)==0){
                    map.remove(f2);
                }
                left++;
            }
            int num = 0;
            for(Map.Entry<Integer,Integer> entry:map.entrySet()){
                num+=entry.getValue();
            }

            max = Math.max(max, num);
            right++;
        }
        return max;
    }
}
