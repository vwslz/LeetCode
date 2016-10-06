import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// O(n!)
public class Permutations_46 {
    public List<List<Integer>> permute(int[] nums) {
        List list = new ArrayList();
        if (nums.length == 0)
            return list;
        ArrayList<Integer> new_list = new ArrayList<Integer>();
        boolean[] used = new boolean[nums.length];
        Arrays.fill(used, false);
        permute_helper(nums, list, new_list, used, 0);
        return list;
    }

    public void permute_helper(int[] nums, List list, ArrayList<Integer> new_list, boolean[] used, int index) {
        if (index >= nums.length) {
            list.add(new_list.clone());
        }
        else {
            for (int i = 0; i < nums.length; i++) {
                if (!used[i]) {
                    new_list.add(nums[i]);
                    used[i] = true;
                    permute_helper(nums, list, new_list, used, index + 1);
                    new_list.remove(index);
                    used[i] = false;
                }
            }
        }
    }
}
