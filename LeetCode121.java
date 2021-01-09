package com.LY.LeetCode;

public class LeetCode121 {
    /**
     * 股票系列刷完 121(单笔)->122(多笔)->714(多笔+手续费)->309(多笔+冷冻期)->123(2笔)->188(K次)
     * 1/9 买卖股票的最佳时机
     * 给定一个数组，它的第  i 个元素是一支给定股票第 i 天的价格。
     *
     * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
     *
     * 注意：你不能在买入股票前卖出股票。
     */
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        int profit = maxProfit(prices);
        System.out.println("最大收益：" + profit);
    }

    //动态规划 2ms
    public static int maxProfit(int[] prices) {
        if(prices.length == 0){
            return 0;
        }
        int n = prices.length;
        int min = prices[0];//记录每日之前的最小值
        int max = 0;//记录当前能取得的最大收益
        for(int i = 1; i < n; i++) {
            //每日更新在当日能取得的最大收益，prices[i] - min为如果在之前最低点买入，在今天能获得的收益
            max = Math.max(max, prices[i] - min);
            //更新全局最低价
            min = Math.min(min, prices[i]);
        }
        //返回最大收益
        return max;
    }
}
