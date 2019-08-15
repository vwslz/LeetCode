// faster than 97.07%
public class PerfectSquares_279 {
    public int numSquares(int n) {
        int[] map = new int[n + 1];
        return numSquaresHelper(n, map);
    }

    public int numSquaresHelper(int n, int[] map) {
        if (n < 4)
            return n;

        if (map[n] != 0)
            return map[n];

        int root = (int)Math.sqrt(n);
        int res = Integer.MAX_VALUE;
        for (int i = root; i >= 1; i--) {
            int num = n / (i * i);
            int remain = numSquaresHelper(n - num * i * i, map);
            if (remain + num < res)
                res = remain + num;
        }

        map[n] = res;
        return res;
    }
}