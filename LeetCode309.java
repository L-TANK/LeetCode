package com.LY.LeetCode;

public class LeetCode309 {
    /**
     * 1/9 最佳买卖股票时机含冷冻期
     * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。
     *
     * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
     *
     * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
     */
    public static void main(String[] args) {
        int[] prices = {1,2,3,0,2};
        int profit = maxProfit(prices);
        System.out.println("最大收益：" + profit);
    }
    //动态规划 1ms
    public static int maxProfit(int[] prices) {
        if(prices.length == 0){
            return 0;
        }
        int n = prices.length;
        int[] hold = new int[n];//持股
        int[] no_hold = new int[n];//不持股
        hold[0] = -prices[0];

        for(int i = 1; i < n; i++) {
            if(i == 1){//第一天不可能处于冷冻期 特殊处理
                hold[i] = Math.max(hold[i - 1],-prices[i]);
                //此处第一天的持股为前一天继续持股和本日买入的最大值，
                //本日买入应为no_hold[i - 1] - prices[i],但前一日的no_hold必为0，故省略
            }
            else{//冷冻期过后的持股
                hold[i] = Math.max(hold[i - 1],no_hold[i - 2] - prices[i]);
            }
            no_hold[i] = Math.max(no_hold[i - 1],hold[i - 1] + prices[i]);
        }
        //返回不持股状态
        return no_hold[n - 1];
    }
}
