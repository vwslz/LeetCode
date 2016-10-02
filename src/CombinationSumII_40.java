import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// O(...)
public class CombinationSumII_40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List res = new ArrayList<>();
        Arrays.sort(candidates);
        ArrayList<Integer> list = new ArrayList<Integer>();
        combinationSum2Helper(candidates, target, 0, res, list);
        return res;
    }

    public void combinationSum2Helper(int[] candidates, int target, int index, List res, ArrayList<Integer> list) {
        int i = index;
        while (i < candidates.length) {
            if (target - candidates[i] < 0) {
                break;
            }
            else {
                list.add(candidates[i]);
                if (target - candidates[i] == 0) {
                    res.add(list.clone());
                }
                else {
                    combinationSum2Helper(candidates, target - candidates[i], i + 1, res, list);
                }
                list.remove(list.size() - 1);
            }
            i = next(candidates, i+1);
        }
    }
    public int next(int[] candidates, int i) {
        while(i < candidates.length && candidates[i] == candidates[i - 1])
            i++;
        return i;
    }
}
