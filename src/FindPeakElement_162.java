public class FindPeakElement_162 {
    public int findPeakElement(int[] nums) {
        if(nums.length == 1 || nums[0] > nums[1])
            return 0;
        if(nums[nums.length-1] > nums[nums.length-2])
            return nums.length - 1;

        int left = 0;
        int right = nums.length - 1;
        int index = (right - left + 1)/2;
        while(index < right){
            if(nums[index] > nums[index - 1])
                if(nums[index] > nums[index + 1])
                    return index;
                else
                    left = index;
            else
                right = index;
            index = (right - left + 1)/2 + left;
        }
        return -1;
    }
}
