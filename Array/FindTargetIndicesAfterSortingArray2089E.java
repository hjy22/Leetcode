package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/find-target-indices-after-sorting-array/
public class FindTargetIndicesAfterSortingArray2089E {
    public static void main(String[] args) {
        int[] nums = { 1,2,5,2,3};
        int target=2;
        System.out.println(targetIndices(nums,target));
    }
    public static List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> ans = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(nums[i]==target){
                ans.add(i);
            }
        }
        return ans;
    }
}
