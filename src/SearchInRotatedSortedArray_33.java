// O(log n)
public class SearchInRotatedSortedArray_33 {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (nums[left] == target)   return left;
            if (nums[right] == target)  return right;
            if (nums[middle] == target) return middle;
            if (nums[middle] > target) {
                if (nums[left] > target && nums[middle] > nums[left])  left = middle + 1;
                else    right = middle - 1;
            }
            else {
                if (nums[right] < target && nums[middle] < nums[right])   right = middle - 1;
                else    left = middle + 1;
            }
        }
        return -1;
    }
}
