package Tiktok;

// https://leetcode.com/problems/add-strings/?envType=company&envId=tiktok&favoriteSlug=tiktok-thirty-days
public class AddStrings415E {
    public static void main(String[] args) {
        String num1 = "11", num2 = "123";
        System.out.println(addStrings(num1, num2));
    }

    public static String addStrings(String num1, String num2) {
        StringBuffer sb1 = new StringBuffer(num1);
        StringBuffer sb2 = new StringBuffer(num2);
        sb1.reverse();
        sb2.reverse();
        int len1= sb1.length(),len2=sb2.length();
        int i=0,j=0;
        int carry = 0;
        StringBuffer ans = new StringBuffer();
        while (i<len1||j<len2||carry>0) {
            int i1 = i<len1?sb1.charAt(i)-'0':0;
            int i2 = j<len2?sb2.charAt(j)-'0':0;
            int sum = i1+i2+carry;
            ans.append(sum%10);
            carry = sum/10;
            i++;
            j++;
        }
        return ans.reverse().toString();
    }
}
