package Interview.wangyi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class P2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String line = in.nextLine();
        String[] array = line.split(" ");
        int n = Integer.valueOf(array[0]);
        int m = Integer.valueOf(array[1]);
        // List<List<Integer>> result = new ArrayList<>();
        // findCombine(n, m, 1, new ArrayList<>(), result);
        // Set<List<Integer>> set = new HashSet<>();
        // int[] ans = new int[7];
        // for(List<Integer> list:result){
        //     List<Integer> sortedList = new ArrayList<>();
        //     for(Integer i:list){
        //         sortedList.add(i);
        //     }
        //     Collections.sort(sortedList);
        //     set.add(sortedList);
        // }
        // for(List<Integer> list:set){
        //     for(Integer i:list){
        //        ans[i-1]+=1;
        //     }
        // }
        // for(int i:ans){
        //     System.out.println(i);
        // }
        List<List<Integer>> result = findResult(n, m);
        for(List<Integer> list:result){
            for(int i:list){
                System.out.print(i+" ");
                
            }
            System.out.println();
        }
    }

    public static void findCombine(int n,int m,int start,List<Integer> list,List<List<Integer>> result){
        if(n==0&&m==0){
            result.add(new ArrayList<>(list));
            return;
        }
        if(n==0||m<0){
            return;
        }
        for(int i=start;i<=7;i++){
            list.add(i);
            findCombine(n-1, m-i, 1, list, result);
            list.remove(list.size()-1);
        }
    }
    private static List<List<Integer>> findResult(int n,int m){
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> combine = new ArrayList<>();
        List<Integer> indices = new ArrayList<>();
        for(int i=0;i<n;i++){
            combine.add(1);
            indices.add(1);
        }
        int index=0;
        while(index<n){
            if(combine.get(index)>7){
                combine.set(index, 1);
                index--;
                if(index<0){
                    break;
                }
                int newIndex= indices.get(index)+1;
                combine.set(index, newIndex);
            }else if(sum(combine)==m){
                result.add((new ArrayList<>(combine)));
                index--;
                if(index<0){
                    break;
                }
                int newIndex=indices.get(index)+1;
                combine.set(index, newIndex);
                indices.set(index, newIndex);
            }else{
                index++;
                if(index<n){
                    combine.set(index, combine.get(index-1));
                    indices.set(index, combine.get(index-1));
                }
            }
        }
        return result;
    }
    private static int sum(List<Integer> list){
        int sum =0;
        for(Integer i:list){
            sum+=i;
        }
        return sum;
    }
}
