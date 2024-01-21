package Array;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/decompress-run-length-encoded-list/
public class DecompressRunLengthEncodedList1313E {
    public static void main(String[] args) {
        int[] nums = { 5, 7, 7, 8, 8, 10 };
        System.out.println(decompressRLElist(nums));
    }

    public static int[] decompressRLElist(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i += 2) {
            int times = nums[i];
            while (times > 0) {
                list.add(nums[i + 1]);
                times--;
            }
        }
        int[] ans = covertToArray(list);
        return ans;
    }

    public static int[] covertToArray(List<Integer> list) {
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}
