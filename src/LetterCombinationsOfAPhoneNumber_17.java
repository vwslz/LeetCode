import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// O(n^2)
public class LetterCombinationsOfAPhoneNumber_17 {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<String>();

        HashMap<Integer, char[]> hmap = new HashMap<Integer, char[]>();
        ArrayList<char[]> comb = new ArrayList<char[]>();
        hmap.put(2, new char[]{'a', 'b', 'c'});
        hmap.put(3, new char[]{'d', 'e', 'f'});
        hmap.put(4, new char[]{'g', 'h', 'i'});
        hmap.put(5, new char[]{'j', 'k', 'l'});
        hmap.put(6, new char[]{'m', 'n', 'o'});
        hmap.put(7, new char[]{'p', 'q', 'r', 's'});
        hmap.put(8, new char[]{'t', 'u', 'v'});
        hmap.put(9, new char[]{'w', 'x', 'y', 'z'});

        for (int i = 0; i < digits.length(); i++) {
            if (digits.charAt(i) - '0' > 1)
                comb.add(hmap.get(digits.charAt(i) - '0'));
        }
        if (comb.size() == 0)
            return res;

        char[] temp = new char[comb.size()];
        combine(res, comb, temp, 0);
        return res;
    }

    public void combine(List<String> res, List<char[]> combs, char[] comb, int index){
        if (index >= combs.size()) {
            res.add(String.valueOf(comb));
        }
        else {
            for (int i = 0; i < combs.get(index).length; i++) {
                comb[index] = combs.get(index)[i];
                combine(res, combs, comb, index + 1);
            }
        }
    }
}
