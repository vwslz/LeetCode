import java.util.HashMap;

public class IsomorphicStrings_205 {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length())
            return false;
        if(s.length() == 0)
            return true;
        HashMap<Character, Character> hashS = new HashMap<Character, Character>();
        HashMap<Character, Character> hashT = new HashMap<Character, Character>();
        char[] chars_s = s.toCharArray();
        char[] chars_t = t.toCharArray();
        for(int i = 0; i < s.length(); i++){
            if(hashS.containsKey(chars_s[i])){
                if(chars_t[i] != hashS.get(chars_s[i]))
                    return false;
            }
            else{
                hashS.put(chars_s[i], chars_t[i]);
            }

            if(hashT.containsKey(chars_t[i])){
                if(chars_s[i] != hashT.get(chars_t[i]))
                    return false;
            }
            else{
                hashT.put(chars_t[i], chars_s[i]);
            }
        }
        return true;
    }
}
