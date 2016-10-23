import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//
public class SubsetsII_90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List res = new ArrayList();
        ArrayList<Integer> list = new ArrayList<Integer>();
        res.add(list);
        subsetsHelper(res, list, nums, 0);
        return res;
    }

    public void subsetsHelper(List res, ArrayList<Integer> list, int[] nums, int n) {
        if (n == nums.length)
            return;
        int index = n;
        while (index < nums.length) {
            list.add(nums[index]);
            res.add(new ArrayList<Integer>(list));
            subsetsHelper(res, list, nums, index + 1);
            list.remove(list.size() - 1);
            index = nextNumIndex(nums, index);
        }
    }

    public int nextNumIndex(int[] nums, int index) {
        while (index + 1 < nums.length && nums[index] == nums[index + 1]) {
            index++;
        }
        return index + 1;
    }
}
