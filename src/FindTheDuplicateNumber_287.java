public class FindTheDuplicateNumber_287 {
    public int findDuplicate(int[] nums) {
        int ptr1 = nums[0];
        int ptr2 = nums[nums[0]];
        while (ptr1 != ptr2) {
            ptr1 = nums[ptr1];
            ptr2 = nums[nums[ptr2]];
        }
        ptr2 = 0;
        while (ptr1 != ptr2) {
            ptr1 = nums[ptr1];
            ptr2 = nums[ptr2];
        }
        return ptr1;
    }
}
