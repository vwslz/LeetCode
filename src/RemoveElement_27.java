// O(n)
public class RemoveElement_27 {
    public int removeElement(int[] nums, int val) {
        int left = 0, right = nums.length;
        while  (left < right) {
            if (nums[left] == val) {
                nums[left] = nums[--right];
            }
            else
                left++;
        }
        return left;
    }
}
