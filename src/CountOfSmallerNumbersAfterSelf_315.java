import java.util.Arrays;
import java.util.List;

// O(n log n)
public class CountOfSmallerNumbersAfterSelf_315 {

    int lenTree = 20050;
    int[] tree = new int[lenTree];
    public List<Integer> countSmaller(int[] nums) {
        int smallestPossible = -10000;
        Integer[] res = new Integer[nums.length];

        for (int i = nums.length - 1; i >= 0; i--){
            res[i] = getCumulativeFrequency(nums[i]-smallestPossible);
            updateCumulativeFrequency(nums[i]+1-smallestPossible);
        }

        return Arrays.asList(res);
    }

    private int getCumulativeFrequency(int idx) {
        int res = 0;
        while (idx > 0) {
            res += tree[idx];
            idx -= (idx & -idx);
        }
        return res;
    }

    private void updateCumulativeFrequency(int idx) {
        while (idx <= lenTree) {
            tree[idx]++;
            idx += (idx & -idx);
        }
    }
}
