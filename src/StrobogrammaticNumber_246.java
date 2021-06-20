public class StrobogrammaticNumber_246 {
    public boolean isStrobogrammatic(String num) {
        char[] digits = num.toCharArray();
        boolean res = true;
        for (int i = 0; i < (digits.length+1) / 2; i++) {
            if (digits[i] == '0' || digits[i] == '1' || digits[i] == '8') {
                if (digits[i] != digits[digits.length - 1 - i]){
                    res = false;
                    break;
                }
            }
            else if (digits[i] == '6') {
                if (digits[digits.length - 1 - i] != '9') {
                    res = false;
                    break;
                }
            }
            else if(digits[i] == '9') {
                if (digits[digits.length - 1 - i] != '6')  {
                    res = false;
                    break;
                }
            }
            else {
                res = false;
                break;
            }
        }
        return res;
    }
}
