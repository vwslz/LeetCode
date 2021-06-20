public class ShortestWordDistance_243 {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int res = wordsDict.length;
        int i1 = -1;
        int i2 = -1;
        for (int i = 0; i < wordsDict.length; i++) {
            // System.out.println(i + ", " + i1 + ", " + i2);
            if (wordsDict[i].equals(word1)) {
                if (i2 >= 0 && res > i - i2) {
                    res = i - i2;
                }
                i1 = i;
            }
            else if (wordsDict[i].equals(word2)) {
                if (i1 >= 0 && res > i - i1) {
                    res = i - i1;
                }
                i2 = i;
            }
        }
        return res;
    }
}
