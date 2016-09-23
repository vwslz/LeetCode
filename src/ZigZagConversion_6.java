// O(n)

public class ZigZagConversion_6 {
    public String convert(String s, int numRows) {
        if (s == "" || s.length() <= numRows || numRows == 1 ) return s;
        int cir_row = 2 * numRows - 2;
        int col_1 = s.length() / cir_row;
        if (s.length() % cir_row > 0) {
            col_1++;
        }

        char[] res = new char[s.length()];
        int i = 0;
        int p_row = 1, p_left = 1, p_right = cir_row - p_left, p_end = numRows - 1;
        while (i < s.length()) {
            if (i * cir_row < s.length())   res[i] = s.charAt(i++ * cir_row);
            else if( p_row < numRows - 1) {
                if (p_left < s.length()) {
                    res[i++] = s.charAt(p_left);
                    p_left += cir_row;
                    if(p_right < s.length()) {
                        res[i++] = s.charAt(p_right);
                        p_right += cir_row;
                    }
                    else {
                        p_row++;
                        p_left = p_row;
                        p_right = cir_row - p_left;
                    }
                }
                else {
                    p_row++;
                    p_left = p_row;
                    p_right = cir_row - p_left;
                }
            }
            else {
                res[i++] = s.charAt(p_end);
                p_end += cir_row;
            }
        }

        return String.valueOf(res);
    }
}
