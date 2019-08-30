public class GameOfLie_289 {
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0)
            return;

        for (int iRow = 0; iRow < board.length; iRow++) {
            for (int iCol = 0; iCol < board[0].length; iCol++) {
                int numLiveNeighbours = 0;

                if (iRow - 1 >= 0) {
                    if (iCol - 1 >= 0 && board[iRow-1][iCol-1] % 2 == 1)
                        numLiveNeighbours++;
                    if (board[iRow-1][iCol] % 2 == 1)
                        numLiveNeighbours++;
                    if (iCol + 1 < board[0].length && board[iRow-1][iCol+1] % 2 == 1)
                        numLiveNeighbours++;
                }
                if (iRow + 1 < board.length) {
                    if (iCol - 1 >= 0 && board[iRow+1][iCol-1] % 2 == 1)
                        numLiveNeighbours++;
                    if (board[iRow + 1][iCol] % 2 == 1)
                        numLiveNeighbours++;
                    if (iCol + 1 < board[0].length && board[iRow+1][iCol+1] % 2 == 1)
                        numLiveNeighbours++;
                }
                if (iCol - 1 >= 0 && board[iRow][iCol-1] % 2 == 1)
                    numLiveNeighbours++;
                if (iCol + 1 < board[0].length && board[iRow][iCol+1] % 2 == 1)
                    numLiveNeighbours++;

                if (board[iRow][iCol] == 1 && (numLiveNeighbours < 2 || numLiveNeighbours > 3))
                    board[iRow][iCol] = 3;
                if (board[iRow][iCol] == 0 && numLiveNeighbours == 3)
                    board[iRow][iCol] = 2;
            }
        }

        for (int iRow = 0; iRow < board.length; iRow++) {
            for (int iCol = 0; iCol < board[0].length; iCol++) {
                if (board[iRow][iCol] == 2)
                    board[iRow][iCol] = 1;
                if (board[iRow][iCol] == 3)
                    board[iRow][iCol] = 0;
            }
        }
    }
}