package Array;

import java.util.List;

public class CountItemsMatchingaRule1773E {
    public static void main(String[] args) {

    }

    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int ans = 0;
        int index = 0;
        switch (ruleKey) {
            case "type":
                index = 0;
                break;
            case "color":
                index = 1;
                break;
            case "name":
                index = 2;
                break;
        }
        for (List<String> list : items) {
            if (list.get(index).equals(ruleValue)) {
                ans++;
            }
        }
        return ans;
    }
}
