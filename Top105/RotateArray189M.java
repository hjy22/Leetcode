package Top105;

public class RotateArray189M {
    public static void main(String[] args) {
        int[] nums = { -1};
        int k = 2;
        rotate(nums, k);
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }
    /*
     * 1,2,3,4,5,6,7 k=3
     * 1. reverse (0,8) 7,6,5,4,3,2,1
     * 2. reverse (0,3) 5,6,7,4,3,2,1
     * 3. reverse (3,8) 5,6,7,1,2,3,4
     */
    public static void rotate(int[] nums, int k) {
        int n=nums.length;
        k%=n;
        reverse(nums, 0, n-1);
        reverse(nums, 0, k-1);
        reverse(nums, k,n-1);
    }

    public static void reverse(int[] nums,int start,int end){
        while (start<end) {
            int tmp=nums[start];
            nums[start]=nums[end];
            nums[end]=tmp;
            start++;
            end--;
        }
    }
}
