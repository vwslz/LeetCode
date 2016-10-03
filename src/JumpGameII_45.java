// O(n)
public class JumpGameII_45 {
    public int jump(int[] nums) {;
        if (nums.length <= 2)    return nums.length - 1;
        int index = 0, i_pre = 1, i_dis = nums[0], res = 1;
        while (i_dis < nums.length - 1) {
            int dis = i_dis;
            for (int i = i_pre; i <= dis; i++) {
                if (i + nums[i] >= nums.length - 1)
                    return res + 1;
                else if (i + nums[i] > i_dis) {
                    i_dis = i + nums[i];
                }
            }
            i_pre = dis + 1;
            res++;
        }
        return res;
    }
}
