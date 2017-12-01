public class MinimumSizeSubarraySum_209 {
    public int minSubArrayLen(int s, int[] nums) {
        int sum = 0;
        int left = 0;
        int res = Integer.MAX_VALUE;
        for (int right = 0; right < nums.length; right++)
        {
            sum += nums[right];
            while (sum >= s)
            {
                if (right - left + 1 < res)
                    res = right - left + 1;
                sum -= nums[left++];
            }
        }
        if (res == Integer.MAX_VALUE)
            res = 0;
        return res;
    }
}
