package Array;

//https://leetcode.com/problems/maximum-number-of-words-found-in-sentences/
public class MaximumNumberofWordsFoundinSentences2114E {
    public static void main(String[] args) {
        String[] sentences = { "alice and bob love leetcode","i think so too","this is great thanks very much" };
        System.out.println(mostWordsFound(sentences));
    }

    public static int mostWordsFound(String[] sentences) {
        int ans = 0;
        for(String s:sentences){
            int length=s.split(" ").length;
            ans=Math.max(length, ans);
        }
        return ans;
    }
}
