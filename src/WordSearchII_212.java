import java.util.ArrayList;
import java.util.List;

public class WordSearchII_212 {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<String>();
        PrefixTreeNode root = buildTrie(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs (board, words, i, j, root, res);
            }
        }
        return res;
    }

    public void dfs(char[][] board, String[] words, int i, int j, PrefixTreeNode p, List<String> res) {
        char c = board[i][j];
        if (c == '.' || p.next[c - 'a'] == null)
            return;
        p = p.next[c - 'a'];
        if (p.iStr > -1) {
            res.add(words[p.iStr]);
            p.iStr = -1;
        }

        board[i][j] = '.';
        if (i > 0) dfs(board, words, i - 1, j ,p, res);
        if (j > 0) dfs(board, words, i, j - 1, p, res);
        if (i < board.length - 1) dfs(board, words, i + 1, j, p, res);
        if (j < board[0].length - 1) dfs(board, words, i, j + 1, p, res);
        board[i][j] = c;
    }

    public PrefixTreeNode buildTrie(String[] words) {
        PrefixTreeNode root = new PrefixTreeNode();
        for (int i = 0; i < words.length; i++)
        {
            PrefixTreeNode p = root;
            for (char c : words[i].toCharArray()) {
                int index = c - 'a';
                if (p.next[index] == null)
                    p.next[index] = new PrefixTreeNode();
                p = p.next[index];
            }
            p.iStr = i;
        }
        return root;
    }
}

class PrefixTreeNode {
    PrefixTreeNode[] next = new PrefixTreeNode[26];
    int iStr = -1;
}
