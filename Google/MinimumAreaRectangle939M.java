package Google;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// https://leetcode.com/problems/minimum-area-rectangle/?envType=company&envId=google&favoriteSlug=google-thirty-days
public class MinimumAreaRectangle939M {
    public static void main(String[] args) {
        int[][] points = { { 1, 1 }, { 1, 3 }, { 3, 1 }, { 3, 3 }, { 2, 2 } };
        System.out.println(minAreaRect(points));
    }

    public static int minAreaRect(int[][] points) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        //key存x轴，value存y轴
        for(int[] point: points){
            map.putIfAbsent(point[0], new HashSet<>());
            map.get(point[0]).add(point[1]);
        }

        int min = Integer.MAX_VALUE;
        for(int i=0;i<points.length;i++){
            for(int j=i+1;j<points.length;j++){
                int x1=points[i][0],y1=points[i][1];
                int x2=points[j][0],y2=points[j][1];

                if(x1!=x2&&y1!=y2){
                    //检查(x1,y2),(x2,y1)是否存在
                    if(map.get(x1).contains(y2)&&map.get(x2).contains(y1)){
                        int area = Math.abs(x1-x2)*Math.abs(y1-y2);
                        min = Math.min(min, area);
                    }
                }
            }
        }
        return min==Integer.MAX_VALUE?0:min;
    }
}
