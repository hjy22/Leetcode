package Array;

public class ProductArrayExceptSelf238M {
    public static void main(String[] args) {
        int[] nums = {-1,1,0,-3,3};
        int[] ans = productExceptSelf(nums);
        for(int item:ans){
            System.out.print(item+" ");
        }
    }

    public static int[] productExceptSelf(int[] nums) {
        int[] positive = new int[nums.length];
        int[] negative = new int[nums.length];
        int[] ans = new int[nums.length];

        int sumPositive =1;
        int sumNegative =1;
        for(int i=0;i<nums.length;i++){
            sumPositive *= nums[i];
            positive[i] = sumPositive;

            sumNegative *= nums[nums.length-i-1];
            negative[nums.length-i-1] = sumNegative;
        }
        for(int i=0;i<nums.length;i++){
            int sum=1;
            if(i-1>=0&&i-1<nums.length){
                sum*=positive[i-1];
            }
            if(i+1>=0&&i+1<nums.length){
                sum*=negative[i+1];
            }
            ans[i]=sum;
        }
        return ans;
    }
}
