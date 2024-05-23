package Array;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/contiguous-array/
public class ContiguousArray525M {
    public static void main(String[] args) {
        int[] nums= {0,1,1};
        System.out.println(findMaxLength(nums));
    }

    public static int findMaxLength(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i:nums){
            map.put(i,map.getOrDefault(i, 0)+1);
        }
        for(int i=0;i<nums.length;i++){
            int zero=map.get(0);
            int one=map.get(1);
            if(zero==one){
                return nums.length-i;
            }else{
                System.out.println(map.get(i));
                map.put(i,map.get(i)-1);
            }
        }
        return 0;
    }
}
