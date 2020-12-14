package com.LY.LeetCode;

public class LeetCode376 {
    //摆动序列
    public static void main(String[] args) {
        int[] nums = {1,17,5,10,13,15,10,5,16,8};
        System.out.println(wiggleMaxLength(nums));//7 这个序列包含几个长度为 7 摆动序列，其中一个可为[1,17,10,13,10,16,8]
    }
    //灵活计算波峰波谷 未到波谷/峰前 up down仅更新一次
    public static int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if(n < 2) return n;
        int up = 1;
        int down = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                up = down + 1;
            }
            else if (nums[i] < nums[i - 1]) {
                down = up + 1;
            }
        }
        return Math.max(up, down);
    }
}
