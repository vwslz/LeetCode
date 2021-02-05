import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class BurstBalloons_312 {
    public int maxCoins(int[] nums) {
        // O(n^3) using dp
        if (nums == null || nums.length == 0)
            return 0;

        int index = 0;
        for (int num : nums) {
            if (num > 0)
                nums[index++] = num;
        }

        int[][] res = new int[index][index];

        for (int len = 1; len <= index; len++){
            for (int left = 0, right = left + len - 1; right < index; left++, right++) {
                for (int cur = left; cur <= right; cur++) {
                    res[left][right] = Math.max(
                        res[left][right],
                        (cur > 0 ? res[left][cur-1] : 0)
                            + (left > 0 ? nums[left-1] : 1)
                                *nums[cur]
                                *(right < index - 1 ? nums[right+1] : 1)
                            + (cur < index - 1 ? res[cur+1][right] : 0)
                    );
                }
            }
        }
        return res[0][index-1];
    }
}
