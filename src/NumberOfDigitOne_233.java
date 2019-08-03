public class NumberOfDigitOne_233 {
    public int countDigitOne(int n) {
        int res = 0;
        int base = 1;
        int level = 0;
        while (n >= base) {
            int digit = n / base % 10;

            if (digit >= 1) {
                res += digit * level * (base / 10);
                if (digit == 1)
                    res += n % base + 1;
                else
                    res += base;
            }
            if (n / base < 10)
                break;

            base*= 10;
            level++;
        }
        return res;
    }
}
