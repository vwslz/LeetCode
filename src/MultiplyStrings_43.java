// O(n)
public class MultiplyStrings_43 {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0"))
            return "0";
        int[] i_num1 = (num1.length() >= num2.length() ? toIntegers(num1) : toIntegers(num2));
        int[] i_num2 = (num1.length() >= num2.length() ? toIntegers(num2) : toIntegers(num1));

        int over = 0;
        String res = "";

        for (int i = 0; i < i_num1.length + i_num2.length; i++) {
            int digit = 0;
            if (i < i_num2.length) {
                for (int i_digit = 0; i_digit <= i; i_digit++) {
                    digit += i_num1[i - i_digit] * i_num2[i_digit];
                }
            } else if (i >= i_num1.length) {
                for (int i_digit = 0; i_digit < i_num1.length + i_num2.length - 1 - i; i_digit++) {
                    digit += i_num1[i_num1.length - 1 - i_digit] * i_num2[i - i_num1.length + 1 + i_digit];
                }
            } else {
                for (int i_digit = 0; i_digit < i_num2.length; i_digit++) {
                    digit += i_num1[i - i_digit] * i_num2[i_digit];
                }
            }
            digit += over;
            over = digit / 10;
            digit %= 10;
            if (i == i_num1.length + i_num2.length - 1) {
                if (over == 0 && digit == 0)
                    break;
            }
            res = digit + res;
            if (i == i_num1.length + i_num2.length - 1) {
                if (over != 0)
                    res = over + res;
            }
        }
        return res;
    }

    public int[] toIntegers(String s) {
        int[] res = new int[s.length()];
        for (int i_s = 0; i_s < s.length(); i_s++) {
            res[s.length() - 1 - i_s] = s.charAt(i_s) - '0';
        }
        return res;
    }
}
