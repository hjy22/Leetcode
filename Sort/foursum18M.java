package Sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class foursum18M {
    public static void main(String[] args) {
        int[] nums = {1,0,-1,0,-2,2,-0};
        System.out.println(fourSum(nums,0));
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Set<List<Integer>> answerArray = new HashSet<>();
        if(nums.length<4){
            return new ArrayList<>();
        }
        for(int i=0;i<nums.length-1;i++){
            int answer1 = nums[i];
            int answer2 =0;
            for(int j=i+1;j<nums.length;j++){
                answer2 = nums[j];
                List<List<Integer>>tempArray = new ArrayList<>();
                long new_target = target-(long)answer1-(long)answer2;
                if (new_target <= Integer.MIN_VALUE || new_target >= Integer.MAX_VALUE) {
                    return new ArrayList<>();
                }
                tempArray = twoSum(nums,j,(int)new_target,answer1,answer2);

                for(List<Integer> item:tempArray){
                    answerArray.add(item);
                }
            }
        }
        return new ArrayList<>(answerArray);
    }

    static List<List<Integer>> twoSum(int[] nums, int index, int target,int ans1,int ans2){
        List<List<Integer>> wholeList = new ArrayList<>();
        Map<Integer, Integer> numMap = new HashMap<>();
        for(int i =index+1;i<nums.length;i++){
            numMap.put(nums[i],i);
        }
        for(int i = index+1;i<nums.length;i++){
            int part = target - nums[i];
            if(numMap.containsKey(part) && numMap.get(part) != i){
                List<Integer> tempList = new ArrayList<>();
                tempList.add(ans1);
                tempList.add(ans2);
                tempList.add(nums[i]);
                tempList.add(part);
                Collections.sort(tempList);
                wholeList.add(tempList);
            }
        }
        return wholeList;
    }
}
