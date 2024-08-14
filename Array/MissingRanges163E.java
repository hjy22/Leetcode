package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/missing-ranges
public class MissingRanges163E {
    public static void main(String[] args) {
        int[] nums = {0,1,3,50,75};
        int lower=0,  upper=99;
        System.out.println(findMissingRanges(nums,lower, upper));
    }

    public static List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        int start=lower;
        List<List<Integer>> list = new ArrayList<>();
        for (int cur : nums) {
            if(start==cur){
                start++;
            }else{
                list.add(Arrays.asList(start, cur-1));
                start=cur+1;
            }
        }
        if (start <= upper) list.add(Arrays.asList(start, upper));

        return list;
    }
}
