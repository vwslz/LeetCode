// < O(log n)
public class Sqrt_x_69 {
    public int mySqrt(int x) {
        double x_d = (double)x;
        double res = (double)1;
        while (getError(x_d, res) > 1e-4) {
            res = res - (res * res - x_d) / (2 * res);
        }
        return (int)res;
    }

    public double getError(double x, double x_res) {
        if (x >= x_res * x_res)
            return x - x_res * x_res;
        else
            return x_res * x_res - x;
    }
}
