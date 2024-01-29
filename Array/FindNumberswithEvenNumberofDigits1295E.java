package Array;

//https://leetcode.com/problems/find-numbers-with-even-number-of-digits/
public class FindNumberswithEvenNumberofDigits1295E {
    public static void main(String[] args) {
        int[] nums = { 12,345,2,6,7896 };
        System.out.println(findNumbers(nums));
    }

    public static int findNumbers(int[] nums) {
        int ans=0;
        for(int i:nums){
            int digits = getDigits(i);
            System.out.println(i+" "+digits);
            if(isEven(digits)){
                ans++;
            }
        }
        return ans;
    }
    public static int getDigits(int num){
        int count = 0;
        while(num%10>0){
            num /=10;
            count++;
        }
        return count;
    }
    public static boolean isEven(int num){
        return num%2==0;
    }
}
