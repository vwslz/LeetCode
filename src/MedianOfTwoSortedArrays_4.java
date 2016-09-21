public class MedianOfTwoSortedArrays_4 {
    // O(log n)
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int leftMedian = (nums1.length+nums2.length+1)/2;
        int rightMedian = (nums1.length+nums2.length+2)/2;
        return (helper(nums1,nums2,leftMedian)+helper(nums1,nums2,rightMedian))/2;
    }

    public double helper(int[] nums1, int[]nums2, int top) {
        int start1 = 0, start2 = 0;
        if(start1 >= nums1.length) return nums2[start2+top-1];
        if(start2 >= nums2.length) return nums1[start1+top-1];
        while (start1 < nums1.length && start2 < nums2.length) {
            if(top == 1) return (nums1[start1] <= nums2[start2]) ? nums1[start1] : nums2[start2];
            if(start2+top/2-1 > nums2.length-1) {
                start1 += top/2;
                top -= top/2;
            }
            else if(start1+top/2-1 > nums1.length-1) {
                start2 += top/2;
                top -= top/2;
            }
            else if(nums1[start1+top/2-1] < nums2[start2+top/2-1]) {
                start1 += top/2;
                top -= top/2;
            }
            else {
                start2 += top/2;
                top -= top/2;
            }
            if(start1 >= nums1.length) return nums2[start2+top-1];
            if(start2 >= nums2.length) return nums1[start1+top-1];
        }
        return 0;
    }
}
