package Array;

//https://leetcode.com/problems/count-good-triplets/
public class CountGoodTriplets1534E {
    public static void main(String[] args) {
        int[] arr = { 3,0,1,1,9,7};
        int a = 7;
        int b = 2;
        int c = 3;
        System.out.println(countGoodTriplets(arr, a, b, c));
    }

    public static int countGoodTriplets(int[] arr, int a, int b, int c) {
        int ans = 0;
        for (int i = 0; i < arr.length - 2; i++) {
            int first = arr[i];
            for (int j = i+1; j < arr.length - 1; j++) {
                int second = arr[j];
                if(Math.abs(second-first)>a){
                    continue;
                }
                for (int k = j+1; k < arr.length; k++) {
                    int third = arr[k];
                    if(Math.abs(third-second)>b){
                        continue;
                    }
                    if(Math.abs(third-first)>c){
                        continue;
                    }
                    ans++;
                }
            }
        }
        return ans;
    }
}
