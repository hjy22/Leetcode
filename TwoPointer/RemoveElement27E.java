package TwoPointer;

//https://leetcode.com/problems/remove-element/
public class RemoveElement27E {
    public static void main(String[] args) {
        int[] nums={2};
        int val = 3;
        System.out.println(removeElement(nums,val));
        for(int ele:nums){
            System.out.println(ele);
        }
        
    }
    public static int removeElement(int[] nums, int val) {
        int slow=0;
        int quick=0;
        while(quick<nums.length){
            if(nums[quick]!=val){
                nums[slow]=nums[quick];
                slow++;
            }
            quick++;
        }
        return slow;
   }
}
