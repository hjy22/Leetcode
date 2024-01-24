package Array;

//https://leetcode.com/problems/find-the-original-array-of-prefix-xor/
public class FindTheOriginalArrayofPrefixXor2433E {
    public static void main(String[] args) {
        int[] pref = { 5,3,4,2 };
        System.out.println(findArray(pref));
    }

    public static int[] findArray(int[] pref) {
        int[] ans = new int[pref.length];
        ans[0] = pref[0];
        for(int i=1;i<pref.length;i++){
            ans[i]=pref[i-1]^pref[i];
        }
        return ans;
    }
}
