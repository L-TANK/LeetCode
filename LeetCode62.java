package com.LY.LeetCode;

public class LeetCode62 {
    //不同路径
    public static void main(String[] args) {
        System.out.println(uniquePaths(7,3));//28
    }

    public static int uniquePaths(int m, int n) {
        // if(m == 1 || n == 1) return 1;
        // return uniquePaths(m - 1,n) + uniquePaths(m,n - 1);
        //递归方法会超时，需要利用数组进行记录
        int[][] dp = new int[m][n];
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if(i == 0 || j == 0) dp[i][j] = 1;
                else dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}

