package com.LY.LeetCode;

public class LeetCode188 {
    /**
     * 12/28 买卖股票的最佳时机 IV
     * 1/9 更新注释和股票系列一起传
     * 给定一个整数数组 prices ，它的第 i 个元素 prices[i] 是一支给定的股票在第 i 天的价格。
     *
     * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
     * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     */
    public static void main(String[] args) {
        int[] prices = {3,2,6,5,0,3};
        int profit = maxProfit(2,prices);
        System.out.println("最大收益：" + profit);
    }
    //动态规划 5ms
    public static int maxProfit(int k, int[] prices) {
        if(prices.length == 0 || k == 0){
            return 0;
        }
        int[] buy = new int[k + 1];//设置长度多1 将第一个留作哨兵处理边界
        int[] sell = new int[k + 1];
        for (int i = 1;i < k + 1;i++) {
            buy[i] = Integer.MIN_VALUE;
        }
        for(int p : prices){
            for(int j = 1;j <= k;j++){
                buy[j] = Math.max(buy[j],sell[j - 1] - p);
                sell[j] = Math.max(sell[j],buy[j] + p);
            }
        }
        return sell[k];
    }
}
