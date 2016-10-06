// O()
public class MaximumSubarray_53 {
    public int maxSubArray(int[] nums) {
        int res = nums[0], index = 1, sum = nums[0];
        while (index < nums.length) {
            if (sum <= 0)
                sum = nums[index];
            else
                sum += nums[index];
            if (sum > res)
                res = sum;
            index++;
        }
        return res;
    }
}
