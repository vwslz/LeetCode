// O(n)
public class JumpGame_55 {
    public boolean canJump(int[] nums) {
        int end = nums[0];
        int index = 0;
        while (index <= end) {
            if (end >= nums.length - 1)
                return true;
            if (nums[index] + index > end)
                end = nums[index] + index;
            index++;
        }
        return false;
    }
}
