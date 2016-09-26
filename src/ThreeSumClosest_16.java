import java.util.Arrays;

// O(n^2)
public class ThreeSumClosest_16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        if (nums[0] > target / 3 || nums[0] + nums[1] + nums[2] > target)
            return nums[0] + nums[1] + nums[2];
        if (nums[nums.length - 1] < target / 3 || nums[nums.length - 1] + nums[nums.length - 2] + nums[nums.length - 3] < target)
            return nums[nums.length - 1] + nums[nums.length - 2] + nums[nums.length - 3];
        int first = 0, second, third, res = target, diff = Integer.MAX_VALUE;
        while (first < nums.length - 2) {
            second = first + 1;
            third = nums.length - 1;
            while (second < third) {
                int sum = nums[first] + nums[second] + nums[third];
                if (sum == target) {
                    return target;
                }
                else if (sum > target) {
                    if (sum - target < diff) {
                        res = sum;
                        diff = sum - target;
                    }
                    third = nextLeft(nums, third);
                } else {
                    if (target - sum < diff) {
                        res = sum;
                        diff= target - sum;
                    }
                    second = nextRight(nums, second);
                }
            }
            first = nextRight(nums, first);
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
