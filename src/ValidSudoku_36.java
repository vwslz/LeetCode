import java.util.Hashtable;
// O(n)
public class ValidSudoku_36 {
    public boolean isValidSudoku(char[][] board) {
        Hashtable<String, Integer> ht = new Hashtable<String, Integer>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.') {
                    String key1 = "r" + i + board[i][j];
                    String key2 = "c" + j + board[i][j];
                    int c_i = i / 3, c_j = j / 3;
                    String key3 = "" + c_i + c_j  + board[i][j];
                    if (ht.containsKey(key1) || ht.containsKey(key2) || ht.containsKey(key3))
                        return false;
                    else {
                        ht.put(key1, 0);
                        ht.put(key2, 0);
                        ht.put(key3, 0);
                    }
                }
            }
        }
        return true;
    }
}
