import java.util.ArrayList;
import java.util.List;

//
public class Combinations_77 {
    public List<List<Integer>> combine(int n, int k) {
        int[] arr = new int[k];
        ArrayList<Integer> nums = new ArrayList<>();
        List res = new ArrayList();
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }
        combineHelper(nums, arr, res, k, 0);
        return res;
    }

    public void combineHelper(ArrayList<Integer> nums, int[] arr, List res, int k, int index) {
        if (index == k) {
            res.add(arr.clone());
        }
        else {
            ArrayList<Integer> deleted = new ArrayList<Integer>();
            while (nums.size() > 0) {
                arr[index] = nums.remove(0);
                deleted.add(arr[index]);
                combineHelper(nums, arr, res, k, index + 1);
            }
            nums.addAll(deleted);
        }
    }
}
