public class MoveZeroes_283 {
    public void moveZeroes(int[] nums) {
        int n = 0;
        int index = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0)
                n++;
            else{
                if(index != i){
                    nums[index] = nums[i];
                }
                index++;
            }
        }
        for(int j = index; j < nums.length; j++){
            if(nums[j] != 0)
                nums[j] = 0;
        }
    }
}
