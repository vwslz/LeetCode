import java.util.Hashtable;

// O(n)
public class MinimumWindowSubstring_76 {
    public String minWindow(String s, String t) {
        Hashtable<Character, Integer> ht_chars = new Hashtable<Character, Integer>();
        int i, start = 0, end = 0, sum = 0, res_start = 0, res_end = res_start - 1, res_len = s.length() + 1;
        for (i = 0; i < t.length(); i++) {
            ht_chars.put(t.charAt(i), ht_chars.getOrDefault(t.charAt(i), 0) - 1);
        }
        for (Character c: ht_chars.keySet()) {
            sum += ht_chars.get(c);
        }
        while (end < s.length()) {
            char c = s.charAt(end);
            if (ht_chars.containsKey(c)) {
                ht_chars.put(c, ht_chars.get(c) + 1);
                if (ht_chars.get(c) <= 0)
                    sum++;
                if (sum == 0) {
                    if (end - start + 1 < res_len) {
                        res_start = start;
                        res_end = end;
                        res_len = end - start + 1;
                    }
                    while (start <= end && sum >= 0) {
                        char c_start = s.charAt(start);
                        if (ht_chars.containsKey(c_start)) {
                            ht_chars.put(c_start, ht_chars.get(c_start) - 1);
                            if (ht_chars.get(c_start) < 0)
                                sum--;
                            if (sum < 0) {
                                if (end - start + 1 < res_len) {
                                    res_start = start;
                                    res_end = end;
                                    res_len = end - start + 1;
                                }
                            }
                        }
                        start++;
                    }
                }
            }
            end++;
        }
        return res_end < res_start ? "" : s.substring(res_start, res_end + 1);
    }
}
