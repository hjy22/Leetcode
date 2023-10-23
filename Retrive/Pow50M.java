import java.util.*;

//https://leetcode.com/problems/powx-n/
public class Pow50M {
    public static void main(String[] args) {
        System.out.println(myPow(2,2));
    }
    public static double myPow(double x, int n) {
        return getPow(x,(long)n);
    }

    public static double getPow(double x, long n) {
        if(x==0){
            return 0;
        }
        if(n==0){
            return 1;
        }
        if(n<0){
            x = 1/x;
            n = -n;
        }
        double ans=1;
        while(n>0){
            if(n%2==1){
                ans *=x;
            }
            x *=x;
            n /=2;
        }
        return ans;
    }
}
