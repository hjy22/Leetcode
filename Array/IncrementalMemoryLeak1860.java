package Array;

public class IncrementalMemoryLeak1860 {
    public static void main(String[] args) {
        int memory1 = 9, memory2 = 6;
        int[] ans = memLeak(memory1, memory2);
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }

    public static int[] memLeak(int memory1, int memory2) {
        int i = 0;
        while (memory1 >= 0||memory2 >= 0) {
            i++;
            if (memory1 >= memory2) {
                if (memory1 - i >= 0) {
                    memory1 -= i;
                }else{break;}
            } else {
                if (memory2 - i >= 0) {
                    memory2 -= i;
                }else{break;}
            }
        }
        return new int[] { i+1, memory1, memory2 };
    }
}
