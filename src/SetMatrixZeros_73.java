//O(mn)
public class SetMatrixZeros_73 {
    public void setZeroes(int[][] matrix) {
        if (matrix.length < 1 || matrix[0].length < 1)
            return;
        int row = -1, col = -1, i, j;
        boolean found = false;
        for (i = 0; i < matrix.length; i++) {
            if (found)
                break;
            for (j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    row = i;
                    col = j;
                    found = true;
                    break;
                }
            }
        }
        if (row == -1)
            return;
        setLines(matrix, row, col, false);
        mark(matrix, row, col);
        setZeroesHelper(matrix, row, col);
        setLines(matrix, row, col, true);
    }

    public void setLines(int[][] matrix, int row, int col, boolean toZero) {
        int i;
        for (i = 0; i < matrix.length; i++) {
            if (!toZero && matrix[i][col] == 0)
                matrix[i][col] = -1;
            else
                matrix[i][col] = 0;
        }
        for (i = 0; i < matrix[0].length; i++) {
            if (!toZero && matrix[row][i] == 0)
                matrix[row][i] = -1;
            else
                matrix[row][i] = 0;
        }
    }

    public void mark(int[][] matrix, int row, int col) {
        int i, j;
        for (i = 0; i < matrix.length; i++) {
            if (i == row)
                continue;
            for (j = 0; j < matrix[0].length; j++) {
                if (j == col)
                    continue;
                if (matrix[i][j] == 0) {
                    matrix[i][col] = -1;
                    matrix[row][j] = -1;
                }
            }
        }
    }

    public void setZeroesHelper(int[][] matrix, int row, int col) {
        int i, j;
        boolean isRow = false;
        for (i = 0; i < matrix.length; i++) {
            if (i == row)
                continue;
            for (j = 0; j < matrix[0].length; j++) {
                if (j == col)
                    continue;
                if (matrix[i][col] == -1 || matrix[row][j] == -1)
                    matrix[i][j] = 0;
            }
        }
    }
}
