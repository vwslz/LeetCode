import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WordBreakII_140 {
    public List<String> wordBreak(String s, List<String> wordDict) {
        return wordBreakHelper(s, wordDict, new HashMap<String, List<String>>());
    }

    public List<String> wordBreakHelper(String s, List<String> wordDict, HashMap<String, List<String>> map)
    {
        if (map.containsKey(s))
            return map.get(s);

        List<String>res = new ArrayList<String>();

        for (String word : wordDict) {
            if (word.equals(s))
                res.add(word);
            else if (word.length() < s.length() && word.equals(s.substring(0, word.length())))
            {
                for (String str: wordBreakHelper(s.substring(word.length()), wordDict, map))
                    res.add(word + " " + str);
            }
        }
        map.put(s, res);
        return res;
    }
}
