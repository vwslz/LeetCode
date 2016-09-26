import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// O(n^3)
public class FourSum_18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        ArrayList res = new ArrayList<>();
        if (nums.length < 4)
            return res;
        Arrays.sort(nums);
        int first = 0;
        while (first < nums.length - 3) {
            if (nums[first] * 4 > target)
                break;
            else if (nums[first] + 3 * nums[nums.length-1] >= target)
                threeSum(res, nums, target - nums[first],first);
            first = nextRight(nums, first);
        }
        return res;
    }

    public void threeSum(ArrayList res, int[] nums, int target, int  first) {
        int second = first + 1;
        while (second < nums.length - 2) {
            if (nums[second] * 3 > target)
                return;
            else if (nums[second] + 2 * nums[nums.length-1] >= target)
                twoSum(res, nums, target - nums[second], first, second);
            second= nextRight(nums, second);
        }
    }

    public void twoSum(ArrayList res, int[] nums, int target, int first, int second) {
        int third = second + 1;
        int fourth = nums.length - 1;
        while (third < fourth) {
            if (nums[third] * 2 > target)
                return;
            else if (nums[fourth] * 2 < target)
                return;
            else {
                if (nums[third] + nums[fourth] == target) {
                    res.add(new int[]{nums[first], nums[second], nums[third], nums[fourth]});
                    third = nextRight(nums, third);
                    fourth = nextLeft(nums, fourth);
                }
                else if (nums[third] + nums[fourth] < target)
                    third = nextRight(nums, third);
                else
                    fourth = nextLeft(nums, fourth);
            }
        }
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
