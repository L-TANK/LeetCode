package com.LY.LeetCode;

public class LeetCode714 {
    /**
     * 12/17 买卖股票的最佳时机含手续费
     * 1/9 更新注释和股票系列一起传
     * 给定一个整数数组 prices，其中第 i 个元素代表了第 i 天的股票价格 ；非负整数 fee 代表了交易股票的手续费用。
     *
     * 你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
     *
     * 返回获得利润的最大值。
     *
     * 注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。
     */
    public static void main(String[] args) {
        int[] prices = {1, 3, 2, 8, 4, 9};
        int profit = maxProfit(prices,2);
        System.out.println("最大收益：" + profit);
    }

    //动态规划 6ms
    public static int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[] dp = new int[2];
        //dp[0]:不持股，dp[1]:持股
        dp[1] = -prices[0];
        System.out.println("第0天股价" + prices[0] +"不持股:" + dp[0] + "持股:" + dp[1]);
        for(int i = 1; i < n; i++) {
            System.out.println("day" + i + ": 今日股价：" + prices[i]);
            //不持股的状态2个：1.当天就不持股 2.前天买股当天卖出（减手续费）
            dp[0] = Math.max(dp[0], dp[1] + prices[i] - fee);
            //持股的状态2个：1.当天持股 2.前天不持股当天买股
            dp[1] = Math.max(dp[1], dp[0] - prices[i]);
            System.out.println("不持股:" + dp[0] + "持股:" + dp[1]);
            System.out.println("--------------------------------");
        }
        //返回不持股状态
        return dp[0];
    }
}
