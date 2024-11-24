package Google;

// https://leetcode.com/problems/satisfiability-of-equality-equations/
public class SatisfiabilityofEqualityEquations990M {
    static int[] parent;
    static int[] rank;

    public static void main(String[] args) {
        String[] equations = { "a==b", "b!=a" };
        System.out.println(equationsPossible(equations));
    }

    public static boolean equationsPossible(String[] equations) {
        // initialize set
        initialize();
        // union equal
        for (String equation : equations) {
            if (equation.charAt(1) == '=') {
                char a = equation.charAt(0);
                char b = equation.charAt(3);
                union(a, b);
            }
        }
        // check uneuqal sign
        for (String equation : equations) {
            if (equation.charAt(1) == '!') {
                char a = equation.charAt(0);
                char b = equation.charAt(3);
                if (find(a - 'a') == find(b - 'a')) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void initialize() {
        parent = new int[26];
        rank = new int[26];
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    public static int find(int c) {
        if (parent[c] != c) {
            parent[c] = find(parent[c]);
        }
        return parent[c];
    }

    public static void union(char c1, char c2) {
        int root1 = find(c1 - 'a');
        int root2 = find(c2 - 'a');

        if (root1 != root2) {
            if (rank[root1] < rank[root2]) {
                parent[root1] = root2;
            } else if (rank[root1] > rank[root2]) {
                parent[root2] = root1;
            } else {
                parent[root1] = root2;
                rank[root2]++;
            }
        }
    }
}
