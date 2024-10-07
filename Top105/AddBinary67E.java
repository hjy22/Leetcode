package Top105;

// https://leetcode.com/problems/add-binary/?envType=study-plan-v2&envId=top-interview-150
public class AddBinary67E {
    public static void main(String[] args) {
        String a = "11", b = "1";
        System.out.println(addBinary(a, b));
    }

    public static String addBinary(String a, String b) {
        a = new StringBuilder(a).reverse().toString();
        b = new StringBuilder(b).reverse().toString();

        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int i = 0;
        int m = a.length(), n = b.length();
        while ((i < Math.max(m, n)) || carry > 0) {
            int val = carry;
            val += i < a.length() ? a.charAt(i) - '0' : 0;
            val += i < b.length() ? b.charAt(i) - '0' : 0;
            carry = val / 2;
            i++;
            sb.append(val % 2);
        }
        return sb.reverse().toString();
    }
}
