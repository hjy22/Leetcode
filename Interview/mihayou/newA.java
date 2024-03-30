package Interview.mihayou;
import java.util.Scanner;

public class newA {
    public static void main(String[] args){
        // Scanner scanner = new Scanner(System.in);
        // String str=scanner.nextLine();
        // int length = Integer.valueof(scanner.nextLine());
        // while(length>0){
        //     length--;
        // }
        System.out.println(checkStr("ace", "abcde"));
    }

    public static boolean checkStr(String sub, String origin){
        int subLen=sub.length();
        int originLen = origin.length();
        int i=0;
        int j=0;
        while(i<subLen&&j<originLen){
            if(sub.charAt(i)==origin.charAt(j)){
                i++;
            }
            j++;
        }
        return i==subLen;
    }
}
