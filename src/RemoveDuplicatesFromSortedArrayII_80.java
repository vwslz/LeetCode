// O(n)
public class RemoveDuplicatesFromSortedArrayII_80 {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2)
            return nums.length;
        int pre = nums[1];
        int ppre = nums[0];
        int index = 2;
        for (int i = 2; i < nums.length; i++){
            if (nums[i] != pre || nums[i] != ppre){
                nums[index++] = nums[i];
                ppre = pre;
                pre = nums[i];
            }
        }
        return index;
    }
}
