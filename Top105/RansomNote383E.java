package Top105;

// https://leetcode.com/problems/ransom-note/submissions/1402140064/?envType=study-plan-v2&envId=top-interview-150
public class RansomNote383E {
    public static void main(String[] args) {
        String ransomNote = "a", magazine = "b";
        System.out.print(canConstruct(ransomNote, magazine));
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] letterArray = new int[26];
        for (Character c : magazine.toCharArray()) {
            letterArray[c - 'a']++;
        }
        for (Character c : ransomNote.toCharArray()) {
            letterArray[c - 'a']--;
            if (letterArray[c - 'a'] < 0) {
                return false;
            }
            
        }
        return true;
    }

}
