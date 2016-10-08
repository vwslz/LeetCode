// O(n)
public class PlusOne_66 {
    public int[] plusOne(int[] digits) {

        boolean carry = false;
        if (digits[digits.length - 1] + 1 > 9)
            carry = true;
        else {
            digits[digits.length - 1] += 1;
            return digits;
        }

        int index = digits.length - 1;
        while (carry && index >= 0) {
            int digit = digits[index] + 1;
            if (digit > 9)
                digit -= 10;
            else
                carry = false;
            digits[index] = digit;
            index--;
        }

        if (carry) {
            int[] arr = new int[digits.length + 1];
            arr[0] = 1;
            for (int i = 0; i < digits.length; i++)
                arr[i + 1] = digits[i];
            return arr;
        }
        else
            return digits;
    }
}
