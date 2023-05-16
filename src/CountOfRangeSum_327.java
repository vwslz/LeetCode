import java.util.Arrays;

//Fenwick trees
public class CountOfRangeSum_327 {
    public int countRangeSum(int[] nums, int lower, int upper) {
        BinaryIndexedTree bit  = new BinaryIndexedTree();
        bit.constructBITree(nums, nums.length);
        int res = 0;
//        long[] sums = new long[nums.length];
//        for (int i = 0; i < nums.length; i++) {
//            sums[i] = bit.getSum(i);
//        }
//        System.out.println(Arrays.toString(sums));
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                long sum  = bit.getSum(j) - bit.getSum(i-1);
                if (sum >= lower && sum <= upper) {
//                    System.out.println(i + " " + j + ": " + sum);
                    res += 1;
                }
            }
        }
        return res;
    }

    class BinaryIndexedTree
    {
        int MAX = 100001;

        long BITree[] = new long[MAX];

        public long getSum(int index)
        {
            long sum = 0;
            index = index + 1;
            while(index>0)
            {
                sum += BITree[index];
                index -= index & (-index);
            }
            return sum;
        }

        public void updateBIT(int n, int index, long val)
        {
            index = index + 1;

            while(index <= n)
            {
                BITree[index] += val;
                index += index & (-index);
            }
        }

        void constructBITree(int arr[], int n)
        {
            for(int i=1; i<=n; i++)
                BITree[i] = 0;
            for(int i = 0; i < n; i++)
                updateBIT(n, i, arr[i]);
        }
    }
}
