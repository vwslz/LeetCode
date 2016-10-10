import java.util.Hashtable;

// O()
public class MinimumWindowSubstring_76 {
    public String minWindow(String s, String t) {
        Hashtable<Character, Integer> ht_chars = new Hashtable<Character, Integer>();
        int i;
        for (i = 0; i < t.length(); i++)
            ht_chars.put(t.charAt(i), ht_chars.getOrDefault(t.charAt(i), 0) - 1);
        for (i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (ht_chars.containsKey(c))
                ht_chars.put(c, ht_chars.get(c) + 1);
        }
        int left = s.length(), right = -1;
        for (Character c: ht_chars.keySet()) {
            if (ht_chars.get(c) < 0)
                return "";
        }
        // TODO
        return "";
    }
}
