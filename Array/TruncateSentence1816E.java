package Array;

//https://leetcode.com/problems/truncate-sentence/
public class TruncateSentence1816E {
    public static void main(String[] args) {
        String s = "Hello how are you Contestant";
        int k = 4;
        System.out.println(truncateSentence(s, k));
    }

    public static String truncateSentence(String s, int k) {
        String ans = "";
        int times = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                times++;
            }
            if (times == k) {
                break;
            }
            ans += c;
        }
        return ans;
    }
}
