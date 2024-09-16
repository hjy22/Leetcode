package Top105;

// https://leetcode.com/problems/roman-to-integer/?envType=study-plan-v2&envId=top-interview-150
import java.util.HashMap;
import java.util.Map;

public class RomantoInteger13E {
    public static void main(String[] args) {
        String s = "III";
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

        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i < s.length() - 1 && arraySymbol.get(s.charAt(i)) < arraySymbol.get(s.charAt(i + 1))) {
                sum -= arraySymbol.get(s.charAt(i));
            } else {
                sum += arraySymbol.get(s.charAt(i));
            }
        }
        return sum;
    }
}
