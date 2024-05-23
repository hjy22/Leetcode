package TwoPointer;

//https://leetcode.com/problems/reverse-string
public class ReverseString344E {
    public static void main(String[] args) {
        char[] nums = {'h','e','l','l','o'};
        for(int i=0;i<nums.length;i++){
            System.out.println(nums[i]);
        }
        
    }

    public void reverseString(char[] s) {
        int left=0,right = s.length-1;
        while(left<right){
            char temp = s[left];
            s[left]=s[right];
            s[right]=temp;
            left++;
            right--;
        }
    }
}
