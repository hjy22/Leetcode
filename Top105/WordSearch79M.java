package Top105;

// https://leetcode.com/problems/word-search/?envType=study-plan-v2&envId=top-interview-150
public class WordSearch79M {
    static boolean found = false;

    public static void main(String[] args) {
        char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
        String word = "ABCB";
        System.out.println(exist(board, word));
    }

    public static boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                String str = "";
                backtrack(board, word, i, j, str, 0, visited);
                if (found) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void backtrack(char[][] board, String word, int i, int j, String str, int index,
            boolean[][] visited) {
        if (index == word.length()) {
            found = true;
            return;
        }

        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return;
        }

        if (board[i][j] != word.charAt(index) || visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        str += board[i][j];
        backtrack(board, word, i - 1, j, str, index + 1, visited);
        backtrack(board, word, i, j - 1, str, index + 1, visited);
        backtrack(board, word, i + 1, j, str, index + 1, visited);
        backtrack(board, word, i, j + 1, str, index + 1, visited);
        visited[i][j] = false;
    }
}
