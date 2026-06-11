class Solution {
    public static int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            max = Math.max(max, prices[i] - minPrice);
            minPrice = Math.min(minPrice, prices[i]);
        }
        return max;
    }
}
