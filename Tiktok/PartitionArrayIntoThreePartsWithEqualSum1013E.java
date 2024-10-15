package Tiktok;

// https://leetcode.com/problems/partition-array-into-three-parts-with-equal-sum/
//注意得到右边的index之后，要判断left和right之间是否有间隙
public class PartitionArrayIntoThreePartsWithEqualSum1013E {
    public static void main(String[] args) {
        int[] arr = { 0, 2, 1, -6, 6, -7, 9, 1, 2, 0, 1 };
        System.out.println(canThreePartsEqualSum(arr));
    }

    public static boolean canThreePartsEqualSum(int[] arr) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        if (sum % 3 != 0) {
            return false;
        }

        int target = sum / 3;
        int left = 0, right = arr.length - 1;
        int leftSum = 0, rightSum = 0;
        while (left < arr.length) {
            leftSum += arr[left];
            if (leftSum == target) {
                break;
            }
            left++;
        }
        while (right > left+1) {
            rightSum += arr[right];
            if (rightSum == target) {
                break;
            }
            right--;
        }

        if (left + 1 >= right) {
            return false;
        }
        int midSum = 0;
        for (int i = left + 1; i < right; i++) {
            midSum += arr[i];
        }
        return leftSum == target && rightSum == target && midSum == target;
    }
}
