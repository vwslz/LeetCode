import java.util.Stack;

// O(n)
public class ValidParenthese_20 {
    public boolean isValid(String s) {
        char[] c = s.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < s.length(); i++){
            char c_s = c[i];
            if(c_s == '(' || c_s == '[' || c_s == '{')
                stack.push(c_s);
            else {
                if(stack.isEmpty()) return false;
                char pre = stack.pop();
                if((c_s == ')' && pre != '(') || (c_s == ']' && pre != '[') || (c_s == '}' && pre != '{'))
                    return false;
            }
        }
        return stack.isEmpty() ? true: false;
    }
}
