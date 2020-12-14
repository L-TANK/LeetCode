package com.LY.LeetCode;

import java.util.Arrays;

public class LeetCode621 {
    //任务调度器
    public static void main(String[] args) {
        char [] tasks = {'A','A','A','B','B','B', 'C','C','C', 'D', 'D', 'E'};
        int n = 2;
        System.out.println(leastInterval(tasks,n));//12
    }

    public static int leastInterval(char[] tasks, int n) {
        if(tasks.length == 1 || n == 0) return tasks.length;
        //记录任务个数
        int[] count = new int[26];
        for(int i = 0;i < tasks.length;i++){
            count[tasks[i] - 'A']++;
        }
        //升序排序
        Arrays.sort(count);
        int maxCount = 1;
        //逆序统计同为最高频率的任务数量
        for(int i = 24;i >= 0;i--){
            if(count[i] != count[25]) break;
            maxCount++;
        }
        return Math.max((count[25] - 1) * (n + 1) + maxCount,tasks.length);
        /*count[25] - 1为最大任务数所需要的间隔次数，-1是因为最后一个任务不需要末尾间隔
        n + 1是指间隔时间+任务运行时间，即仅有一种任务时所需要的最少时间
        maxCount为具有多个最大任务时的任务附加时间
        最后后length的比较是防止多个最大任务数正好将空间填满，但任然存在零散任务的情况
        例如["A","A","A","B","B","B", "C","C","C", "D", "D", "E"] n = 2
        排列情况：A B C A B C A B D C E D 前者计算为9 但长度为12 则输出12
        */
    }
}


