package Google;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/roman-to-integer/description/?envType=company&envId=google&favoriteSlug=google-thirty-days
public class RomantoInteger13E {
    public static void main(String[] args) {
        String s = "LVIII";
        System.out.println(romanToInt(s));
    }

    public static int romanToInt(String s) {
        Map<Character, Integer> arraySymbol = new HashMap<>();
        arraySymbol.put('M', 1000);
        arraySymbol.put('D', 500);
        arraySymbol.put('C', 100);
        arraySymbol.put('L', 50);
        arraySymbol.put('X', 10);
        arraySymbol.put('V', 5);
        arraySymbol.put('I', 1);

        int sum=0;
        for(int i=0;i<s.length();i++){
            if(i<s.length()-1&&arraySymbol.get(s.charAt(i)) < arraySymbol.get(s.charAt(i + 1))){
                //小，说明这里得用减法
                sum-=arraySymbol.get(s.charAt(i));
            }else{
                sum+=arraySymbol.get(s.charAt(i));
            }
        }
        return sum;
    }
}
