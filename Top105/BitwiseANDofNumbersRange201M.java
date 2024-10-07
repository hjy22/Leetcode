package Top105;

// https://leetcode.com/problems/bitwise-and-of-numbers-range/?envType=study-plan-v2&envId=top-interview-150
public class BitwiseANDofNumbersRange201M {
    public static void main(String[] args) {
        int left = 5, right = 7;
        System.out.println(rangeBitwiseAnd(left, right));
    }

    public static int rangeBitwiseAnd(int left, int right) {
        // 不断右移 left 和 right，直到它们相等为止
        while (left < right) {
            right = right & (right - 1);  
        }
        return left & right;   
    }
}
