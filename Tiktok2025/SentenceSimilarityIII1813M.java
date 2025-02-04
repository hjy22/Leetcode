package Tiktok2025;

public class SentenceSimilarityIII1813M {
    public static void main(String[] args) {
        String sentence1 ="c h p Ny", sentence2 = "c BDQ r h p Ny";
        System.out.println(areSentencesSimilar(sentence1, sentence2));
    }

    public static boolean areSentencesSimilar(String sentence1, String sentence2) {
        int prefix = 0, suffix = 0;
        int i = 0, j = 0;
        String[] s1 = sentence1.split(" ");
        String[] s2 = sentence2.split(" ");
        int m = s1.length, n = s2.length;

        while (i < Math.min(m, n) && s1[i].equals(s2[i])) {
            prefix++;
            i++;
        }

        while (j < Math.min(m, n) && s1[m-j-1].equals(s2[n-j-1])) {
            suffix++;
            j++;
        }
        System.out.println(prefix+" "+suffix);
        return prefix + suffix >= Math.min(m, n);
    }
}
