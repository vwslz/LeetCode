import java.util.Arrays;
import java.util.Set;

public class WordBreak_139 {
    public boolean wordBreak(String s, Set<String> wordDict) {
        if (s.length() == 0)  return true;

        boolean[] res = new boolean[s.length() + 1];
        Arrays.fill(res, false);
        res[0] = true;
        int max = -1, min = Integer.MAX_VALUE;
        for (String str: wordDict) {
            if (str.length() > max) max = str.length();
            if (str.length() < min) min = str.length();
        }
        for (int end = 1; end < s.length() + 1; end++) {
            int left = (end - max > 0) ? end - max : 0;
            int right = (end - min > 0) ? end - min : 0;
            for (int index = left; index <= right; index++) {
                if(res[index] && wordDict.contains(s.substring(index,end))){
                    res[end] = true;
                    break;
                }
            }
        }
        return res[s.length()];
    }
}
