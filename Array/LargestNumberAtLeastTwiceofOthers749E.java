package Array;

public class LargestNumberAtLeastTwiceofOthers749E {
    public static void main(String[] args) {
        int[] nums = { 1,2,3,4};
        System.out.println(dominantIndex(nums));
    }

    public static int dominantIndex(int[] nums) {
        int firstLarge = -1;
        int secondLarge = -1;
        int firstIndex = -1;
        int secondIndex=-1;
        for(int i=0;i< nums.length;i++){
            if(nums[i]>firstLarge){
                secondLarge = firstLarge;
                secondIndex = firstIndex;
                firstLarge=nums[i];
                firstIndex=i;
            }else if(nums[i]<firstLarge&&nums[i]>secondLarge){
                secondLarge=nums[i];
                secondIndex=i;
            }
        }
        System.out.println("firstLarge"+firstLarge+" firstIndex"+firstIndex+" secondLarge"+secondLarge+" secondIndex"+secondIndex);
        if(firstIndex==-1||secondIndex==-1){
            return -1;
        }else{
            if(firstLarge>=2*secondLarge){
                return firstIndex;
            }else{
                return -1;
            }
        }
    }
}
