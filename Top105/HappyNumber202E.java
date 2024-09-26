package Top105;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/happy-number/?envType=study-plan-v2&envId=top-interview-150
public class HappyNumber202E {
    public static void main(String[] args) {
        int n = 19;
        System.out.println(isHappy(n));
    }

    public static boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n!=1&&!set.contains(n)) {
            set.add(n);
            n = square(n);
        }
        return n==1;
    }

    public static int square(int n) {
        int output = 0;
        while (n > 0) {
            int rem = n % 10;
            output += rem * rem;
            n = n / 10;
        }
        return output;
    }
}
