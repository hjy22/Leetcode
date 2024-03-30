package Interview.xiecheng;
import java.util.*;

public class example1 {
    public static void main(String[] args) {
        // 注意 hasNext 和 hasNextLine 的区别
        String str ="yyoouuuu";
        System.out.println(getString(str));
    }
    public static String getString(String str){
        String ans = "";
        Map<Character,Integer> map = new TreeMap<>();
        int min = Integer.MAX_VALUE;
        for(char c:str.toCharArray()){
            if(map.containsKey(c)){
                map.put(c,map.get(c)+1);
                
            }else{
                map.put(c,1);
            }
        }
        for(Map.Entry<Character,Integer> entry:map.entrySet()){
            int times= entry.getValue();
            System.out.println(times+" "+entry.getKey());
            min=Math.min(times,min);
        }
        if(map.size()==3){
            for (int i = 1; i <= min; i++) {
                ans += "you";
            }
        }
        for(Map.Entry<Character,Integer> entry:map.entrySet()){
            int time=0;
            if(map.size()==3){
                time= entry.getValue()-min;
            }else{
             time = entry.getValue();
            }
            for(int i=1;i<=time;i++){
            ans+=entry.getKey();
        }
        }
        return ans;
    }
}
