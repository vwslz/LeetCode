public class UglyNumber_263 {
    int[] divs = new int[]{30, 15,10, 6, 5, 3, 2};
    public boolean isUgly(int num) {
        if (num == 0)
            return false;
        if (num == 1 )
            return true;

        for (int div: divs) {
            int val = num / div;
            int rem = num - val * div;
            if (rem == 0)
                return isUgly(val);
        }
        return false;
    }
}
