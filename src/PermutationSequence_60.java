import java.util.ArrayList;
import java.util.List;

// O(n)
public class PermutationSequence_60 {
    public String getPermutation(int n, int k) {
        List<Integer> list = new ArrayList<>();
        int fac = 1;
        for (int i = 1; i <= n; i++) {
            list.add(i);
            fac *= i;
        }
        char[] res = new char[n];
        int iter = n;
        for (int i = 0; i < n; i++) {
            fac /= iter--;
            int index = ((k - 1) / fac) % (n - i);
            res[i] = (char)('0' + list.remove(index));
        }
        return String.valueOf(res);
    }
}
