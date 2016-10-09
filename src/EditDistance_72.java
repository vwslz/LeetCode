import java.util.Hashtable;

// O(mn)
public class EditDistance_72 {
    public int minDistance(String word1, String word2) {
        int[][] res = new int[word1.length()+1][word2.length()+1];
        int i, j;
        res[0][0] = 0;
        for (i = 0; i < word1.length(); i++) {
            res[i + 1][0] = i + 1;
        }
        for (i = 0; i < word2.length(); i++) {
            res[0][i + 1] = i + 1;
        }
        for (i = 1; i <= word1.length(); i++) {
            for (j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    res[i][j] = res[i - 1][j - 1];
                else
                    res[i][j] = 1 + Math.min(res[i - 1][j], Math.min(res[i][j - 1], res[i - 1][j - 1]));
            }
        }
        return res[word1.length()][word2.length()];
    }
}
