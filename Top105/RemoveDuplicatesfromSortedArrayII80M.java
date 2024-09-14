package Top105;

// https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/?envType=study-plan-v2&envId=top-interview-150
public class RemoveDuplicatesfromSortedArrayII80M {
    public static void main(String[] args) {
        int[] nums = { 1, 1, 1, 2, 2, 3 };
        System.out.println(removeDuplicates(nums));
        for (int i : nums) {
            System.out.print(i + " ");
        }

    }

    public static int removeDuplicates(int[] nums) {
        if(nums.length<=2){
            return nums.length;
        }
        int slow = 2;
        for (int quick = 2; quick < nums.length; quick++) {
            if(nums[quick]!=nums[slow-2]){
                nums[slow]=nums[quick];
                slow++;
            }
        }
        return slow;
    }
}
