public class BestTimeToBuyAndSellStock_121 {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int currentProfit = 0;
        for (int i = 1; i < prices.length; i++)
        {
            currentProfit += prices[i] - prices[i - 1];
            if (currentProfit > profit)
                profit = currentProfit;
            else if (currentProfit < 0)
                currentProfit = 0;
        }
        return profit;
    }
}
