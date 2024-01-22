package String;

//https://leetcode.com/problems/defanging-an-ip-address/
public class DefanginganIPAddress1108E {
    public static void main(String[] args) {
        String address = "leetcodeisacommunityforcoders";
        System.out.println(defangIPaddr(address));
    }

    public static String defangIPaddr(String address) {
        String ans = "";
        for (char c : address.toCharArray()) {
            if (c == '.') {
                ans += "[.]";
            } else {
                ans += c;
            }
        }
        return ans;
    }
}
