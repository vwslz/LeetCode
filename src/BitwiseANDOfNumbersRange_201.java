public class BitwiseANDOfNumbersRange_201 {
    public int rangeBitwiseAnd(int m, int n) {
        int count = 0;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            count++;
            if (m == 0) return 0;
        }
        m <<= count;
        return m;
    }
}
