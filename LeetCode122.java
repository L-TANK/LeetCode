package com.LY.LeetCode;

public class LeetCode122 {
    /**
     * 1/9 买卖股票的最佳时机 II
     * 给定一个数组，它的第  i 个元素是一支给定股票第 i 天的价格。
     *
     * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
     *
     * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     */

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        int profit = maxProfit_2(prices);
        System.out.println("最大收益：" + profit);
    }

    //贪心算法 1ms
    public static int maxProfit_1(int[] prices) {
        int ans = 0;
        for(int i = 1;i < prices.length;i++){
            if(prices[i] > prices[i-1]){
                ans += prices[i] - prices[i - 1];//只要前一天低过后一天 直接买卖
            }
        }
        return ans;
    }

    //动态规划 2ms
    public static int maxProfit_2(int[] prices) {
        int n = prices.length;
        int[] dp = new int[2];
        //dp[0]:不持股，dp[1]:持股
        dp[1] = -prices[0];
        System.out.println("第0天股价" + prices[0] +"不持股:" + dp[0] + "持股:" + dp[1]);
        for(int i = 1; i < n; i++) {
            System.out.println("day" + i + ": 今日股价：" + prices[i]);
            //不持股的状态2个：1.当天就不持股 2.前天买股当天卖出
            dp[0] = Math.max(dp[0], dp[1] + prices[i]);
            //持股的状态2个：1.当天持股 2.前天不持股当天买股
            dp[1] = Math.max(dp[1], dp[0] - prices[i]);
            System.out.println("不持股:" + dp[0] + "持股:" + dp[1]);
            System.out.println("--------------------------------");
        }
        //返回不持股状态
        return dp[0];
    }
}
