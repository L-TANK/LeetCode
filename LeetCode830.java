package com.LY.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode830 {
    /**
     * 1/5 较大分组的位置
     * 在一个由小写字母构成的字符串 s 中，包含由一些连续的相同字符所构成的分组。
     *
     * 例如，在字符串 s = "abbxxxxzyy" 中，就含有 "a", "bb", "xxxx", "z" 和 "yy" 这样的一些分组。
     *
     * 分组可以用区间 [start, end] 表示，其中 start 和 end 分别表示该分组的起始和终止位置的下标。
     * 上例中的 "xxxx" 分组用区间表示为 [3,6] 。
     *
     * 我们称所有包含大于或等于三个连续字符的分组为 较大分组 。
     *
     * 找到每一个 较大分组 的区间，按起始位置下标递增顺序排序后，返回结果。
     *
     * 输入：s = "abcdddeeeeaabbbcd"
     * 输出：[[3,5],[6,9],[12,14]]
     * 解释：较大分组为 "ddd", "eeee" 和 "bbb"
     */

    public static void main(String[] args) {
        System.out.println(largeGroupPositions("abcdddeeeeaabbbcd"));
    }
    //快慢指针解法
    public static List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        if(s == null || s.length() == 0){
            return lists;
        }
        int len = s.length();
        int start = 0;
        int end = 0;
        while(true){
            List<Integer> list = new ArrayList<Integer>();
            char flag = s.charAt(start);
            while(end + 1 != len && s.charAt(end + 1) == flag){
                end++;
            }
            if(end - start > 1){//符合条件则加入
                list.add(start);
                list.add(end);
                lists.add(list);
            }
            if(end == len - 1){//处理到末尾直接返回
                return lists;
            }
            start = end + 1;
        }
    }
}
