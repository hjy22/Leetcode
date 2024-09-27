package Top105;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/summary-ranges/description/?envType=study-plan-v2&envId=top-interview-150
public class SummaryRanges228E {
    public static void main(String[] args) {
        int[] nums = { 0, 1, 2, 4, 5, 7 };
        System.out.println(summaryRanges(nums));
    }

    public static List<String> summaryRanges(int[] nums) {
        int n = nums.length;
        List<String> list = new ArrayList<>();
        if (n == 0)
            return list; 

        int start = 0;
        for (int end = 1; end <= n; end++) {
            if (end == n || nums[end] != nums[end - 1] + 1) {
                if (start == end - 1) {
                    list.add(String.valueOf(nums[start]));
                } else {
                    list.add(nums[start] + "->" + nums[end - 1]);
                }
                start = end; 
            }
        }
        return list;
    }
}
