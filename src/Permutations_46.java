import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// O(n!)
public class Permutations_46 {
    public List<List<Integer>> permute(int[] nums) {
        List list = new ArrayList();
        if (nums.length == 0)
            return list;
        permute_helper(nums, list, 0);
        return list;
    }

    public void permute_helper(int[] nums, List list, int index) {
        for (int i = index; i < nums.length - 1; i++) {
            permute_helper(nums, list, i);
        }
        swap(nums, index, nums[nums.length - 1]);
        list.add(Arrays.asList(nums));
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
