package TwoPointer;

public class reverseString541E {
    public static void main(String[] args) {
        String s = "abc";
                    //bacdfeg
        int k = 4;
        System.out.println(reverseStr(s,k));
    }

    public static String reverseStr(String s, int k) {
        char[] a = s.toCharArray();
        for (int start = 0; start < a.length; start += 2 * k) {
            int i = start, j = Math.min(start + k - 1, a.length - 1);
            while (i < j) {
                char tmp = a[i];
                a[i++] = a[j];
                a[j--] = tmp;
            }
        }
        return new String(a);
    }
}
