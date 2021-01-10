import java.util.EnumSet;

public class BestTimeToBuyAndSellStockWithCooldown_309 {
    // O(n)
    public int maxProfit(int[] prices) {
        if (prices.length < 2)
            return 0;

        int profit_hold = -prices[0];
        int profit_sold = 0;
        int profit_no_stock = 0;

        for (int i = 1; i < prices.length; i++) {
            profit_hold = Math.max(profit_hold, profit_no_stock - prices[i]);
            profit_no_stock = Math.max(profit_no_stock, profit_sold);
            profit_sold = Math.max(profit_sold, profit_hold + prices[i]);
        }
        return Math.max(profit_sold, profit_sold);
    }
}
