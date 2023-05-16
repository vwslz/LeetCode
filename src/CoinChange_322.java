import java.util.Arrays;

public class CoinChange_322 {
    public int coinChange(int[] coins, int amount) {
        int[] res = new int[amount+1];
        Arrays.fill(res, Integer.MAX_VALUE);
        Arrays.sort(coins);
        res[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int j = coins.length - 1; j >= 0; j--) {
                int coin = coins[j];
//                System.out.println("Coin: " + coin);
                if (i - coin >= 0 && res[i - coin] != Integer.MAX_VALUE) {
                    res[i] = Math.min(res[i-coin] + 1, res[i]);
                }
            }
//            System.out.println(Arrays.toString(res));
        }
        return res[res.length-1] >= Integer.MAX_VALUE ? -1 : res[res.length-1];
    }
}
