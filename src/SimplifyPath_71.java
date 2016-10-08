import java.util.Stack;

// O(n)
public class SimplifyPath_71 {
    public String simplifyPath(String path) {
        Stack<String> s = new Stack<String>();
        String res = "";
        String[] array_s = path.split("/+");

        for (int i = 1; i < array_s.length; i++){
            if (!array_s[i].equals(".")){
                if (array_s[i].equals("..")){
                    if (s.size() > 0)
                        s.pop();
                }
                else {
                    s.push(array_s[i]);
                }
            }
        }

        if(s.size() == 0)
            return "/";
        while (s.size() > 0){
            res = "/" + s.pop() + res;
        }

        return res;
    }
}