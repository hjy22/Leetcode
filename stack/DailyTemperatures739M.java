package Stack;

import java.util.Stack;

//https://leetcode.com/problems/daily-temperatures
public class DailyTemperatures739M {
    public static void main(String[] args) {
        int[] temperatures = {73,74,75,71,69,72,76,73};
        int[] ans =dailyTemperatures(temperatures);
        for(int i:ans){
            System.out.print(i+" ");
        }
    }

    //stack中 存索引 方便计算最大的
    public static int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[temperatures.length];
        for(int i=temperatures.length-1;i>=0;i--){
            while(!stack.isEmpty()&&temperatures[stack.peek()]<=temperatures[i]){
                stack.pop();
            }
            ans[i]=stack.isEmpty()?0:(stack.peek()-i);
            stack.push(i);
        }
        return ans;
    }
}
