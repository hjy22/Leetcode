package SuiXiangLu;

public class RemoveDuplicatesfromSortedArray26E {
    public static void main(String[] args) {
        int[] nums = {1,1,2 };
        System.out.println(removeDuplicates(nums));
    }

    public static int removeDuplicates(int[] nums) {
        int slow =0,quick=1;
        while (quick<nums.length) {
            if(nums[quick]!=nums[slow]){
                slow++;
                nums[slow] = nums[quick];
            }
            quick++;
        }
        return slow+1;
    }
}
