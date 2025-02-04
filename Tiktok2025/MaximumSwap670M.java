package Tiktok2025;

// https://leetcode.com/problems/maximum-swap/?envType=company&envId=tiktok&favoriteSlug=tiktok-six-months
public class MaximumSwap670M {
    public static void main(String[] args) {
        int nums = 2736;
        System.out.println(maximumSwap(nums));
    }

    public static int maximumSwap(int num) {
        char[] numArr = String.valueOf(num).toCharArray();
        int[] numLastIndex = new int[10];
        for (int i = 0; i < numArr.length; i++) {
            numLastIndex[numArr[i] - '0'] = i;
        }
        for(int i=0;i<numArr.length;i++){
            int curNum = numArr[i]-'0';
            for(int j=9;j>curNum;j--){
                if(numLastIndex[j]>i){
                    char tmp = numArr[numLastIndex[j]];
                    numArr[numLastIndex[j]] = numArr[i];
                    numArr[i]=tmp;
                    return Integer.valueOf(new String(numArr));
                }
            }
        }
        return num;
    }
}
