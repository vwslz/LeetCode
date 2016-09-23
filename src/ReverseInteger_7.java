// O(n)

public class ReverseInteger_7 {
    public int reverse(int x) {
        long res = 0;
        int sign = (x > 0) ? 1 : -1;
        x = (x > 0) ? x : -x;
        while (x > 0) {
            res = res * 10 + x % 10;
            if (res > Integer.MAX_VALUE)    return 0;
            x /= 10;
        }
        return (int)(sign * res);
    }
}
