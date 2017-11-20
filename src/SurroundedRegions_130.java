public class SurroundedRegions_130 {
    public void solve(char[][] board) {
        if (board.length <= 2 || board[0].length <= 2)
            return;

        for (int i = 1; i < board.length - 1; i++)
        {
            if (board[i][0] == 'O')
                bfs(board, i, 1, 3);

            if (board[i][board[0].length - 1] == 'O')
                bfs(board, i, board[0].length - 2, 1);
        }
        for (int i = 1; i < board[0].length - 1; i++)
        {
            if (board[0][i] == 'O')
                bfs(board, 1, i, 0);

            if (board[board.length - 1][i] == 'O')
                bfs(board, board.length - 2, i, 2);
        }

        for (int i = 1; i < board.length - 1; i++)
        {
            for (int j = 1; j < board[0].length - 1; j++)
            {
                if (board[i][j] == '#')
                    board[i][j] = 'O';
                else {
                    if (board[i][j] == 'O')
                        board[i][j] = 'X';
                }
            }
        }
    }

    // 0 ~ 3: up, right, down, left
    public void bfs(char[][] board, int row, int col, int from)
    {
        if (board[row][col] == '#' || board[row][col] == 'X')
            return;
        else
        {
            if (board[row][col] == 'O')
                board[row][col] = '#';
            if (from != 0 && row > 1)
                bfs(board, row - 1, col, 2);
            if (from != 1 && col < board[0].length - 2)
                bfs(board, row, col + 1, 3);
            if (from != 2 && row < board.length - 2)
                bfs(board, row + 1, col, 0);
            if (from != 3 && col > 1)
                bfs(board, row, col - 1, 1);
        }
    }
}
