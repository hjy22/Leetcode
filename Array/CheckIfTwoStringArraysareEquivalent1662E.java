package Array;

//https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent/
public class CheckIfTwoStringArraysareEquivalent1662E {
    public static void main(String[] args) {
        String[] word1 = { "ab", "c" };
        String[] word2 = { "a", "bc" };
        System.out.println(arrayStringsAreEqual(word1, word2));
    }

    public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        String string1 = "";
        String string2 = "";
        for(String s:word1){
            string1+=s;
        }
        for(String s:word2){
            string2+=s;
        }
        return string1.equals(string2);
    }
}
