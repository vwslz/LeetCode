import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class RemoveInvalidParentheses_301 {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<String>();

        int left = 0;
        int cnt = 0;
        s = optString(s);

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')') {
                if (left == 0)
                    cnt++;
                else
                    left--;
            }
            else if (c == '(') {
                left++;
            }
        }

        cnt += left;

        removeInvalidParenthesesRecur(res, s, cnt , "", 0, 0, 0);

        return res;
    }

    public String optString(String s){
        if (s.length() == 0)
            return s;
        int left = 0;
        int right = s.length();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')')
                left++;
            else
                break;
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(')
                right--;
            else
                break;
        }

        if (left >= right)
            return "";
        return s.substring(left, right);
    }

    public void removeInvalidParenthesesRecur(List<String> res, String s, int cnt, String iter_str, int i_str, int i_cnt, int left) {
        if (iter_str.length() == s.length() - cnt && left == 0)
            res.add(iter_str);
        else if (i_str < s.length() && i_cnt <= cnt) {
            char c = s.charAt(i_str);

            if (c == '(') {
                removeInvalidParenthesesRecur(res, s, cnt, iter_str + c, i_str + 1, i_cnt, left + 1);
                int numSkip = getNumSkip(s, c, i_str);
                // Skip char
                removeInvalidParenthesesRecur(res, s, cnt, iter_str, i_str + numSkip, i_cnt + numSkip, left);
            }
            else if (c == ')') {
                if (left > 0) {
                    removeInvalidParenthesesRecur(res, s, cnt, iter_str + c, i_str + 1, i_cnt, left - 1);
                }
                int numSkip = getNumSkip(s, c, i_str);
                removeInvalidParenthesesRecur(res, s, cnt, iter_str, i_str + numSkip, i_cnt + numSkip, left);
            }
            else{
                removeInvalidParenthesesRecur(res, s, cnt, iter_str + c, i_str + 1, i_cnt, left);
            }
        }
    }

    public int getNumSkip(String s, char c, int i_c) {
        int res = 0;
        for (int i = i_c; i < s.length(); i++) {
            if (s.charAt(i) == c)
                res++;
            else
                break;
        }
        return res;
    }
}
