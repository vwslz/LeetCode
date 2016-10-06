import java.util.*;

// O(n^n)
public class N_Queens_51 {
    public List<List<String>> solveNQueens(int n) {
        List res = new ArrayList<String>();
        if (n <= 0)
            return res;
        String[] board = new String[n];
        boolean[] cols = new boolean[n];
        boolean[] dgls1 = new boolean[2 * n - 1];
        boolean[] dgls2 = new boolean[2 * n - 1];
        Arrays.fill(cols, false);
        Arrays.fill(dgls1, false);
        Arrays.fill(dgls2, false);
        putQueen(board, n, 0, cols, dgls1, dgls2, res);
        return res;
    }

    public void putQueen(String[] board, int n, int row, boolean[] cols,
                         boolean[] dgls1 , boolean[] dgls2, List res) {
        if (row == n) {
            res.add(board.clone());
            return;
        }
        for (int col = 0; col < n; col++) {
            int dgl1 = row - col + n - 1, dgl2 = row + col;
            if (!cols[col] && !dgls1[dgl1] && !dgls2[dgl2]) {
                char[] chars = new char[n];
                Arrays.fill(chars, '.');
                chars[col] = 'Q';
                board[row] = String.valueOf(chars);
                cols[col] = true;
                dgls1[dgl1] = true;
                dgls2[dgl2] = true;
                putQueen(board, n, row + 1, cols, dgls1, dgls2, res);
                cols[col] = false;
                dgls1[dgl1] = false;
                dgls2[dgl2] = false;
            }
        }
    }
}
