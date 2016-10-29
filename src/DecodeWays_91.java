// O(n)
public class DecodeWays_91 {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0)  return 0;
        char[] c = s.toCharArray();
        int[] res = new int[c.length + 1];
        res[0] = 1;
        if (s.charAt(0) == '0')
            return 0;
        else
            res[1] = 1;
        for (int i = 0; i < c.length; i++) {
            if (s.charAt(i) == '0') {
                if (i > 0 && (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2'))
                    res[i + 1] = res[i - 1];
                else
                    return 0;
            }
            else {
                if (s.charAt(i - 1) == '1' || (s.charAt(i -1) == '2' &&s.charAt(i) <= '6'))
                    res[i + 1] = res[i - 1] + res[i];
                else
                    res[i + 1] = res[i];
            }
        }
        return res[c.length];
    }
}
