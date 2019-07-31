import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII_216 {
    List res = new ArrayList();

    public List<List<Integer>> combinationSum3(int k, int n) {
        ArrayList<Integer> iter = new ArrayList<Integer>();
        combinationSum3dp(iter, 1, k, n);
        return res;
    }

    public void combinationSum3dp(ArrayList<Integer> iter, int cur, int num, int sum) {

        if (sum >= cur) {
            if (num == 1) {
                if (sum <= 9) {
                    iter.add(sum);
                    res.add(iter.clone());
                    iter.remove(iter.size() - 1);
                }
            } else if (num > 1) {
                for (int i = cur; i <= Math.min(sum, 9); i++) {
                    iter.add(i);
                    combinationSum3dp(iter, i + 1, num - 1, sum - i);
                    iter.remove(iter.size() - 1);
                }
            } else
                System.out.println("error here at current number " + cur + " and remain " + sum + " and remaining number " + num);
        }
    }
}
