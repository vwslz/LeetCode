// O(log n)
public class SearchInsertPosition_35 {
    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0)   return 0;
        if (target <= nums[0])  return 0;
        if (target > nums[nums.length - 1])return nums.length;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] == target) return middle;
            if (nums[middle] > target)  right = middle - 1;
            else    left = middle + 1;
        }
        return target < nums[left] ? left : left + 1;
    }
}
