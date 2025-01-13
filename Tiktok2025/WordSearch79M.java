package Tiktok2025;

// https://leetcode.com/problems/word-search/?envType=company&envId=tiktok&favoriteSlug=tiktok-three-months
public class WordSearch79M {
    static boolean exist = false;

    public static void main(String[] args) {
        char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
        String word = "ABCCED";
        System.out.println(exist(board, word));
    }

    public static boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {

                dfs(i, j, board, visited, 0, word);
                if (exist) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void dfs(int i, int j, char[][] board, boolean[][] visited, int index, String word) {
        if (index == word.length()) {
            exist = true;
            return;
        }

        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return;
        }
        if (word.charAt(index) != board[i][j] || visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        dfs(i - 1, j, board, visited, index + 1, word);
        dfs(i, j - 1, board, visited, index + 1, word);
        dfs(i, j + 1, board, visited, index + 1, word);
        dfs(i + 1, j, board, visited, index + 1, word);
        visited[i][j] = false;
    }
}
