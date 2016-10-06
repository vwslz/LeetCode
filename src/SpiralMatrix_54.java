import java.util.ArrayList;
import java.util.List;

// O(mn)
public class SpiralMatrix_54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        if (matrix.length == 0 || matrix[0].length == 0)    return res;
        toRight(matrix,res, 0, 0, matrix.length, matrix[0].length);
        return res;
    }
    public void toRight(int[][] matrix, List<Integer> res, int row, int col, int m, int n) {
        if (col >= n)
            return;
        for (int i = 0; i < n - col; i++) {
            res.add(matrix[row / 2][col / 2 + i]);
        }
        toBottom(matrix, res, row + 1, col, m, n);
    }
    public void toBottom(int[][] matrix, List<Integer> res, int row, int col, int m, int n) {
        if (row >= m)
            return;
        for (int i = 0; i < m - row; i++) {
            res.add(matrix[row / 2 + 1 + i][n - 1 - col/2]);
        }
        toLeft(matrix, res, row, col + 1, m, n);
    }
    public void toLeft(int[][] matrix, List<Integer> res, int row, int col, int m, int n) {
        if (col >= n)
            return;
        for (int i = 0; i < n - col; i++) {
            res.add(matrix[m - 1 - row / 2][n - 2 - col / 2 - i]);
        }
        toTop(matrix, res, row + 1, col, m, n);
    }

    public void toTop(int[][] matrix, List<Integer> res, int row, int col, int m, int n) {
        if (row >= m)
            return;
        for (int i = 0; i < m - row; i++) {
            res.add(matrix[m - 1 - row / 2  - i][col/2]);
        }
        toRight(matrix, res, row, col + 1, m, n);
    }
}
