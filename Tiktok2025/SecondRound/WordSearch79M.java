package Tiktok2025.SecondRound;

// https://leetcode.com/problems/word-search/?envType=company&envId=tiktok&favoriteSlug=tiktok-three-months
public class WordSearch79M {
    public static void main(String[] args) {
        char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
        String word = "ABCCED";
        System.out.println(exist(board, word));
    }

    static boolean wordExist = false;

    public static boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                backTrack(board, word, 0, i, j, new boolean[board.length][board[0].length]);
                if (wordExist) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void backTrack(char[][] board, String word, int index, int i, int j, boolean[][] visited) {
        if (wordExist) {
            return;
        }
        if (index == word.length()) {
            wordExist = true;
            return;
        }
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return;
        }
        if (visited[i][j]) {
            return;
        }

        if (word.charAt(index) != board[i][j]) {
            return;
        }
        visited[i][j] = true;
        backTrack(board, word, index + 1, i - 1, j, visited);
        backTrack(board, word, index + 1, i, j + 1, visited);
        backTrack(board, word, index + 1, i, j - 1, visited);
        backTrack(board, word, index + 1, i + 1, j, visited);
        visited[i][j] = false;
    }
}
