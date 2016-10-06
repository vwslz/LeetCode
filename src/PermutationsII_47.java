import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// O(n!)
public class PermutationsII_47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List res = new ArrayList();
        if (nums.length == 0)
            return res;
        ArrayList<Integer> new_list = new ArrayList<Integer>();
        boolean[] used = new boolean[nums.length];
        Arrays.fill(used, false);
        permuteUnique_helper(nums, res, new_list, used, 0);
        return res;
    }

    public void permuteUnique_helper(int[] nums, List res, ArrayList<Integer> new_list, boolean[] used, int index) {
        if (index >= nums.length) {
            res.add(new_list.clone());
        }
        else {
            int pre = nums[0] - 1;
            for (int i = 0; i < nums.length; i++) {
                if (!used[i] && nums[i] != pre) {
                    pre = nums[i];
                    new_list.add(nums[i]);
                    used[i] = true;
                    permuteUnique_helper(nums, res, new_list, used, index + 1);
                    new_list.remove(index);
                    used[i] = false;
                }
            }
        }
    }
}
