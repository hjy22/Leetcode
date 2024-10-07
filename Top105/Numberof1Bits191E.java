package Top105;

//https://leetcode.com/problems/number-of-1-bits/?envType=study-plan-v2&envId=top-interview-150
public class Numberof1Bits191E {
    public static void main(String[] args) {
        int n = 11;
        // System.out.println(hammingWeight(n));
        System.out.println(hammingWeightNew(n));
    }
    /*
     * n & (n-1)，作用是消除数字 n 的二进制表示中的最后一个 1：
     */
    public static int hammingWeightNew(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n-1);
            count++;
        }
        return count;
    }

    public static int hammingWeight(int n) {
        String binaryString = Integer.toBinaryString(n);
        int count = 0;
        for (Character c : binaryString.toCharArray()) {
            if (c == '1') {
                count++;
            }
        }
        return count;
    }
}
