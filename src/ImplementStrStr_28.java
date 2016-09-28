// o(n + k)
public class ImplementStrStr_28 {
    public int strStr(String haystack, String needle) {
        if(needle.length() == 0) return 0;

        int[] next = buildTable(needle);
        int i = 0, j = 0;

        while (i < haystack.length() && haystack.length() - i >= needle.length() - j){
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            }
            else if (j == 0)
                i++;
            else {
                j = next[j - 1];
            }
            if(j == needle.length()) return i - j;
        }
        return -1;
    }

    private int[] buildTable(String s){
        int[] next = new int[s.length()];
        next[0] = 0;
        for (int i = 1; i + 1 < s.length(); i++){
            if (s.charAt(i) == s.charAt(next[i-1])){
                next[i] = next[i-1] + 1;
            }
            else if (s.charAt(i) == s.charAt(0))
                next[i] = next[0] + 1;
            else next[i] = next[0];
        }
        return next;
    }
}
