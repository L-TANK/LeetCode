package com.LY.LeetCode;

public class LeetCode714 {
    //买卖股票的最佳时机含手续费
    public static void main(String[] args) {
        int[] prices = {1, 3, 2, 8, 4, 9};
        int profit = maxProfit(prices,2);
        System.out.println("最大收益：" + profit);
    }
    public static int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[] dp = new int[2];
        //dp[0]:不持股，dp[1]:持股
        dp[0] = 0;
        dp[1] = -prices[0];
        System.out.println("第0天股价" + prices[0] +"不持股:" + dp[0] + "持股:" + dp[1]);
        for(int i = 1; i < n; i++) {
            System.out.println("day" + i + ": 今日股价：" + prices[i]);
            //不持股的状态2个：1.当天就不持股 2.前天买股当天卖出（减手续费）
            dp[0] = Math.max(dp[0], dp[1] + prices[i] - fee);
            //持股的状态2个：1.当天持股 2.前天不持股当天买股
            dp[1] = Math.max(dp[1], dp[0] - prices[i]);
            System.out.println("不持股:" + dp[0] + "持股:" + dp[1]);
            System.out.println("-------------------------------");
        }
        //返回不持股状态
        return dp[0];
    }
}
