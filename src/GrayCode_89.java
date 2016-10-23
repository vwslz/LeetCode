import java.util.ArrayList;
import java.util.List;

// O(n)
public class GrayCode_89 {
    public List<Integer> grayCode(int n) {
        int len = (int)Math.pow(2 , n);
        int[] res = new int[len];
        res[0] = 0;
        int diff = 1;
        while (diff * 2 <= len) {
            for(int i = diff; i < diff * 2; i++) {
                res[i] = res[diff * 2 - 1 - i] + diff;
            }
            diff *= 2;
        }

        List<Integer> list = new ArrayList<Integer>();
        for (int j = 0; j < len; j++) {
            list.add(res[j]);
        }

        return list;
    }
}
