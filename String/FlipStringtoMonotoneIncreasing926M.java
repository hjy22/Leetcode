package String;

//https://leetcode.com/problems/flip-string-to-monotone-increasing/
public class FlipStringtoMonotoneIncreasing926M {
    public static void main(String[] args) {
        String s = "00110";
        System.out.println(minFlipsMonoIncr(s));
    }

    public static int minFlipsMonoIncr(String s) {
        int count = 0;
        int count1 = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                count++;
            } else {
                count1++;
            }
            count = Math.min(count, count1);
        }
        return count;
    }
}
