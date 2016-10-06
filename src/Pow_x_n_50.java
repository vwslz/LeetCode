// O(log n)
public class Pow_x_n_50 {
    public double myPow(double x, double n) {
        if (x == 0 || x == 1 || n == 1)   return x;
        if (n == 0) return 1;
        double remain = 1;
        double res = x;
        boolean isPos = n > 0 ? true : false;
        if (!isPos) n = -n;
        while (n > 1) {
            if ( n/2 > (int)(n / 2)) {
                remain *= res;
                if (n < 0)
                    isPos = !isPos;
            }
            res *= res;
            n = (int)(n / 2);
        }
        res *= remain;
        return isPos ? res : 1 / res;
    }
}
