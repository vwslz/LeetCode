import java.util.HashMap;

public class ValidAnagram_242 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        // 26 alphabets
        // 256 chars
        int[] chars = new int[256];
        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i)]++;
            chars[t.charAt(i)]--;
        }
        for (int i = 0; i < chars.length; ++i) {
            if (chars[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
