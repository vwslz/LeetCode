// O(mn)
public class WildcardMatching_44 {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        int i = 0, j = 0;
        dp[0][0] = true;
        for (i = 0; i < p.length(); i++) {
            dp[0][i + 1] = p.charAt(i) == '*' && dp[0][i];
        }
        for (i = 0; i < s.length(); i++) {
            dp[i + 1][0] =false;
        }
        for (i = 0; i < s.length(); i++) {
            for (j = 0; j < p.length(); j++) {
                if (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i))
                    dp[i + 1][j + 1] = dp[i][j];
                else if (p.charAt(j) == '*')
                    dp[i + 1][j + 1] = dp[i][j+1] || dp[i + 1][j];
                else
                    dp[i + 1][j + 1] = false;
            }
        }
        return dp[s.length() + 1][p.length() + 1];
    }
}
