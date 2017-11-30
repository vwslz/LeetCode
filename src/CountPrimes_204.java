import java.util.Arrays;

public class CountPrimes_204 {
    public int countPrimes(int n) {
        n = n - 1;
        if(n <= 1)
            return 0;
        int[] nums = new int[n-1];
        Arrays.fill(nums, 0);
        int count = 0;
        int iter = 0;
        while(iter < n - 1){
            if(nums[iter] == 0){
                count++;
                int mul = 2;
                int index = (iter+2) * mul - 2;
                while(index < n - 1){
                    nums[index] = 1;
                    mul++;
                    index = (iter+2) * mul - 2;
                }
            }
            iter++;
        }
        return count;
    }
}
