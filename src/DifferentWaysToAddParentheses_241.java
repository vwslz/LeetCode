import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DifferentWaysToAddParentheses_241 {
    // add memorize step using hashmap
    HashMap<String, List<Integer>> map = new HashMap<String, List<Integer>>();
    public List<Integer> diffWaysToCompute(String input) {
        if (map.containsKey(input))
            return map.get(input);
        List<Integer> res = new ArrayList<Integer>();

        char[] inputs = input.toCharArray();
        for (int i = 0; i < input.length(); i++) {
            if (inputs[i] < '0') {
                for (int left : diffWaysToCompute(input.substring(0, i))) {
                    for (int right : diffWaysToCompute(input.substring(i + 1))) {
                        if (inputs[i] == '+')
                            res.add(left + right);
                        else if (inputs[i] == '-')
                            res.add(left - right);
                        else if (inputs[i] == '*')
                            res.add(left * right);
                    }
                }
            }
        }
        if (res.size() == 0)
            res.add(Integer.valueOf(input));
        map.put(input, res);
        return res;
    }
}