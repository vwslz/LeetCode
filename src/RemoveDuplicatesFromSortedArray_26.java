// O(n)
public class RemoveDuplicatesFromSortedArray_26 {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0)
            return 0;
        int pre = nums[0];
        int count = 1;
        int index = 1;
        for (int i = 1; i < nums.length; i++){
            if (nums[i] != pre){
                pre = nums[i];
                nums[index++] = nums[i];
                count++;
            }
        }
        return count;
    }
}
