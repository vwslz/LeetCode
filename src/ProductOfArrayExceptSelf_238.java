public class ProductOfArrayExceptSelf_238 {
    public int[] productExceptSelf(int[] nums) {
        int product = 1;
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length - 1; i++) {
            res[i] = product;
            product *= nums[i];
        }
        res[nums.length - 1] = product;
        product = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] *= product;
            product *= nums[i];
        }
        return res;
    }
}
