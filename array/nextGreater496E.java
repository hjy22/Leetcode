package Array;

//https://leetcode.com/problems/next-greater-element-i/
public class NextGreater496E {
    public static void main(String[] args) {
        int[] nums1 = {2,4};
        int[] nums2 = {1,2,3,4};
        int[] num = nextGreaterElement(nums1,nums2);
        for(int item1:num){
            System.out.println(item1);
        }
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        int index = 0;
        for(int item1:nums1){
            boolean hasValueInNums2 = false;
            boolean hasAnswer = false;
            for(int item2:nums2){
                if(item1==item2){
                    hasValueInNums2 = true;
                    continue;
                }
                if(hasValueInNums2&&item2>item1){
                    ans[index]=item2;
                    hasAnswer = true;
                    break;
                }
            }
            if(!hasAnswer||!hasAnswer){
                ans[index]=-1;
            }
            index++;
        }
        return ans;
    }
}
