package Array;

public class TwoSum1E {
    public static void main(String[] args) {
        int[] nums = {2,7,11,15  };
        int target = 9;
        int[] ans = twoSum(nums, target);
        System.out.println(ans[0]+" "+ans[1]);
    }
    public static int[] twoSum(int[] nums, int target) {
        int[] answers = new int[2]; 
        for(int i =0; i < nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    answers[0] = i;
                    answers[1] = j;
                    break;
                }
            }
        }
        return answers;
    }
}
