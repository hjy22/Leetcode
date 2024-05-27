package Array;

import java.util.HashMap;
import java.util.Map;

/*
 * 将0视为-1，1视为1，这样问题就转化为在数组中找到和为0的最长子数组。
 */
//https://leetcode.com/problems/contiguous-array/
public class ContiguousArray525M {
    public static void main(String[] args) {
        int[] nums= {0,1,1};
        System.out.println(findMaxLength(nums));
    }

    public static int findMaxLength(int[] nums) {
        int[] sumArray = new int[nums.length+1];
        sumArray[0]=0;
        for(int i=1; i<sumArray.length; i++){
            sumArray[i] = sumArray[i-1] + (nums[i-1] == 0 ? -1 : 1);
            System.out.println(sumArray[i]);
        }
        // 前缀和到索引的映射，方便快速查找所需的前缀和
        HashMap<Integer, Integer> valToIndex = new HashMap<>();
        int maxLength = 0;

        //把出现的index存在map里，若第二次出现，就从map中取上一次出现的index
        for (int i = 0; i < sumArray.length; i++) {
            if (!valToIndex.containsKey(sumArray[i])) {
                valToIndex.put(sumArray[i], i);
            } else {
                maxLength = Math.max(maxLength, i - valToIndex.get(sumArray[i]));
            }
        }
        return maxLength;
    }
}
