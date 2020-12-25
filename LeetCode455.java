package com.LY.LeetCode;

import java.util.Arrays;

public class LeetCode455 {
    //分发饼干
    public static void main(String[] args) {
        int[] g = {1,2,3};
        int[] s = {1,1};
        System.out.println(findContentChildren(g,s));
    }

    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);//首先排序
        int count_child = 0;
        for(int i = 0;i < s.length;i++){//从小到大依次分发饼干
            if(g[count_child] <= s[i]){//如果有孩子接受这个饼干则到下一个
                count_child++;
                if(count_child == g.length){//所有孩子都得到饼干马上返回
                    return count_child;
                }
            }
        }
        return count_child;
    }
}
