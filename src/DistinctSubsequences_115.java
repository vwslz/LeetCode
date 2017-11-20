public class DistinctSubsequences_115 {
    public int numDistinct(String s, String t) {
        if (s.length() == 0 || t.length() == 0)
            return 0;

        int[][] res = new int[t.length()][s.length()];
        char[] charS = s.toCharArray();
        char[] charT = t.toCharArray();

        if (charS[0] == charT[0])
            res[0][0] = 1;
        else
            res[0][0] = 0;

        for (int i = 1; i < t.length(); i++)
            res[i][0] = 0;
        for (int i = 1; i < s.length(); i++)
        {
            if (charS[i] == charT[0])
                res[0][i] = res[0][i - 1] + 1;
            else
                res[0][i] = res[0][i - 1];
        }

        for (int i = 1; i < t.length(); i++)
        {
            for (int j = 1; j < s.length(); j++)
            {
                if (charS[j] == charT[i])
                    res[i][j] = res[i - 1][j - 1] + res[i][j - 1];
                else
                    res[i][j] = res[i][j - 1];
            }
        }

        return res[t.length() - 1][s.length() - 1];
    }
}
