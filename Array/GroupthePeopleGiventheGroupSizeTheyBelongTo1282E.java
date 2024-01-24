package Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/group-the-people-given-the-group-size-they-belong-to/
public class GroupthePeopleGiventheGroupSizeTheyBelongTo1282E {
    public static void main(String[] args) {
        int[] groupSizes = { 3, 3, 3, 3, 3, 1, 3 };
        System.out.println(groupThePeople(groupSizes));
    }

    public static List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> saveGroup = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            saveGroup.add(groupSizes[i]);
            if (map.containsKey(groupSizes[i])) {
                map.put(groupSizes[i], map.get(groupSizes[i]) + 1);
            } else {
                map.put(groupSizes[i], 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer count = entry.getValue();
            Integer num = entry.getKey();
            int times = count / num;
            count = num;
            while (times > 0) {
                List<Integer> temp = new ArrayList<>();
                while (count > 0) {
                    temp.add(saveGroup.indexOf(num));
                    saveGroup.set(saveGroup.indexOf(num), -1);
                    count--;
                }
                count = num;
                ans.add(temp);
                times--;
            }

        }
        return ans;
    }
}
