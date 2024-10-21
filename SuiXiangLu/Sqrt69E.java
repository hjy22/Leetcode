package SuiXiangLu;

// https://leetcode.com/problems/sqrtx/
public class Sqrt69E {
    public static void main(String[] args) {
        int x = 8;
        System.out.println(mySqrt(x));
    }

    public static int mySqrt(int x) {
        if(x==0){
            return 0;
        }
        int left =1,right = x;
        while (left<=right) {
            int mid = left+(right-left)/2;
            if(x/mid>mid){
                left = mid+1;
            }else if(x/mid<mid){
                right = mid-1;
            }else{
                return mid;
            }
        }
        return right;
    }
}
