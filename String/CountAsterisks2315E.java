package String;

//https://leetcode.com/problems/count-asterisks/
public class CountAsterisks2315E {
    public static void main(String[] args) {
        String s = "iamprogrammer";
        System.out.println(countAsterisks(s));
    }

    public static int countAsterisks(String s) {
        int ans = 0;
        int count = 0;
        for (Character c : s.toCharArray()) {
            if (c == '|') {
                count++;
            }
            if (count % 2 == 0) {
                if (c == '*') {
                    ans++;
                }
            }
        }
        return ans;
    }
}
