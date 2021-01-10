import java.util.Arrays;

public class LongestIncreasingSubsequence_300 {
    // O(n^2) using dp, can be optimized to O(n log n) using binary search
    public int lengthOfLIS(int[] nums) {
        int[] lens = new int[nums.length];

        int res = 0;

        for(int i = 0; i < nums.length; i++) {
            int n = nums[i];
            int j = Arrays.binarySearch(lens, 0, res, n);

            // not in original array
            if (j < 0) {
                j = -(j + 1);
            }

            if (n < lens[j])
                lens[j] = n;
            if (j == res) {
                lens[j] = n;
                res++;
            }
        }
        return res;
    }
}
