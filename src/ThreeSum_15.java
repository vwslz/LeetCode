import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// O((n+1)n/2) = O(n^2)
public class ThreeSum_15 {
    public List<List<Integer>> threeSum(int[] nums) {
        ArrayList res = new ArrayList();
        if (nums.length < 3) return res;
        Arrays.sort(nums);
        if (nums[0] > 0 || nums[nums.length - 1] < 0 || nums[0] + nums[1] + nums[2] > 0 || nums[nums.length - 3] + nums[nums.length - 2] + nums[nums.length - 1] < 0)
            return res;

        int target, left, right, i = 0;
        while (i < nums.length - 2) {
            target = 0 - nums[i];
            left = i + 1;
            right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] == target) {
                    res.add(new int[]{nums[i], nums[left], nums[right]});
                    left = nextRight(nums, left);
                    right = nextLeft(nums, right);
                } else if (nums[left] + nums[right] > target) {
                    right--;
                } else {
                    left++;
                }
            }
            i = nextRight(nums, i);
        }
        return res;
    }

    public int nextLeft(int[] nums, int index) {
        int res = index - 1;
        while (res > -1 && nums[res] == nums[index]) {
            res--;
        }
        return res;
    }

    public int nextRight(int[] nums, int index) {
        int res = index + 1;
        while (res < nums.length && nums[res] == nums[index]) {
            res++;
        }
        return res;
    }
}