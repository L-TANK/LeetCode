package com.LY.LeetCode;

import java.util.Arrays;
import java.util.Comparator;

public class LeetCode435 {
    /**
     * 12/31 无重叠区间
     * 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
     * 可以认为区间的终点总是大于它的起点。
     * 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
     * 输入: [ [1,2], [2,3], [3,4], [1,3] ]
     * 输出: 1
     * 解释: 移除 [1,3] 后，剩下的区间没有重叠。
     */

    public static void main(String[] args) {
        int[][] intervals = {{1,2},{1,2},{1,2}};
        System.out.println(eraseOverlapIntervals(intervals));
    }

    public static int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals,new Comparator<int [] >(){
            public int compare(int [] a1,int [] a2) {
                return a1[1] - a2[1];   //升序排列
            }
        });
        int count = 0;	//记录要舍弃的区间数量
        int end = intervals[0][1];//取排序后的最小结尾为第一个结尾
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < end) {//如果后续遇到的区间开头小于当前结尾位置 则舍弃该区间
                count++;
            }else{
                end = intervals[i][1];//记录下新的尾部
            }
        }
        return count;
    }
}


