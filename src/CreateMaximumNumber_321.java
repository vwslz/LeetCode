public class CreateMaximumNumber_321 {
    // O(k*(2n + k^2)
    // Worst case: all numbers the same, very rare
    // getMaxNumber: O(n)
    // updateRes: O(k)
    // isGreater: O(k)
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] res = new int[k];

        for (int i = Math.max(k - nums2.length, 0); i <= nums1.length && i <= k; i++)
            updateRes(res, getMaxNumber(nums1, i), getMaxNumber(nums2, k-i));

        return res;
    }

    public int[] getMaxNumber(int[] input, int k) {
        int[] res = new int[k+1];
        int res_i = 0;
        res[res_i++] = input[0];
        for (int i = 1; i < input.length; i++) {
            while (res_i > 0 && input[i] > res[res_i - 1] && input.length - k >= i - res_i + 1)
                res_i--;
            if (res_i < k)
                res[res_i++] = input[i];
        }
        res[k] = Integer.MIN_VALUE;
        return res;
    }

    public void updateRes(int[] res, int[] nums1, int[] nums2) {
        int iter_1 = 0;
        int iter_2 = 0;
        boolean is_greater = false;
        for (int i = 0; i < res.length; i++) {
            if (!is_greater && nums1[iter_1] < res[i] && nums2[iter_2] < res[i])
                break;
            else {
                if (Math.max(nums1[iter_1], nums2[iter_2]) > res[i])
                    is_greater = true;
                if (isGreater(nums1, nums2, iter_1, iter_2))
                    res[i] = nums1[iter_1++];
                else
                    res[i] = nums2[iter_2++];
            }
        }
    }

    public boolean isGreater(int[] nums1, int[] nums2, int i1, int i2) {
        while (i1 < nums1.length && i2 < nums2.length) {
            if (nums1[i1++] != nums2[i2++]) {
                return nums1[i1-1] > nums2[i2-1];
            }
        }
        return i2 < nums2.length;
    }
}
