package com.LY.LeetCode;

public class LeetCode746 {
    //使用最小花费爬楼梯
    public static void main(String[] args) {
        int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(minCostClimbingStairs(cost));
    }

    public static int minCostClimbingStairs(int[] cost) {//动态规划
        int len = cost.length;
        for(int i = 2; i < len; i ++){
            cost[i] += Math.min(cost[i - 1], cost[i - 2]);
        }//第3级阶梯的花费由当前阶梯花费+之前阶梯的花费（可从1级跳上来/2级走上来）
        return Math.min(cost[len - 1], cost[len - 2]);
    }
}
