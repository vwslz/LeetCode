// o(n)
public class MergeSortedArray_88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = m+n-1;
        m = m - 1;
        n = n - 1;
        while (m > -1 && n > -1) {
            nums1[index--] = (nums2[n] >= nums1[m]) ? nums2[n--] : nums1[m--];
        }
        while (n > -1) nums1[index--] = nums2[n--];
    }
}
