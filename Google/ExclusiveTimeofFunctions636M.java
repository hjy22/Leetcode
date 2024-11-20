package Google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

// https://leetcode.com/problems/exclusive-time-of-functions/
public class ExclusiveTimeofFunctions636M {
    public static void main(String[] args) {
        int n = 2;
        List<String> logs = new ArrayList<>(Arrays.asList("0:start:0", "1:start:2", "1:end:5", "0:end:6"));
        System.out.println(exclusiveTime(n, logs));
    }

    public static int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> saveID = new Stack<>();
        int[] result = new int[n];
        int recordTime=0;

        for(String log:logs){
            String[] strs = log.split(":");
            int id = Integer.parseInt(strs[0]);
            String state = strs[1];
            int time = Integer.parseInt(strs[2]);
            if(state.equals("start")){
                if(!saveID.isEmpty()){
                    result[saveID.peek()]+=time-recordTime;
                }
                saveID.push(id);
                recordTime=time;
            }else{
                result[saveID.peek()]+=time-recordTime+1;
                saveID.pop();
                recordTime = time+1;
            }
        }
        return result;
    }
}
