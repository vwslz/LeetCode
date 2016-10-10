// O(n)
public class SortColors_75 {
    public void sortColors(int[] nums) {
        int left = 0, right = nums.length - 1, leftIndex = 0;
        while (left <= right) {
            if (nums[left] == 0) {
                nums[left++] = nums[leftIndex];
                nums[leftIndex++] = 0;
            }
            else if (nums[left] == 1) {
                left++;
            }
            else if (nums[left] == 2) {
                nums[left] = nums[right];
                nums[right--] = 2;
            }
        }
    }
}