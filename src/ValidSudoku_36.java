import java.util.Hashtable;
// O(n)
public class ValidSudoku_36 {
    public boolean isValidSudoku(char[][] board) {
        Hashtable<String, boolean> ht = new Hashtable<String, boolean>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.') {
                    String key1 = "row" + i + board[i][j];
                    String key2 = "col" + j + board[i][j];
                    String key3 = (i / 3) + "" + (j / 3) + board[i][j];
                    if (ht.containsKey(key1) || ht.containKey(key2) || ht.containsKey(key3))
                        return false;
                    else {
                        ht.put(key1, true);
                        ht.put(key2, true);
                        ht.put(key3, true);
                    }
                }
            }
        }
        return true;
    }
}
