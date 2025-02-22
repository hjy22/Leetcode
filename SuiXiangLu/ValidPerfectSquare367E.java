package SuiXiangLu;

// https://leetcode.com/problems/valid-perfect-square/
public class ValidPerfectSquare367E {
    public static void main(String[] args) {
        int num = 16;
        System.out.println(isPerfectSquare(num));
    }

    public static boolean isPerfectSquare(int num) {
        int left =1,right = num;
        while (left<=right) {
            int mid = left+(right-left)/2;
            long square = (long) mid * mid;
            if(square<num){
                left = mid+1;
            }else if(square>num){
                right = mid-1;
            }else{
                return true;
            }
        }
        return false;
    }
}
