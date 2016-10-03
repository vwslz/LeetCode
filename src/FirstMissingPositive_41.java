// O(n)
public class FirstMissingPositive_41 {
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {;
            if (nums[i] < 1 || nums[i] > nums.length)    nums[i] = -1;
            else {
                int iter = nums[i];
                nums[i] = -1;
                while (iter > 0 && iter <= nums.length) {
                    int temp = nums[iter - 1];
                    nums[iter - 1] = iter;
                    if (iter == temp)
                        break;
                    else
                        iter = temp;
                }
            }
        }
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == -1)
                return j+1;
        }
        return nums.length + 1;
    }
}
