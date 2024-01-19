package Array;

//https://leetcode.com/problems/final-value-of-variable-after-performing-operations/
public class FinalValueofVariableAfterPerformingOperations2011E {
    public static void main(String[] args) {
        String[] nums = { "--X","X++","X++" };
        System.out.println(finalValueAfterOperations(nums));
    }

    public static int finalValueAfterOperations(String[] operations) {
        int ans=0;
        for(String s:operations){
            if(s.contains("+")){
                ans++;
            }else{
                ans--;
            }
        }
        return ans;
    }
}
