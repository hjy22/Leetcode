package Tiktok2025;

public class FindtheDuplicateNumber287M {
    public static void main(String[] args) {
        int[] nums = { 1, 3, 4, 2, 2 };
        System.out.println(findDuplicate(nums));
    }

    public static int findDuplicate(int[] nums) {
        int slow = nums[0],quick=nums[0];
        do{
            slow=nums[slow];
            quick=nums[nums[quick]];
        }while(slow!=quick);

        slow=nums[0];
        while (slow!=quick) {
            slow=nums[slow];
            quick=nums[quick];
        }
        return slow;
    }
}
