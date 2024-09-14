package Top105;

// https://leetcode.com/problems/remove-duplicates-from-sorted-array/?envType=study-plan-v2&envId=top-interview-150
public class RemoveDuplicatesfromSortedArray26E {
    public static void main(String[] args) {
        int[] nums = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
        System.out.println(removeDuplicates(nums));

    }

    public static int removeDuplicates(int[] nums) {
        int slow = 0, quick = 1;
        while (quick<nums.length) {
            if(nums[slow]!=nums[quick]){
                nums[slow+1]=nums[quick];
                slow++;
            }
            quick++;
        }
        return slow+1;
    }
}
