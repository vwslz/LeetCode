// O(log n)
public class SearchForARange_34 {
    public int[] searchRange(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int findLeft = binarySearch(nums, left, right, target), findRight = findLeft;
        while (findLeft > 0 && nums[findLeft - 1] == target) {
            right = findLeft - 1;
            findLeft = binarySearch(nums, left, right, target);
        }
        left = 0;
        right = nums.length - 1;
        while (findRight > -1 && findRight < nums.length - 1 && nums[findRight + 1] == target) {
            left = findRight + 1;
            findRight = binarySearch(nums, left, right, target);
        }
        return new int[]{findLeft, findRight};
    }

    public int binarySearch(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] == target) return middle;
            if (nums[middle] > target)  right = middle - 1;
            else    left = middle + 1;
        }
        return -1;
    }
}

