// O(mn)
public class RegularExpressionMatching_10 {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) return false;
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        int i = 0;
        dp[0][0] = true;
        while (i < p.length()) {
            if (p.charAt(i) == '*' && dp[0][i-1])  dp[0][i+1] = true;
            i++;
        }
        for (i = 0; i < s.length(); i++){
            for (int j = 0; j < p.length(); j++){
                if (p.charAt(j) == '.' || p.charAt(j) == s.charAt(i)) dp[i + 1][j + 1] = dp[i][j];
                else if (p.charAt(j) == '*') {
                    if (p.charAt(j - 1) != s.charAt(i) && p.charAt(j - 1) != '.') {
                        dp[i + 1][j + 1] = dp[i +
                                1][j - 1];
                    } else {
                        dp[i + 1][j + 1] = (dp[i + 1][j] || dp[i][j + 1] || dp[i + 1][j - 1]);
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}
