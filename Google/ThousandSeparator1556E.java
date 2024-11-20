package Google;

// https://leetcode.com/problems/thousand-separator/
public class ThousandSeparator1556E {
    public static void main(String[] args) {
        int n = 987;
        System.out.println(thousandSeparator(n));
    }

    public static String thousandSeparator(int n) {
        String str = Integer.toString(n);
        StringBuilder sb = new StringBuilder();
        int count=0;
        for (int i = str.length() - 1; i >= 0; i--) {
            sb.append(str.charAt(i));
            count++;
            if (count % 3 == 0 && i != 0) {
                sb.append(".");
            }
        }
        return sb.reverse().toString();
    }
}
