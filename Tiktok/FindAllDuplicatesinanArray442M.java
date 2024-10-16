package Tiktok;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/find-all-duplicates-in-an-array/?envType=company&envId=tiktok&favoriteSlug=tiktok-thirty-days
/*
 * 根据题目得知：数组的数字在[1,n]之间，且都是正数
 * 遍历数组的时候，遇到一个数字，就把它当成索引存进原数组里，并赋值负数
 * 如果遍历到他发现是负数，说明该数字已存在，就加到ans里
 */
public class FindAllDuplicatesinanArray442M {
    public static void main(String[] args) {
        int[] nums = { 4, 3, 2, 7, 8, 2, 3, 1 };
        System.out.println(findDuplicates(nums));
    }

    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int i:nums){
            if(nums[Math.abs(i)-1]>=0){
                nums[Math.abs(i)-1]*=-1;
            }else{
                list.add(Math.abs(i));
            }
        }
        return list;
    }

}
