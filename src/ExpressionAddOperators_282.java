import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperators_282 {
    List<String> res = new ArrayList<String>();
    public List<String> addOperators(String num, int target) {
        getVal(num, target, 1, "");
        return res;
    }

    public void getVal(String num, long target, long mul, String expression) {
        for (int i = 1; i <= num.length(); i++) {
            String strLeft = num.substring(0, i);

            if (strLeft.length() > 1 && strLeft.charAt(0) == '0')
                return;

            String strRight = num.substring(i);
            long left = Long.parseLong(strLeft);

            if (strRight.length() == 0) {
                if (left * mul != target)
                    return;
                else
                    res.add(expression + strLeft);
            }

            getVal(strRight, target - left * mul, 1, expression + strLeft + "+");
            getVal(strRight, target - left * mul, -1, expression + strLeft + "-");
            getVal(strRight, target, left * mul, expression + strLeft + "*");
        }
    }
}
