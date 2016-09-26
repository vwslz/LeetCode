import java.util.Hashtable;

// O(n)
public class RomanToInteger_13 {
    public int romanToInt(String s) {
        Hashtable<Character, Integer> ht = new Hashtable<Character, Integer>();
        ht.put('I',1);
        ht.put('V',5);
        ht.put('X',10);
        ht.put('L',50);
        ht.put('C',100);
        ht.put('D',500);
        ht.put('M',1000);
        int i = s.length() - 1, res = ht.get(s.charAt(i--));
        while (i > -1) {
            if (ht.get(s.charAt(i+1)) <= ht.get(s.charAt(i)))
                res += ht.get(s.charAt(i));
            else
                res -= ht.get(s.charAt(i));
            i--;
        }
        return res;
    }
}