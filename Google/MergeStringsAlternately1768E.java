package Google;

//https://leetcode.com/problems/merge-strings-alternately/?envType=company&envId=google&favoriteSlug=google-thirty-days
public class MergeStringsAlternately1768E {
    public static void main(String[] args) {
        String word1 = "ab", word2 = "pqrs";
        System.out.println(mergeAlternately(word1, word2));
    }

    public static String mergeAlternately(String word1, String word2) {
        int index1 = 0, index2 = 0;
        String ans="";
        while (index1 < word1.length() && index2 < word2.length()) {
            ans+=word1.charAt(index1);
            ans+=word2.charAt(index2);
            index1++;
            index2++;
        }
        if(index1<word1.length()){
            ans+=word1.substring(index1, word1.length());
        }else{
            ans+=word2.substring(index2, word2.length());
        }
        return ans;
    }
}
