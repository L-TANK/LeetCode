package com.LY.LeetCode;

public class LeetCode84 {
    /**
     * 12/26 柱状图中最大的矩形
     * 类似LC85 一起练习
     * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
     * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
     */
    public static void main(String[] args) {
        int[] heights = {2,1,5,6,2,3};
        System.out.println(largestRectangleArea_1(heights));
    }

    /**
     * 解法1：暴力解法 超时 :(
     * 遍历每个数组元素，向其左右进行遍历，遇到小于该高度的矩形则停下，
     * 记录下左右的宽度，计算出当前的矩形高度，更新最大面积
     */
    public static int largestRectangleArea_1(int[] heights) {
        int maxArea = 0;
        int len = heights.length;
        // 遍历每个柱子，以当前柱子的高度作为矩形的高 h，
        // 从当前柱子向左右遍历，找到矩形的宽度 w。
        for (int i = 0; i < len; i++) {
            int leftWide = 0;
            int rightWide = 0;
            int h = heights[i];
            while (i - leftWide - 1 >= 0 && heights[i - leftWide - 1] >= h) {
                leftWide++;
            }
            while (i + rightWide + 1 < len && heights[i + rightWide + 1] >= h) {
                rightWide++;
            }
            maxArea = Math.max(maxArea, (leftWide + rightWide + 1) * h);
        }

        return maxArea;
    }

    /**
     *  测试push
     */
}
