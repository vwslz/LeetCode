import java.util.Arrays;
import java.util.Stack;

public class RemoveDuplicateLetters_316 {
    public String removeDuplicateLetters(String s) {
        if (s == "")    return s;

        char[] chars = s.toCharArray();

        Stack<Character> stack = new Stack<Character>();
        boolean[] isInStack = new boolean[26];
        int[] count = new int[26];
        Arrays.fill(count, 0);
        Arrays.fill(isInStack, false);
        for (char c: chars) {
            count[c - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            char c = chars[i];
            count[c - 'a']--;
            if (!isInStack[c - 'a']) {

                while (stack.size() > 0) {
                    char pre = stack.peek();
                    if (pre > c && count[pre - 'a'] > 0) {
                        isInStack[stack.pop() - 'a'] = false;;
                    }
                    else    break;
                }
                stack.push(c);

                isInStack[c - 'a'] = true;
            }
        }
        char[] res = new char[stack.size()];
        int index = stack.size() - 1;
        while (stack.size() > 0)    res[index--] = stack.pop();
        return String.valueOf(res);
    }
}
