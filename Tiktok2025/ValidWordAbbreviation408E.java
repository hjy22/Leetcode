package Tiktok2025;

// https://leetcode.com/problems/valid-word-abbreviation/?envType=company&envId=tiktok&favoriteSlug=tiktok-six-months
public class ValidWordAbbreviation408E {
    public static void main(String[] args) {
        String word = "internationalization", abbr = "i12iz4n";
        System.out.println(validWordAbbreviation(word, abbr));
    }

    public static boolean validWordAbbreviation(String word, String abbr) {
        int m = word.length(), n = abbr.length();
        int i = 0, j = 0;
        while (j < n) {
            if (Character.isLetter(abbr.charAt(j))) {
                if (i >= m || word.charAt(i) != abbr.charAt(j)) {
                    return false;
                }
                i++;
                j++;
            } else if (Character.isDigit(abbr.charAt(j))) {
                if (abbr.charAt(j) == '0') {
                    return false;
                }
                int num = 0;
                while (j < n &&Character.isDigit(abbr.charAt(j))) {
                    num = 10 * num + (abbr.charAt(j)-'0');
                    j++;
                   
                }
                i+=num;
                if (i > m) { 
                    return false;
                }
            }
        }
        return i==m;
    }

}
