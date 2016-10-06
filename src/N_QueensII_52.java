import java.util.Arrays;

// O(n^n)
public class N_QueensII_52 {
    public int totalNQueens(int n) {
        if (n <= 0) return 0;
        boolean[] cols = new boolean[n];
        boolean[] dgls1 = new boolean[2 * n - 1];
        boolean[] dgls2 = new boolean[2 * n - 1];
        Arrays.fill(cols, false);
        Arrays.fill(dgls1, false);
        Arrays.fill(dgls2, false);
        return putQueen(n, 0, cols, dgls1, dgls2, 0);
    }

    public int putQueen(int n, int row, boolean[] cols, boolean[] dgls1 , boolean[] dgls2, int res) {
        if (row == n)   return res + 1;
        for (int col = 0; col < n; col++) {
            int dgl1 = row - col + n - 1, dgl2 = row + col;
            if (!cols[col] && !dgls1[dgl1] && !dgls2[dgl2]) {
                cols[col] = true;
                dgls1[dgl1] = true;
                dgls2[dgl2] = true;
                res = putQueen(n, row + 1, cols, dgls1, dgls2, res);
                cols[col] = false;
                dgls1[dgl1] = false;
                dgls2[dgl2] = false;
            }
        }
        return res;
    }
}
