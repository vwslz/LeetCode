public class PalindromePartitioningII_132 {
    public int minCut(String s) {
        int[] res = new int[s.length() + 1];

        for (int i = 0; i < s.length() + 1; i++)
            res[i] = i - 1;
        for (int i = 0; i < s.length(); i++)
        {
            for (int j = 0; i - j >= 0 && i + j < s.length(); j++)
            {
                if (s.charAt(i - j) == s.charAt(i + j))
                    res[i + j + 1] = Math.min(res[i + j + 1], res[i - j] + 1);
                else
                    break;
            }

            for (int j = 1; i - j + 1 >= 0 && i + j < s.length(); j++)
            {
                if (s.charAt(i - j + 1) == s.charAt(i + j))
                    res[i + j + 1] = Math.min(res[i + j + 1], res[i - j + 1] + 1);
                else
                    break;
            }
        }
        return res[s.length()];
    }
}
