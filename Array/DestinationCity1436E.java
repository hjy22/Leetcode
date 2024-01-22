package Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/destination-city/
public class DestinationCity1436E {
    public static void main(String[] args) {
        List<List<String>> paths = new ArrayList<>();
        System.out.println(destCity(paths));
    }

    public static String destCity(List<List<String>> paths) {
        String ans = "";
        Map<String, Integer> map = new HashMap<>();
        List<String> end = new ArrayList<>();
        for (int i = 0; i < paths.size(); i++) {
            for (int j = 0; j < paths.get(i).size(); j++) {
                String city = paths.get(i).get(j);
                if (j == 1) {
                    end.add(city);
                }
                if (map.keySet().contains(city)) {
                    map.put(city, map.get(city) + 1);
                } else {
                    map.put(city, 1);
                }
            }
        }
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            int value = entry.getValue();
            String key = entry.getKey();
            if(value==1&&end.contains(key)){
                ans = key;
            }
        }
        return ans;
    }
}
