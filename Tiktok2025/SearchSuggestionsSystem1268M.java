package Tiktok2025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/search-suggestions-system/?envType=company&envId=tiktok&favoriteSlug=tiktok-six-months
public class SearchSuggestionsSystem1268M {
    public static void main(String[] args) {
        String[] products = { "mobile", "mouse", "moneypot", "monitor", "mousepad" };
        String searchWord = "mouse";
        System.out.println(suggestedProducts(products, searchWord));
    }

    public static List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        List<List<String>> ans = new ArrayList<>();
        String prefix = "";
        for(Character c:searchWord.toCharArray()){
            prefix+=c;
            int index =findIndex(products, prefix);

            List<String> list = new ArrayList<>();
            for(int i=index;i<Math.min(index+3, products.length);i++){
                if(products[i].startsWith(prefix)){
                    list.add(products[i]);
                }
            }
            ans.add(list);
        }
        return ans;
    }

    public static int findIndex(String[] products, String prefix){
        int left=0,right=products.length-1;
        while (left<right) {
            int mid = left+(right-left)/2;
            if(products[mid].compareTo(prefix)<0){
                left = mid+1;
            }else{
                right=mid;
            }
        }
        return left;
    }
}
