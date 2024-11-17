package Google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/pascals-triangle/?envType=company&envId=google&favoriteSlug=google-thirty-days
public class PascalsTriangle118E {
    public static void main(String[] args) {
        int numRows = 5;
        System.out.println(generate(numRows));
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>(Arrays.asList(1)));

        for(int i=1;i<numRows;i++){
            List<Integer> tmp = new ArrayList<>();
            tmp.add(1);
            for(int j=1;j<i;j++){
                tmp.add(ans.get(i-1).get(j-1)+ans.get(i-1).get(j));
            }
            tmp.add(1);
            ans.add(tmp);
        }

        return ans;
    }
}
