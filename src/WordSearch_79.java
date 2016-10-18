// O()
public class WordSearch_79 {
    public boolean exist(char[][] board, String word) {
        if (board.length == 0 || board[0].length == 0)
            return false;

        // seach for first letter, then BFS
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    board[i][j] = '#';
                    if (neighbor(board, word, i, j, 1))
                        return true;
                    board[i][j] = word.charAt(0);
                }
            }
        }
        return false;
    }

    public boolean neighbor(char[][]board, String word, int row, int col, int index) {
        if (index == word.length())
            return true;
        else {
            if (row > 0 && board[row - 1][col] == word.charAt(index)) {
                board[row - 1][col] = '#';
                if (neighbor(board, word, row - 1, col, index + 1))
                    return true;
                board[row - 1][col] = word.charAt(index);
            }
            if (col > 0 && board[row][col - 1] == word.charAt(index)) {
                board[row][col - 1] = '#';
                if (neighbor(board, word, row, col - 1, index + 1))
                    return true;
                board[row][col - 1] = word.charAt(index);
            }
            if (row < board.length - 1 && board[row + 1][col] == word.charAt(index)) {
                board[row + 1][col] = '#';
                if (neighbor(board, word, row + 1, col, index + 1))
                    return true;
                board[row + 1][col] = word.charAt(index);
            }
            if (col < board[0].length - 1 && board[row][col + 1] == word.charAt(index)) {
                board[row][col + 1] = '#';
                if (neighbor(board, word, row, col + 1, index + 1))
                    return true;
                board[row][col + 1] = word.charAt(index);
            }
            return false;
        }
    }
}