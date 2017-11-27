import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RepeatedDNASequences_187 {
    public List<String> findRepeatedDnaSequences(String s) {
        char[] chars_s = s.toCharArray();
        char[] pattern = new char[10];
        List<String> res = new ArrayList<String>();
        HashMap<String, Integer> map = new HashMap<String, Integer>();

        for (int i = 0; i < s.length()-9; i++) {
            loadPattern(chars_s, pattern, i);
            String p = String.valueOf(pattern);
            if (map.containsKey(p)) map.put(p, map.get(p)+1);
            else    map.put(p, 1);
        }
        for (String ptn: map.keySet()) {
            if (map.get(ptn) > 1)   res.add(ptn);
        }
        return res;
    }

    public void loadPattern(char[] chars, char[] pattern, int index) {
        for (int i = 0; i < 10;  i++) {
            pattern[i] = chars[index+i];
        }
    }
}
