import java.util.Stack;

public class ReverseWordsInAString_151 {
    public String reverseWords(String s) {
        Stack<String> stack = new Stack<String>();
        for (String iter: s.split(" ")){
            stack.push(iter);
        }
        String res = "";
        while(!stack.isEmpty()){
            res += stack.pop();
            if(!stack.isEmpty()){
                res += " ";
            }
        }
        return res.trim().replaceAll(" +", " ");
    }
}
