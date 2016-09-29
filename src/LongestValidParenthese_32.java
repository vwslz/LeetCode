// O(n)
public class LongestValidParenthese_32 {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() < 2)   return 0;
        int[] res = new int[s.length()];
        res[0] = 0;
        res[1] = (s.charAt(0) == '(' && s.charAt(1) == ')') ? 2 : 0;
        for (int i = 2; i < s.length(); i++) {
            if (s.charAt(i) == '(') res[i] = 0;
            else {
                if (s.charAt(i-1) == '(')   res[i] = res[i-2] + 2;
                else {
                    if (i - 1 - res[i-1] >= 0 && s.charAt(i - 1 - res[i-1]) == '(') {
                        res[i] = 2 + res[i-1];
                        if (i - 2 - res[i-1] >= 0)
                            res[i] += res[i - 2 - res[i - 1]];
                    }
                    else res[i] = 0;
                }
            }
        }
        int max = 0;
        for (Integer integer: res) {
            if (integer > max)  max = integer;
        }
        return max;
    }
}
