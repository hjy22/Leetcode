package Interview.xiecheng;
import java.util.*;

public class example3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        // while (in.hasNextLine()) { // 注意 while 处理多个 case
        //     String str = in.nextLine();
        // }
        String str = "[1(2),1(1),-1(3)]";
        System.out.println(combineString(str));
    }
    public static int[] getNum(String str){
        int[] ans = new int[2];
        int first=str.indexOf("(");
        ans[0]=Integer.valueOf(str.substring(0, first));
        int second=str.indexOf(")");
        ans[1]=Integer.valueOf(str.substring(first+1, second));
        return ans;
    }

    public static String combineString(String str){
        str=str.substring(1,str.length()-1);
        List<String> list = new ArrayList<>();
        String[] strArray = str.split(",");
        int[] intArray = getNum(strArray[0]);
        int previous_key=intArray[0];
        int previous_value = intArray[1];
        for(int i=1;i<strArray.length;i++){
            int[] temp = getNum(strArray[i]);
            int current_key=temp[0];
            int current_value = temp[1];
            System.out.println(current_key+" "+current_value);
            if(previous_key==current_key){
                current_value += previous_value;
            }else{
                String combine=previous_key+"("+previous_value+")";
                list.add(combine);
            }
            previous_key=current_key;
            previous_value=current_value;
        }
        String combine=previous_key+"("+previous_value+")";
        list.add(combine);
        return list.toString().replace(" ", "");
    }
}
