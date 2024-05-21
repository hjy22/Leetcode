package TwoPointer;

import java.util.ArrayList;
import java.util.List;

public class threeSum15M {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> lists=threeSum(nums);
        for(List<Integer> list:lists){
            for(Integer i:list){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        int left =0;
        int right=nums.length-1;
        List<List<Integer>> lists = new ArrayList<>();
        while(left<right){
            
        }
        return lists;
    }   
}
