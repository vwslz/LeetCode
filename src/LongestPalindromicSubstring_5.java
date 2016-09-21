public class LongestPalindromicSubstring_5 {
    // O(n), Manacher's algorithm with inspriation from https://discuss.leetcode.com/topic/58568/java-o-n-solution
    public String longestPalindrome(String s) {
        if (s == null)  return "";
        char[] chars_s = addBoundary(s.toCharArray());

        int[] arr = new int[chars_s.length];
        int ctr = 0, r = 0, i;

        for (i = 1; i < chars_s.length - 1; i++) {
            if (i < r) arr[i] = (r - i < arr[ctr * 2 - i]) ? r - i : arr[ctr * 2 - i];

            while(chars_s[i + (1 + arr[i])] == chars_s[i - (1 + arr[i])]) {
                arr[i]++;
            }
            if (i + arr[i] > r) {
                ctr = i;
                r = i + arr[i];
            }
        }

        int max = 0, res_ctr = 0;;
        for (i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
                res_ctr = i;
            }
        }

        return getTargetString(chars_s, max, res_ctr);
    }

    public char[] addBoundary(char[] s) {
        char[] chars_s = new char[s.length * 2 + 3];
        chars_s[0] = '#';
        chars_s[chars_s.length - 1] = '$';
        for (int i = 0; i < s.length; i++) {
            chars_s[i * 2 + 1] = '|';
            chars_s[i * 2 + 2] = s[i];
        }
        chars_s[chars_s.length - 2] = '|';
        return chars_s;
    }

    public String getTargetString(char[] s, int len, int ctr) {
        char[] res = new char[len];
        int j = 0;
        for(int i = ctr - len + 1; i < ctr + len; i = i + 2) {
            res[j++] = s[i];
        }
        return new String(res);
    }
}
