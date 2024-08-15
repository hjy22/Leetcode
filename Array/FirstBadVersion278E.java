package Array;

//https://leetcode.com/problems/first-bad-version/
public class FirstBadVersion278E {
    public static void main(String[] args) {
        int n = 5, bad = 4;
        System.out.println(firstBadVersion(n));
    }

    public static int firstBadVersion(int n) {
        if (n == 1) {
            return n;
        }
        int start = 1, end = n;
        int bad = 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isBadVersion(mid)) {
                end = mid-1;
                bad = mid;
            } else {
                start = mid+1;
            }
        }
        return bad;
    }

    public static boolean isBadVersion(int version) {
        return true;
    }
}
