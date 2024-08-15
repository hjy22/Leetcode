package Labuladong.Island;

//https://leetcode.com/problems/word-search
public class WordSearch79M {
    public static boolean found = false;

    public static void main(String[] args) {
        char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
        String word = "ABCCED";
        System.out.println(exist(board, word));
    }

    public static boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                dfs(i, j, board, 0, word);
                if (found) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void dfs(int i, int j, char[][] board, int index, String word) {
        int m = board.length, n = board[0].length;
        if (index == word.length() ) {
            found = true;
            return;
        }
        if(found){
            return;
        }
        if (i < 0 || j < 0 || i >= m || j >= n) {
            return;
        }
        if (board[i][j] != word.charAt(index)) {
            return;
        }

        board[i][j] = (char) -board[i][j];
        dfs(i - 1, j, board, index+1, word);
        dfs(i, j - 1, board, index+1, word);
        dfs(i + 1, j, board, index+1, word);
        dfs(i, j + 1, board, index+1, word);
    }
}
