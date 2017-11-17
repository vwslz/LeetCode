public class InterleavingString_97 {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s3.length() != s1.length() + s2.length())
            return false;
        boolean[][] res = new boolean[s1.length() + 1][s2.length() + 1];
        res[0][0] = true;
        for (int i = 0; i < s1.length(); i++)
            res[i + 1][0] = (res[i][0] && s1.charAt(i) == s3.charAt(i));
        for (int i = 0; i < s2.length(); i++)
            res[0][i + 1] = (res[0][i] && s2.charAt(i) == s3.charAt(i));
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <=  s2.length(); j++) {
                if ((res[i - 1][j] && (s1.charAt(i - 1) == s3.charAt(i + j - 1))) ||
                        (res[i][j - 1] && (s2.charAt(j - 1) == s3.charAt(i + j - 1))))
                    res[i][j] = true;
                else
                    res[i][j] = false;
            }
        }
        return res[s1.length()][s2.length()];
    }
}
