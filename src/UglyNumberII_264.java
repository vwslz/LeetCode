import java.util.ArrayList;
import java.util.List;

// dp
public class UglyNumberII_264 {
    public int nthUglyNumber(int n) {
        int[] res = new int[n];
        res[0] = 1;
        int i2 = 0, i3 = 0, i5 = 0;
        int index = 1;
        while (index < n) {
            int val = Math.min(Math.min(res[i2] * 2, res[i3] * 3), res[i5] * 5);
            if (val == res[i2] * 2)
                i2++;
            if (val == res[i3] * 3)
                i3++;
            if (val == res[i5] * 5)
                i5++;
            res[index++] = val;
        }
        return res[n - 1];
    }
}
