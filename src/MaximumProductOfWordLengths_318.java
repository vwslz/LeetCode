public class MaximumProductOfWordLengths_318 {
    // O(n^2) with Bit Mask
    public int maxProduct(String[] words) {
        int[] wordsInt = new int[words.length];
        for (int i = 0; i < words.length; i++)
            wordsInt[i] = strToInt(words[i]);

        int res = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if ((wordsInt[i] & wordsInt[j]) == 0) {
                    res = Math.max(res, words[i].length() * words[j].length());
                }
            }

        }
        return res;
    }

    public int strToInt(String input) {
        int res = 0;
        for (char c: input.toCharArray()) {
            res |= 1 << c - 'a';
        }
        return res;
    }
}
