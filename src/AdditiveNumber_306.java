public class AdditiveNumber_306 {
    // Consider a + b = c
    // O(n^3): O(n^2) to iterate through all possible (a, b) and O(n) to validate
    // O(n^2): Note that the sequence must be monotonically increasing since the second number
    //     1. len(a) > len(b) such that len(a) == len(c) || len(a) == len(c) - 1 which is O(2)
    //     2. len(a) <= len (b)
    //        For three consecutive numbers (a, b, c) in the sequence from the 3rd index,
    //        we have a < b < c.
    //        Therefore, len(a) <= len(b) <= len(c) which is len(b) or len(b) + 1
    //        We just need to O(2) to check b of len(c) and len(c) - 1
    //        and O(n) to validate
    //        O(n) for c, O(2) for Condition 1 and  O(2) for Condition 2 * O(n) to validate
    //        Hence, O(n^2)
    public boolean isAdditiveNumber(String num) {
        if (num.length() < 3)
            return false;

        for (int len_last = num.length() / 2; len_last > 0; len_last--){
            int i_last = num.length() - len_last;

            long last = Long.parseLong(num.substring(i_last));
            int i_middle;

            if (!(len_last > 1 && num.charAt(i_last) == '0')) {
                if (i_last < 2 * len_last && num.charAt(0) != '0') {
                    i_middle = len_last;
                    if (i_middle < i_last && num.charAt(i_middle) != '0') {
                        long first = Long.parseLong(num.substring(0, i_middle));
                        if (num.substring(i_middle, i_last).equals(Long.toString(last - first)))
                            return true;
                    }
                    // Without this part, "199111992" will be wrong, LeetCode does not have this test case
                    i_middle = len_last - 1;
                    if (i_middle > 0 && num.charAt(i_middle) != '0') {
                        long first = Long.parseLong(num.substring(0, i_middle));
                        if (num.substring(i_middle, i_last).equals(Long.toString(last - first)))
                            return true;
                    }
                }

                i_middle = i_last - len_last;
                long middle;
                if (i_middle > 0 ) {
                    middle = Long.parseLong(num.substring(i_middle, i_last));
                    if (isAdditiveNumberRecur(num, last, i_last, Long.toString(middle)))
                        return true;
                }
                i_middle = i_last - len_last + 1;
                if (i_middle < i_last) {
                    middle = Long.parseLong(num.substring(i_middle, i_last));
                    if (isAdditiveNumberRecur(num, last, i_last, Long.toString(middle)))
                        return true;
                }
            }
        }
        return false;
    }
    public boolean isAdditiveNumberRecur(String num, long last, int i_last, String expected) {
        if (i_last == 0)
            return true;

        int i_second = i_last - expected.length();
        if (i_second < 0 || !num.substring(i_second, i_last).equals(expected))
            return false;

        long second = Long.parseLong(expected);
        return isAdditiveNumberRecur(num, second, i_second, Long.toString(last - second));
    }
}
