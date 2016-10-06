// O(n ^ 2)
public class SpiralMatrixII_59 {
    public int[][] generateMatrix(int n) {
        if (n <= 0) return null;
        if (n == 1) return new int[][]{{1}};
        int[][] res = new int[n][n];
        toRight(res, 1, 0, 0, n);
        return res;
    }

    public void toRight(int[][] matrix, int integer, int row, int col, int n) {
        if (integer > n * n)
            return;
        for (int i = 0; i < n - col; i++) {
            matrix[row / 2][col / 2 + i] = integer++;
        }
        toBottom(matrix, integer, row + 1, col, n);
    }
    public void toBottom(int[][] matrix, int integer, int row, int col, int n) {
        if (integer > n * n)
            return;
        for (int i = 0; i < n - row; i++) {
            matrix[row / 2 + 1 + i][n - 1 - col/2] = integer++;
        }
        toLeft(matrix, integer, row, col + 1, n);
    }
    public void toLeft(int[][] matrix, int integer, int row, int col, int n) {
        if (integer > n * n)
            return;
        for (int i = 0; i < n - col; i++) {
            matrix[n - 1 - row / 2][n - 2 - col / 2 - i] = integer++;
        }
        toTop(matrix, integer, row + 1, col, n);
    }

    public void toTop(int[][] matrix, int integer, int row, int col, int n) {
        if (integer > n * n)
            return;
        for (int i = 0; i < n - row; i++) {
            matrix[n - 1 - row / 2  - i][col/2] = integer++;
        }
        toRight(matrix, integer, row, col + 1, n);
    }
}
