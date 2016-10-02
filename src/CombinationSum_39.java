import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// O(...)
public class CombinationSum_39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List res = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        combinationSumHelper(candidates, target, 0, res, list);
        return res;
    }

    public void combinationSumHelper(int[] candidates, int target, int index, List res, ArrayList<Integer> list) {
        ArrayList<Integer> pre;
        for (int i = index; i < candidates.length; i++) {
            pre = (ArrayList<Integer>)list.clone();
            if (target - candidates[i] < 0) {
                if (pre.size() > 0) list.remove(pre.size() - 1);
                break;
            }
            else {
                pre.add(candidates[i]);
                if (target - candidates[i] == 0) {
                    res.add(pre.clone());
                    break;
                }
                else {
                    combinationSumHelper(candidates, target - candidates[i], i, res, pre);
                }
            }

        }
    }
}
