package RoundOne2025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

// https://leetcode.com/problems/find-k-pairs-with-smallest-sums/description/?show=1
public class FindKPairswithSmallestSums373M {
    public static void main(String[] args) {
        int[] nums1 = { 1, 7, 11 }, nums2 = { 2, 4, 6 };
        int k = 3;
        System.out.println(kSmallestPairs(nums1, nums2, k));
    }

    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b)->{
            return a[0]-b[0];
        });

        for(int i=0;i<nums2.length;i++){
            heap.add(new int[]{nums1[0]+nums2[i],0,i});
        }

        while (k>0) {
            int[] cur = heap.poll();
            int i =cur[1],j=cur[2];
            List<Integer> list = Arrays.asList(nums1[i],nums2[j]);
            ans.add(list);
            
            if(i+1<nums1.length){
                heap.add(new int[]{nums1[i+1]+nums2[j],i+1,j});
            }
            k--;
        }

        return ans;
    }
}
