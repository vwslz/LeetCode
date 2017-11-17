public class UniqueBinarySearchTrees_96 {
    public int numTrees(int n) {
        /** dp **/
        int[] res = new int[n + 1];
        res[0] = 1;
        res[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                res[i] += res[i - j - 1] * res[j];
            }
        }
        return res[n];

        /** cantalan tree
         * C(2n,n)/(n+1)
         * (2n)! / n! / (n + 1)!
         **/
//        long ans = 1;
//        int i;
//        for(i = 1;i <= n; i++)
//            ans *= (i + n) / i;
//        return (int)(ans / i);
    }
}
