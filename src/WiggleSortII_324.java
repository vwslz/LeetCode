import java.util.Arrays;

public class WiggleSortII_324 {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int[] copy = nums.clone();
        int i_l = (nums.length - 1) / 2;
        int i_r = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0)
                nums[i] = copy[i_l--];
            else
                nums[i] = copy[i_r--];
        }
    }

    public void swap(int[] nums, int i_0, int i_1) {
        int temp = nums[i_0];
        nums[i_0] = nums[i_1];
        nums[i_1] = temp;
    }

}
