package Top105;

// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/?envType=study-plan-v2&envId=top-interview-150
public class TwoSumIIInputArrayIsSorted167M {
    public static void main(String[] args) {
        int[] numbers = { 5,25,75 };
        int target = 100;
        int[] ans= twoSum(numbers, target);
        System.out.println(ans[0]+" "+ans[1]);
    }

    public static int[] twoSum(int[] numbers, int target) {
        int left=0,right=numbers.length-1;
        while (right<numbers.length) {
            int tmp = numbers[left]+numbers[right];
            if(tmp==target){
                break;
            }else if(tmp>target){
                right--;
            }else{
                left++;
            }
        }
        return new int[]{left+1,right+1};
    }
}
