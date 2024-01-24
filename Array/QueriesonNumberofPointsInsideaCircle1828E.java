package Array;

//https://leetcode.com/problems/queries-on-number-of-points-inside-a-circle/
public class QueriesonNumberofPointsInsideaCircle1828E {
    public static void main(String[] args) {
        int[][] points = { { 1, 3 }, { 3, 3 }, { 5, 3 }, { 2, 2 } };
        int[][] queries = { { 2, 3, 1 }, { 4, 3, 1 }, { 1, 1, 2 } };
        System.out.println(countPoints(points, queries));
    }

    public static int[] countPoints(int[][] points, int[][] queries) {
        int[] ans = new int[queries.length];
        for(int i=0;i<queries.length;i++){
            int count=0;
            for(int j=0;j<points.length;j++){
                double distance = Math.pow(points[j][0]-queries[i][0], 2)+Math.pow(points[j][1]-queries[i][1], 2);
                if(distance<=Math.pow(queries[i][2], 2)){
                    count++;
                }
            }
            ans[i]=count;
        }
        return ans;
    }
}
