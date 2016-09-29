import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

// O(n * l)
public class SubstringWithConcatenationOfAllWords_30 {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<Integer>();
        if (s == null || s.length() == 0 || words == null || words.length == 0 ||  s.length() < words.length * words[0].length())
            return res;
        int len = words[0].length(), size_window = len * words.length;
        char[] chars_s = s.toCharArray();
        Hashtable<String, Integer> ht = new Hashtable<String, Integer>();
        for (String word: words) {
            ht.put(word, ht.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i < len; i++) {
            int left = i, right = left, count = words.length;
            Hashtable<String, Integer> ht_search = new Hashtable<>();
            ht_search.putAll(ht);

            while (right + len <= s.length()) {
                String win = s.substring(right, right + len);
                right += len;
                if (ht_search.containsKey(win)) {

                    if (ht_search.get(win) <= 0) {
                        while (ht_search.get(win) < 1) {
                            addBack(ht_search, s, left, len);
                            left += len;
                            count++;
                        }
                    }

                    count -= 1;
                    ht_search.put(win, ht_search.get(win) - 1);
                }
                else {
                    while (left < right - len) {
                        addBack(ht_search, s, left, len);
                        left += len;
                        count++;
                    }
                    left = right;
                }
                if (count == 0) {
                    res.add(left);
                    addBack(ht_search, s, left, len);
                    left += len;
                    count++;
                }
            }
        }

        return res;
    }

    public void addBack(Hashtable<String, Integer> ht, String s, int left, int len) {
        String key = s.substring(left, left + len);
        ht.put(key, ht.get(key) + 1);
    }
}
