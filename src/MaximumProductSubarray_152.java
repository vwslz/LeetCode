public class MaximumProductSubarray_152 {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int localMax = 0;
        int iPre = 0;
        for (int i = 0; i < nums.length; i++)
        {
            if (nums[i] == 0) {
                localMax = maxProductHelper(nums, iPre, i - 1);
                iPre = i;
            }
            else if (i == nums.length - 1)
                localMax = maxProductHelper(nums, iPre, i);
            if (localMax > max)
                max = localMax;
        }
        return max;
    }

    public int maxProductHelper(int[] nums, int iBegin, int iEnd)
    {
        int res = 1;
        int nNeg = 0;
        int iFirst = -1;
        int iLast = -1;
        for (int i = iBegin; i <= iEnd; i++)
        {
            if (nums[i] < 0) {
                nNeg++;
                if (iFirst == -1)
                    iFirst = i;
                iLast = i;
            }
            res *= nums[i];
        }
        if (nNeg % 2 == 0)
            return res;
        else
        {
            int left = 1;
            int right = 1;
            for (int i = 0; i <= iFirst; i++)
                left *= nums[i];
            for (int i = iLast; i < nums.length; i++)
                right *= nums[i];
            if (left > right)
                return res / left;
            else
                return res / right;
        }

    }
}
