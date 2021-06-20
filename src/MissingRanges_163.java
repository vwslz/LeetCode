import java.util.ArrayList;
import java.util.List;

public class MissingRanges_163 {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        ArrayList<String> res = new ArrayList<String>();
        int lower_iter = lower;
        for (int num: nums) {
            if (num == lower_iter + 1) {
                res.add("" + lower_iter);
            }
            else if (num > lower_iter + 1) {
                res.add(lower_iter + "->" + (num - 1));
            }
            lower_iter = num + 1;
        }
        if (lower_iter < upper) {
            res.add(lower_iter + "->" + upper);
        }
        else if (lower_iter == upper){
            res.add("" + upper);
        }
        return res;
    }
}