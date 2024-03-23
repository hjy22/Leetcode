package TwoPointer;
import java.util.*;
public class example2 {
    public static void main(String[] args) {
        // Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int n = 3;
        String[] strArray = {"2","1","4"};
        int[] ans = getTimes(strArray);
        for(int item:ans){
            System.out.println(item);
        }
       
    }
    public static int[] getTimes(String[] strArray){
        int[] ans = new int[strArray.length];
        for(int i=0;i<ans.length;i++){
            int num = Integer.valueOf(strArray[i]);
            int time=0;
            for(int j=0;j<ans.length;j++){
                if(i==j){
                    continue;
                }
                
                time+=Math.abs(Integer.valueOf(strArray[j])-num);
            }
            ans[i]=time;
        }
        return ans ;
    }
}
