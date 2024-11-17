package Google;

// https://leetcode.com/problems/powx-n/description/?envType=company&envId=google&favoriteSlug=google-thirty-days
public class pow50M {
    public static void main(String[] args) {
        double x = 2.00000;
        int n = 10;
        System.out.println(myPow(x, n));
    }

    public static double myPow(double x, int n) {
        long N = n;
        return n>=0? getPow(x, -N):getPow(x, -N);
    }

    public static double getPow(double x,long n){
        if(n==0){
            return 1;
        }
        double half = getPow(x, n / 2);
        return n % 2 == 0 ? half * half : half * half * x;
    }
}
