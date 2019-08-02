import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SummaryRanges_228 {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<String>();

        if (nums.length == 0)
            return res;
        else if (nums.length == 1) {
            res.add(nums[0] + "");
            return res;
        }
        int pre = nums[0];
        boolean isRange = nums[1] - nums[0] == 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i-1] != 1) {
                if (isRange)
                    res.add(pre + "->" + nums[i-1]);
                else
                    res.add(pre + "");

                pre = nums[i];
                isRange = (i + 1 < nums.length && nums[i + 1] - nums[i] == 1);
            }
        }

        if (isRange)
            res.add(pre + "->" + nums[nums.length-1]);
        else
            res.add(pre + "");
        return res;
    }
}
