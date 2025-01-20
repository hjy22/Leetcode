package Tiktok2025;

// https://leetcode.com/problems/satisfiability-of-equality-equations/description/
public class SatisfiabilityofEqualityEquations990M {
    public static void main(String[] args) {
        String[] equations = { "a==b", "b!=a" };
        System.out.println(equationsPossible(equations));
    }

    public static boolean equationsPossible(String[] equations) {
        // initialize
        int[] parent = new int[26];
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
        }
        // union
        for (String equation : equations) {
            if (equation.charAt(1) == '=') {
                char c1 = equation.charAt(0);
                char c2 = equation.charAt(3);
                union(c1, c2, parent);
            }
        }
        // check

        for (String equation : equations) {
            if (equation.charAt(1) == '!') {
                char c1 = equation.charAt(0);
                char c2 = equation.charAt(3);
                if (find(c1 - 'a', parent) == find(c2 - 'a', parent)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void union(char e1, char e2, int[] parent) {
        int root1 = find(e1 - 'a', parent);
        int root2 = find(e2 - 'a', parent);
        if (root1 == root2) {
            return;
        }
        parent[root1] = root2;

    }

    public static int find(int e, int[] parent) {
        if (parent[e] != e) {
            parent[e] = find(parent[e], parent);
        }
        return parent[e];
    }
}
