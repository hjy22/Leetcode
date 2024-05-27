package PrefixSum;

//https://leetcode.com/problems/product-of-array-except-self/
public class ProductofArrayExceptSelf238M {
    public static void main(String[] args) {
        int[] matrix ={1,2,3,4};
        int[] newMatrix = productExceptSelf(matrix);
        for(int i=0;i<newMatrix.length;i++){
                System.out.print(newMatrix[i]+" ");
            }
        }

    public static int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];
        int[] ans = new int[nums.length];
        prefix[0]=1;
        suffix[nums.length-1]=1;
        for(int i=1;i<nums.length;i++){
            prefix[i]=prefix[i-1]*nums[i-1];
        }
        for(int i=nums.length-2;i>=0;i--){
            suffix[i]=suffix[i+1]*nums[i+1];
        }
        for(int i=0;i<ans.length;i++){
            ans[i]=prefix[i]*suffix[i];
        }
        return ans;
    }
}
