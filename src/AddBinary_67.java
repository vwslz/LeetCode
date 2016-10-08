import java.util.Arrays;

// O(n)
public class AddBinary_67 {
    public String addBinary(String a, String b) {
        boolean carry = false;
        if (a.length() < b.length()) {
            char[] chars = new char[b.length() - a.length()];
            Arrays.fill(chars, '0');
            String mask = new String(chars);
            a = mask + a;
        } else {
            char[] chars = new char[a.length() - b.length()];
            Arrays.fill(chars, '0');
            String mask = new String(chars);
            b = mask + b;
        }

        char[] ca = a.toCharArray();
        char[] cb = b.toCharArray();
        char[] arr = new char[ca.length];
        for (int i = ca.length - 1; i >= 0; i--) {
            int sum = ca[i] - '0' + cb[i] - '0';
            if (carry == true) {
                sum += 1;
                carry = false;
            }
            if (sum > 1) {
                sum -= 2;
                carry = true;
            }
            arr[i] = (char) (sum + '0');
        }

        String res = "";
        if (carry == true)
            res += "1";
        res += String.valueOf(arr);
        return res;
    }
}
