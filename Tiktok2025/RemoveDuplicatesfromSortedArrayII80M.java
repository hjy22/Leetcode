package Tiktok2025;

// https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/?envType=company&envId=tiktok&favoriteSlug=tiktok-six-months
public class RemoveDuplicatesfromSortedArrayII80M {
    public static void main(String[] args) {
        int[] nums = { 1, 1, 1, 2, 2, 3 };
        System.out.println(removeDuplicates(nums));
    }

    public static int removeDuplicates(int[] nums) {
        if(nums.length<=2){
            return nums.length;
        }
        int slow=0;
        for(int quick=2;quick<nums.length;quick++){
            if(nums[quick]!=nums[slow]){
                nums[slow] = nums[quick];
                slow++;
            }
        }
        return slow;
    }
}
