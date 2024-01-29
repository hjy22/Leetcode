package Array;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/sum-of-unique-elements/
public class SumofUniqueElements1748E {
    public static void main(String[] args) {
        int[] nums = { 2, 7, 1, 19, 18, 3 };
        System.out.println(sumOfUnique(nums));
    }

    public static int sumOfUnique(int[] nums) {
        int ans = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i:nums){
            if(!map.containsKey(i)){
                map.put(i,1);
            }else{
                map.put(i,-1);
            }
        }
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(entry.getValue()==1){
                ans+=entry.getKey();
            }
        }
        return ans;
    }
}
