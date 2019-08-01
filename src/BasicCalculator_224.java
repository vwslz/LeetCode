// O(n)
import java.util.Stack;

public class BasicCalculator_224 {
    public int calculate(String s) {
        char[] chars = s.toCharArray();
        Stack<Integer> stack = new Stack<Integer>();

        int res = 0;
        int sign = 1;
        int current = 0;
        stack.push(sign);

        for (char c: chars) {
            if (c >= '0')
                current = current * 10 + c - '0';
            else if (c == '(')
                stack.push(sign);
            else if (c == ')')
                stack.pop();
            else if (c != ' ') {
                int signCurrent = c == '+' ? 1 : -1;
                res += sign * current;
                current = 0;
                sign = stack.peek() * signCurrent;
            }
        }

        return res + sign * current;
    }
}
