package Array;

//https://leetcode.com/problems/plus-one/description/
public class PlusOneE66 {
    public static void main(String[] args) {
        int[] digits = { 9,8,7,6,5,4,3,2,1,0 };
        int[] ans = plusOne(digits);
        for (int item : ans) {
            System.out.print(item + "");
        }

    }

    public static int[] plusOne(int[] digits) {
        for (int i=digits.length-1; i>=0; i--){
            if (digits[i]<9){
                digits[i]+=1;
                return digits;
            }
            digits[i]=0;
        }
        
        int[] result = new int[digits.length+1];
        result[0] = 1;
        return result;
    }
}
