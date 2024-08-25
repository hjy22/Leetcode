package BinarySearch;

//https://leetcode.com/problems/capacity-to-ship-packages-within-d-days
public class CapacityToShipPackagesWithinDDays1011M {
    public static void main(String[] args) {
        int[] weights = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int days = 5;
        System.out.println(shipWithinDays(weights, days));
    }

    public static int shipWithinDays(int[] weights, int days) {
        int left = 1;
        int right = 1;
        // left应该是最大值 - 一次拿一个
        // right是weight的总和 - 一次全部拿完
        for (int w : weights) {
            left = Math.max(left, w);
            right += w;
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (calculateSpeed(weights, mid) <= days) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static int calculateSpeed(int[] weights, int x) {
        int days = 0; // 记录所需的天数
        for (int i = 0; i < weights.length;) { // 遍历所有货物
            int cap = x; // 每一天开始时，船的载重量为 x
            while (i < weights.length) { // 尝试将货物装到当天的船上
                if (cap < weights[i]) // 如果当前货物超过剩余载重量，停止装货
                    break;
                else
                    cap -= weights[i]; // 如果能装下货物，则减去相应的重量
                i++; // 装载下一个货物
            }
            days++; // 当天的船装满，增加一天
        }
        return days; // 返回总共需要的天数
    }
    

}
