package TwoPointer;

//https://leetcode.com/problems/sort-transformed-array
public class SortTransformedArray360M {
    public static void main(String[] args) {
        int[] nums = { -4, -1, 0, 3, 10 };
        int a = 1, b = 3, c = 5;
        System.out.println(sortTransformedArray(nums, a, b, c));
    }

    public static int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int left = 0, right = nums.length - 1;
        int p = (a > 0) ? nums.length - 1 : 0;
        int[] ans = new int[nums.length];
        while (left <= right) {
            int val1 = f(nums[left], a, b, c);
            int val2 = f(nums[right], a, b, c);
            if (a > 0) {
                if (val1 < val2) {
                    ans[p] = val2;
                    right--;
                } else {
                    ans[p] = val1;
                    left++;
                }
                p--;
            } else {
                if(val1<val2){
                    ans[p]=val1;
                    left++;
                }else{
                    ans[p]=val2;
                    right--;
                }
                p++;
            }
            
        }
        return ans;
    }

    private static int f(int x, int a, int b, int c) {
        return a * x * x + b * x + c;
    }
}
