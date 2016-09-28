// (log n)
public class DivideTwoIntegers_29 {
    public int divide(int dividend, int divisor) {
        long l_dve = dividend;
        long l_dvs = divisor;

        if (divisor == 0) return Integer.MAX_VALUE;
        if (dividend == 0 || divisor == 1) return dividend;
        if (divisor == -1) return dividend == Integer.MIN_VALUE ? Integer.MAX_VALUE : -dividend;
        boolean isNeg = false;
        if ((l_dve < 0 && l_dvs > 0) || (l_dve > 0 && l_dvs < 0))
            isNeg = true;
        if (l_dve < 0)
            l_dve = -l_dve;
        if (l_dvs < 0)
            l_dvs = -l_dvs;

        int res = divide_helper(l_dve, l_dvs);
        return isNeg ? -res : res;
    }

    public int divide_helper(long dve, long dvs) {
        int c_mul = 1, res = 0;
        long mul = dvs;
        while (dve > mul * 2) {
            mul *= 2;
            c_mul *= 2;
        }
        while (dve >= dvs && c_mul > 0) {
            while (dve >= mul) {
                dve -= mul;
                res += c_mul;
            }
            mul /= 2;
            c_mul /= 2;
        }
        return res;
    }
}
