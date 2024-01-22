package Array;

//https://leetcode.com/problems/count-tested-devices-after-test-operations
public class CountTestedDevicesAfterTestOperations2960E {
    public static void main(String[] args) {
        int[] batteryPercentages = { 4, 3, 2, 3, 1 };
        System.out.println(countTestedDevices(batteryPercentages));
    }

    public static int countTestedDevices(int[] batteryPercentages) {
        int ans = 0;
        for(int i=0;i<batteryPercentages.length;i++){
            if(batteryPercentages[i]>0){
                ans++;
                for(int j=i+1;j<batteryPercentages.length;j++){
                    batteryPercentages[j]--;
                }
            }
        }
        return ans;
    }
}
