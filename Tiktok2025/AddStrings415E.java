package Tiktok2025;

// https://leetcode.com/problems/add-strings/?envType=company&envId=tiktok&favoriteSlug=tiktok-thirty-days
public class AddStrings415E {
    public static void main(String[] args) {
        String num1 = "456", num2 = "77";
        System.out.println(addStrings(num1, num2));
    }

    public static String addStrings(String num1, String num2) {
        StringBuilder sb1 = new StringBuilder(num1);
        StringBuilder sb2 = new StringBuilder(num2);
        sb1.reverse();
        sb2.reverse();

        int carry = 0;
        int index1 = 0, index2 = 0;
        StringBuilder ans = new StringBuilder();
        while (index1 < sb1.length() || index2 < sb2.length() || carry != 0) {
            int n1 = index1 < sb1.length() ? sb1.charAt(index1) - '0' : 0;
            int n2 = index2 < sb2.length() ? sb2.charAt(index2) - '0' : 0;
            int sum = n1 + n2 + carry;

            ans.append(sum % 10);
            carry =sum/ 10;
            index1++;
            index2++;
            System.out.println(n1 + " " + n2 + " " + sum % 10 + " " + carry);
        }
        return ans.reverse().toString();
    }
}
