// O(n)
public class ValidNumber_65 {
    public boolean isNumber(String s) {
        if (s == null || s.length() == 0)
            return false;

        s = s.trim();
        boolean dotExisted = false, eExisted = false, checkNeg = false;
        int index = 0, numCount = 0;

        while (index < s.length()) {
            if (s.charAt(index) == '-' || s.charAt(index) == '+') {
                if (!(index == 0 || s.charAt(index - 1) == 'e'))
                    return false;
            } else if (s.charAt(index) >= '0' && s.charAt(index) <= '9') {
                numCount++;
            } else if (s.charAt(index) == '.') {
                if (dotExisted)
                    return false;
                dotExisted = true;
            } else if (s.charAt(index) == 'e') {
                if (eExisted || numCount == 0)
                    return false;
                else {
                    eExisted = true;
                    dotExisted = true;
                    numCount = 0;
                }
            } else
                return false;
            index++;
        }
        return numCount == 0 ? false : true;
    }
}
