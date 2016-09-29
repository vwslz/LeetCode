// O(n)
public class NextPermutation_31 {
    public void nextPermutation(int[] nums) {
        int left = nums.length - 1, right = left;
        while (left > 0) {
            if (nums[left] > nums[left - 1])  break;
            left--;
        }
        if (left!=0){
            int i_swap = nums.length - 1;
            while (i_swap > left){
                if (nums[left-1] < nums[i_swap])    break;
                i_swap--;
            }
            swap(nums,left-1,i_swap);
        }
        while (left < right) {
            swap(nums, left++, right--);
        }
    }
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
