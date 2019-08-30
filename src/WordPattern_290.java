import java.util.Arrays;

public class WordPattern_290 {
    public boolean wordPattern(String pattern, String str) {
        if(str.length() == 0 || pattern.length() == 0)
            return false;

        String[] words = str.split(" ");

        if (words.length != pattern.length())
            return false;

        int[] newPattern = regularizedPattern(pattern);

        int checker = 1;
        int[] checkers = new int[26];
        for (int i = 1; i < pattern.length(); i++) {
            if (newPattern[i] == checker) {
                checkers[checker] = i;
                for (int j = 0; j < checker; j++) {
                    if (words[checkers[j]].equals(words[i]))
                        return false;
                }
                checker++;
            }
            else if (!words[checkers[newPattern[i]]].equals(words[i]))
                return false;
        }
        return true;
    }

    public int[] regularizedPattern (String pattern) {
        int[] symbols = new int[26];
        Arrays.fill(symbols, -1);
        int[] res = new int[pattern.length()];

        int count = 0;
        for (int i = 0; i < pattern.length(); i++) {
            if (symbols[pattern.charAt(i) - 'a'] == -1) {
                res[i] = count;
                symbols[pattern.charAt(i) - 'a'] = count++;
            }
            else
                res[i] = symbols[pattern.charAt(i) - 'a'];
        }
        return res;
    }
}
