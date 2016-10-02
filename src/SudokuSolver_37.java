import java.util.ArrayList;
import java.util.Hashtable;

// O(...)
public class SudokuSolver_37 {
    public void solveSudoku(char[][] board) {;
        ArrayList<int[]> list = new ArrayList<int[]>();
        Hashtable<String, Integer> ht = new Hashtable<String, Integer>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    list.add(new int[]{i, j});
                }
                else {
                    int value = board[i][j] - '0';
                    ht.put("r" + i + value, 1);
                    ht.put("c" + j + value, 1);
                    ht.put("s" + (i / 3) + (j / 3) + value, 1);
                }
            }
        }
        solve(board, list, ht, 0);
    }

    public boolean solve(char[][] board, ArrayList<int[]> list, Hashtable<String, Integer> ht, int index) {
        for (int i_list = index; i_list < list.size(); i_list++) {
            int i = list.get(i_list)[0], j = list.get(i_list)[1];
            for (int fill = 1; fill <= 9; fill++) {
                if (!ht.containsKey("r" + i + fill) && !ht.containsKey("c" + j + fill)
                        && !ht.containsKey("s" + (i / 3) + (j / 3) + fill)) {
                    board[i][j] = (char) ('0' + fill);
                    ht.put("r" + i + fill, 1);
                    ht.put("c" + j + fill, 1);
                    ht.put("s" + (i / 3) + (j / 3) + fill, 1);
                    if (solve(board, list, ht, index + 1))
                        return true;
                    else {
                        board[i][j] = '.';
                        ht.remove("r" + i + fill);
                        ht.remove("c" + j + fill);
                        ht.remove("s" + (i / 3) + (j / 3) + fill);
                    }
                }
            }
            return false;
        }
        return true;
    }
}
