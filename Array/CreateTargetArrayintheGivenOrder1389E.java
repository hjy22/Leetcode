package Array;

//https://leetcode.com/problems/create-target-array-in-the-given-order/
public class CreateTargetArrayintheGivenOrder1389E {
    public static void main(String[] args) {
        int[] nums = { 0,1,2,3,4 };
        int[] index = { 0,1,2,2,1 };
        int[] ans = createTargetArray(nums, index);
        printArray(ans);
        // System.out.println(createTargetArray(nums, index));
    }

    public static int[] createTargetArray(int[] nums, int[] index) {
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (i == j) {
                    continue;
                }
                if(index[i]>=index[j]){
                    index[i]++;
                }
            }
        }
        printArray(index);
        for(int i=0;i<ans.length;i++){
            ans[index[i]]=nums[i];
        }
        return ans;
    }
    public static void printArray(int[] nums){
        for(int i:nums){
            System.out.print(i+" ");
        }
        System.out.println(" ");
    }
}
