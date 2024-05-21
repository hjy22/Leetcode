package TwoPointer;

//https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
public class TwoSumIIInputArrayIsSorted167M {
    public static void main(String[] args) {
        int[] numbers = { 2,7,11,15};
        int target = 9;

        System.out.println(twoSum(numbers, target)[0]+" "+twoSum(numbers, target)[1]);
    }

    public static int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length-1;
        int sum = numbers[left]+numbers[right];
        while(left<right){
            if(sum==target){
                return new int[]{left+1,right+1}; 
            }
            if(sum>target){
                right--;
            }else{
                left++;
            }
            sum = numbers[left]+numbers[right];
        }
        return new int[]{};
    }
}
