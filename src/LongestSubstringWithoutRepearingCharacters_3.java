import java.util.Arrays;

// O(n)

public class LongestSubstringWithoutRepearingCharacters_3 {
    public int lengthOfLongestSubstring(String s) {
        int[] i_chars = new int[256];
        Arrays.fill(i_chars, -1);
        char[] char_s = s.toCharArray();
        int res = 0, begin = 0;
        for (int i = 0; i < char_s.length; i++) {
            if (i_chars[char_s[i]] != -1) if (begin < i_chars[char_s[i]] + 1) begin = i_chars[char_s[i]] + 1;
            if (i - begin + 1 > res) res = i - begin + 1;
            i_chars[char_s[i]] = i;
        }
        return res;
    }
}
