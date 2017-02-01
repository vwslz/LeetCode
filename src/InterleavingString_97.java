
public class InterleavingString_97 {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s3.length() != s1.length() + s2.length())
            return false;
        boolean[][] res = new boolean[s1.length() + 1][s2.length() + 1];
        res[0][0] = true;
        for (int i = 0; i < s1.length(); i++)
            res[i + 1][0] = (s1.charAt(i) == s3.charAt(i)) ? true: false;
        for (int i = 0; i < s2.length(); i++)
            res[0][i + 1] = (s2.charAt(i) == s3.charAt(i)) ? true: false;
        for (int i = 1; i <= s3.length(); i++) {
            for (int j = 1; j <=  i; j++) {
                if ((res[j - 1][i + 1 - j] && (s2.charAt(j) == s3.charAt(i))) ||
                        (res[j][i - j] && (s1.charAt(i - j) == s3.charAt(i))))
                    res[j][i - j + 1] = true;
                else
                    res[j][i - j + 1] = false;
            }
        }
        return res[s1.length()][s2.length()];
    }
}

