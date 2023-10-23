package array;
import java.util.*;

public class intersection349E {
    public static void main(String[] args) {
        int[] num1 = {1,2,2,1};
        int[] num2 = {2,2};
        int[] ans = intersection(num1,num2);
        for(int item:ans){
            System.out.println(item);
         }
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> list = new HashSet<>();
        for(int item:nums1){
            set.add(item);
         }
         for(int item:nums2){
            if(set.contains(item)){
                list.add(item);
            }
         }
         int[] ans = new int[list.size()];
         int index=0;
         for(Integer item:list){
            ans[index]=item;
            index++;
         }
         return ans;
    }
}
