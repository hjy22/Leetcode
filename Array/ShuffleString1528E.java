package Array;

//https://leetcode.com/problems/shuffle-string/
public class ShuffleString1528E {
    public static void main(String[] args) {
        int[] indices = { 4,5,6,7,0,2,1,3 };
        String s = "codeleet";
        System.out.println(restoreString(s, indices));
    }

    public static String restoreString(String s, int[] indices) {
        char[] charArray = new char[indices.length];
        for (int i = 0; i < indices.length; i++) {
            charArray[indices[i]] = s.charAt(i);
        }
       String str = new String(charArray);
        return str;
    }

    public static void p(char[] c){
        for(char ch:c){
            System.out.print(ch);
        }
        System.out.println(" ");
    }
}
