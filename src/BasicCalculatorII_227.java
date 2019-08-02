public class BasicCalculatorII_227 {
    public int calculate(String s) {
        int res = 0;
        char[] chars = s.toCharArray();

        return calculateAddOrSub(chars, 0, chars.length - 1);
    }

    public int calculateAddOrSub(char[] chars, int left, int right) {
        if (left > right)
            return 0;

        int res = 0;
        int pre = 0;
        int sign = 1;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '+' || chars[i] == '-')
            {
                res += sign * calculateHelper(chars, pre, i - 1);
                sign = chars[i] == '+' ? 1 : -1;
                pre = i + 1;
            }
        }
        return res + sign * calculateHelper(chars, pre, chars.length - 1);
    }


    public int calculateHelper(char[] chars, int left, int right) {
        if (left > right)
            return 1;

        int res = 1;
        boolean mul = true;
        int current = 0;

        for (int i = left; i <= right; i++) {
            if (chars[i] >= '0')
                current = current * 10 + chars[i] - '0';
            else if (chars[i] == '*' || chars[i] == '/'){
                if (mul)
                    res *= current;
                else
                    res /= current;
                current = 0;
                mul = chars[i] == '*';
            }
        }

        if (mul)
            return res * current;
        else
            return res / current;
    }
}
