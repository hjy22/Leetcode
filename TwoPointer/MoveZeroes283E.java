package TwoPointer;

//https://leetcode.com/problems/move-zeroes/description/
// 用RemoveElement27E.java的remove掉0的元素，后面再把0补全
public class MoveZeroes283E {
    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        moveZeroes(nums);
        for(int ele:nums){
            System.out.println(ele);
        }
    }

    public static void moveZeroes(int[] nums) {
            int slow=0;
            int quick=0;
            while(quick<nums.length){
                if(nums[quick]!=0){
                    nums[slow]=nums[quick];
                    slow++;
                }
                quick++;
            }
            for(int i=slow;i<nums.length;i++){
                nums[i]=0;
            }
    }
}
