package Array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/third-maximum-number/
public class ThirdMaximumNumber414E {
    public static void main(String[] args) {
        int[] nums ={3,2,1};
        System.out.println(thirdMax(nums));
    }

    public static int thirdMax(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i:nums){
            set.add(i);
        }
        int[] arr = new int[set.size()];
        int index=0;
        for(int i:set){
            arr[index]=i;
            index++;
        }
        Arrays.sort(arr);
        if(arr.length<3){
            return arr[arr.length-1];
        }else{
            return arr[arr.length-3];
        }
    }
}
