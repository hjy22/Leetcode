package Top105;

import java.util.Arrays;

// https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/?envType=study-plan-v2&envId=top-interview-150
public class MinimumNumberofArrowstoBurstBalloons452M {
    public static void main(String[] args) {
        int[][] intervals = { {-2147483646,-2147483645},{2147483646,2147483647 } };
        System.out.println(findMinArrowShots(intervals));
    }

    public static int findMinArrowShots(int[][] points) {
        //用减法会导致int溢出，用Integer.compare可以解决
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        int count = 1;
        int end = points[0][1];
        for(int[] point:points){
            if(point[0]>end){
                count++;
                end = point[1];
            }
        }
        return count;
    }
}
