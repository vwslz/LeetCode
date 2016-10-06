import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;

// O(n)
public class GroupAnagrams_49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        int index = 0;
        Hashtable<String, Integer> ht = new Hashtable<String, Integer>();
        List groups = new ArrayList<ArrayList<String>>();

        for(String str: strs) {
            String key = createKey(str);
            if (ht.containsKey(key)) {
                ArrayList new_list = (ArrayList) (groups.get(ht.get(key)));
                new_list.add(str);
                groups.set(ht.get(key), new_list);
            }
            else {
                List<String> group = new ArrayList<String>();
                group.add(str);
                groups.add(group);
                ht.put(key, index++);
            }
        }

        return groups;
    }

    public String createKey(String s) {
        char[] chars = new char[26];
        Arrays.fill(chars, '0');
        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i) - 'a']++;
        }
        char[] res = new char[52];
        for (int j = 0; j < 26; j++) {
            res[j * 2] = (char)('a' + j);
            res[j * 2 + 1] = chars[j];
        }
        return String.valueOf(res);
    }
}
