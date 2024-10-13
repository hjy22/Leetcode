package Tiktok;

// https://leetcode.com/problems/word-search/?envType=company&envId=tiktok&favoriteSlug=tiktok-thirty-days
public class WordSearch79M {
    static boolean exixt = false;

    public static void main(String[] args) {
        // char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
        // String word = "ABCCED";

        char[][] board = { { 'a'}};
        String word = "a";
        System.out.println(exist(board, word));
    }

    public static boolean exist(char[][] board, String word) {
        boolean[][] visit = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                
                dfs(i, j, board, word, 0, "", visit);
                if (exixt) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void dfs(int i, int j, char[][] board, String word, int index, String find, boolean[][] visit) {
        if (index == word.length()) {
            exixt = true;
            return;
        }
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return;
        }
        if (board[i][j] != word.charAt(index)||visit[i][j]) {
            return;
        }
        find += board[i][j];
        visit[i][j]=true;
        dfs(i - 1, j, board, word, index + 1, find, visit);
        dfs(i, j - 1, board, word, index + 1, find, visit);
        dfs(i + 1, j, board, word, index + 1, find, visit);
        dfs(i, j + 1, board, word, index + 1, find, visit);
        visit[i][j]=false;
    }
}
