public class HouseRobberII_213 {
    public int rob(int[] nums) {
        if (nums.length == 0)
            return 0;
        else if (nums.length == 1)
            return nums[0];
        return Math.max(robHelper(nums, 0, nums.length - 2), robHelper(nums, 1, nums.length - 1));
    }
    public int robHelper(int[] nums, int begin, int end) {
        int res1 = 0, res2 = 0;
        for (int i = begin; i <= end; i++) {
            int res1Pre = res1, res2Pre = res2;
            res1 = res2Pre + nums[i];
            res2 = Math.max(res1Pre, res2Pre);
        }
        return Math.max(res1, res2);
    }
}
