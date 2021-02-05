public class SuperUglyNumber_313 {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] nums = new int[n];
        nums[0] = 1;
        int[] positions = new int[primes.length];
        int iter = 1;
        while (iter < n) {
            int min = Integer.MAX_VALUE;
            int i_min = -1;
            for (int i = 0; i < primes.length; i++) {
                int candidate = primes[i] * nums[positions[i]];
                while (candidate <= nums[iter - 1]) {
                    positions[i]++;
                    candidate = primes[i] * nums[positions[i]];
                }
                if (candidate < min) {
                    min = primes[i] * nums[positions[i]];
                    i_min = i;
                }
            }
            nums[iter++] = min;
            positions[i_min]++;
        }
        return nums[n-1];
    }
}
