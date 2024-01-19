package Array;

//https://leetcode.com/problems/number-of-employees-who-met-the-target/description/
public class NumberofEmployeesWhoMettheTargetE2798 {
    public static void main(String[] args) {
        int[] hours = { -1, 0, 3, 5, 9, 12 };
        int target = 3;
        System.out.println(numberOfEmployeesWhoMetTarget(hours,target));
    }

    public static int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        int ans=0;
        for(int i:hours){
            if(i>=target){
                ans++;
            }
        }
        return ans;
    }
}
