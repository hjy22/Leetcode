package Top105;

public class ReverseBits190E {
    public static void main(String[] args) {
        int n = 00000010100101000;
        System.out.println(reverseBits(n));
    }

    public static int reverseBits(int n) {
        return Integer.reverse(n);
    }
}
