public class MissingNumber_268 {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return (1 + n) * n / 2 - sum;

//        //3 ms
//        int[] ori = new int[nums.length + 1];
//        Arrays.fill(ori, 0);
//        for (int i = 0; i < nums.length; i++) {
//            ori[nums[i]] = 1;
//        }
//        for (int i = 0; i < nums.length + 1; i++) {
//            if (ori[i] == 0)
//                return i;
//        }
//        return -1;
//
//        //13 ms
//        Arrays.sort(nums);
//        for(int i = 0; i < nums.length; i++){
//         if(nums[i] != i)
//             return i;
//        }
//        return nums.length;
    }
}
