package Interview.tiktok;
import java.util.*;

public class ViralContentBalancer {
    
    public static int balanceContent(String content) {
         // 计算每个字符的频率
         Map<Character, Integer> freqMap = new HashMap<>();
         for (char ch : content.toCharArray()) {
             freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
         }
         
         // 获取频率列表
         List<Integer> frequencies = new ArrayList<>(freqMap.values());
         Collections.sort(frequencies);
         
         // 如果只有一个字符，已经平衡
         if (frequencies.size() == 1) {
             return 0;
         }
         
         // 计算中位数
         int median;
         if (frequencies.size() % 2 == 1) {
             median = frequencies.get(frequencies.size() / 2);
         } else {
             int mid1 = frequencies.get(frequencies.size() / 2 - 1);
             int mid2 = frequencies.get(frequencies.size() / 2);
             median = (mid1 + mid2) / 2;
         }
         
         // 计算调整操作数
         int operations = 0;
         for (int freq : frequencies) {
             operations += Math.abs(freq - median);
         }
         
         return operations;
    }
    
    public static void main(String[] args) {
        // Example Usage
        String content1 = "xzyzxa";
        System.out.println(balanceContent(content1)); // Output: 2
        
        String content2 = "ababc";
        System.out.println(balanceContent(content2)); // Output: 1
    }
}

