import java.util.ArrayList;
import java.util.List;

//
public class Subsets_78 {
    public List<List<Integer>> subsets(int[] nums) {
        List res = new ArrayList();
        ArrayList<Integer> list = new ArrayList<Integer>();
        res.add(list.clone());
        subsetHelper(res, list, nums, 0);
        return res;
    }

    public void subsetHelper(List res, ArrayList<Integer> list, int[] nums, int index) {
        if (index == nums.length) {
            return;
        }
        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            res.add(list.clone());
            subsetHelper(res, list, nums, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
