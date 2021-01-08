package com.LY.LeetCode;

public class LeetCode547 {
    /**
     * 1/7 省份数量
     * 有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，
     * 且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连。
     *
     * 省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。
     *
     * 给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，
     * 而 isConnected[i][j] = 0 表示二者不直接相连。
     *
     * 返回矩阵中 省份 的数量。
     */

    public static void main(String[] args) {
        int[][] isConnected = {{1,1,0},{1,1,0},{0,0,1}};
        System.out.println(findCircleNum(isConnected));
    }

    public static int findCircleNum(int[][] isConnected) {
        /**
         使用一个visited数组, 依次判断每个节点, 如果其未访问, 朋友圈数加1并对该节点进行dfs搜索标记所有访问到的节点
         **/
        int len = isConnected.length;
        boolean[] visited = new boolean[len];
        int ret = 0;//省份计数器
        for(int i = 0; i < len; i++) {
            if(!visited[i]) {
                dfs(isConnected, visited, i);
                ret++;
            }
        }
        return ret;
    }
    //深度遍历每个节点，找出该节点的所有朋友组成一个朋友圈，并将所有朋友的访问位置置为1
    private static void dfs(int[][] isConnected, boolean[] visited, int i) {
        for(int j = 0; j < isConnected.length; j++) {
            if(isConnected[i][j] == 1 && !visited[j]) {
                visited[j] = true;//访问位置为true
                dfs(isConnected, visited, j);
            }
        }
    }
}
