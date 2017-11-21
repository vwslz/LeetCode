import java.util.Arrays;

public class MaximumGap_164 {
    public int maximumGap(int[] nums) {
        if (nums.length < 2)    return 0;
        int divid = 1, index = 0;
        int max = nums[0];
        for (index = 0; index < nums.length; index++) {
            if (nums[index] > max)
                max = nums[index];
        }

        while (max/divid > 0) {
            int i = 0;
            int[] digits = new int[10];
            int[] sorted = new int[nums.length];
            Arrays.fill(digits, 0);
            //count the digits
            for (i = 0; i < nums.length; i++) {
                digits[(nums[i] / divid )% 10]++;
            }
            // position of  the digits
            for (i = 1; i < 10; i++) {
                digits[i] += digits[i-1];
            }
            for (i = nums.length - 1; i > -1; i--) {
                sorted[(digits[(nums[i] / divid )% 10] - 1)] = nums[i];
                digits[(nums[i] / divid )% 10]--;
            }
            for (i = 0; i < nums.length; i++) {
                nums[i] = sorted[i];
            }
            divid *= 10;
        }

        int res = nums[1] - nums[0];
        for (index = 2; index < nums.length; index++) {
            if (nums[index] - nums[index-1] > res)  res = nums[index] - nums[index-1];
        }
        return res;
    }
}
