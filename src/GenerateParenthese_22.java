import java.util.ArrayList;
import java.util.List;

// O(n)
public class GenerateParenthese_22 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        char[] chars = new char[2 * n];
        generate(res, chars, n, n, n);
        return res;
    }
    public void generate(List<String> res, char[] chars, int left, int right, int n){
        if (left > right){
            return;
        }
        if (left > 0){
            chars[n - left - right] = '(';
            generate(res, chars, left-1, right, n);
        }
        if (right > 0){
            chars[n - left - right] = ')';
            generate(res, chars, left, right-1, n);
        }
        if (left == 0 && right == 0) {
            res.add(String.valueOf(chars));
            return;
        }
    }
}
