package TwoPointer;

//https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
public class RemoveDuplicatesfromSortedArray26E {
    public static void main(String[] args) {
        int[] nums = {1,1,2};
        System.out.println(removeDuplicates(nums));
    }

    public static int removeDuplicates(int[] nums) {
        int slow=0;
        int quick=1;
        for(int i=0;i<nums.length-1;i++){
            if(nums[slow]!=nums[quick]){
                nums[slow+1]=nums[quick];
                slow++;
            }
            quick++;
        }
        return slow+1;
    }
}
