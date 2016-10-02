// O(n)
public class FirstMissingPositive_41 {
    public int firstMissingPositive(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min)
                min = nums[i];
        }
        if (min > 1)
            return 1;
        else {

        }
    }
}
