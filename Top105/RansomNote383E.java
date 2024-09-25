package Top105;

public class RansomNote383E {
    public static void main(String[] args) {
        String ransomNote = "a", magazine = "b";
        System.out.print(canConstruct(ransomNote, magazine));
    }

    public  static boolean canConstruct(String ransomNote, String magazine) {
        int[] charCount = new int[26];
        
        for (char c : magazine.toCharArray()) {
            charCount[c - 'a']++;
        }
        
        for (char c : ransomNote.toCharArray()) {
            if (--charCount[c - 'a'] < 0) {
                return false;  
            }
        }
        
        return true;  
    }
}
