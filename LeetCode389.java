package com.LY.LeetCode;

import java.util.Arrays;

public class LeetCode389 {
    //找不同
    public static void main(String[] args) {
        System.out.println(findTheDifference("acd","abcd"));
    }
    //解法1：排序解法 转换字符数组 排序 逐位比较
//    public static char findTheDifference(String s, String t) {
//        char[] stochar = s.toCharArray();//转换成数组
//        char[] ttochar = t.toCharArray();
//        Arrays.sort(stochar);//数组排序
//        Arrays.sort(ttochar);
//        int i = 0;
//        for(;i < stochar.length;i++){
//            if(stochar[i] != ttochar[i]){//不同则返回
//                return ttochar[i];
//            }
//        }
//        return ttochar[i];//若前面全对则末位为不同字母
//    }
    //解法2：计数解法 字符数组求和做差 差值转为字符
//    public static char findTheDifference(String s, String t) {
//        char[] stochar = s.toCharArray();//转换成数组
//        char[] ttochar = t.toCharArray();
//        int count = 0;
//        for (char c : ttochar) {
//            count += c;
//        }
//        for (char c : stochar) {
//            count -= c;
//        }
//        return (char) count;
//    }
    //解法3：异或解法 异或字符 相同为0 不同为1 最后剩下的就是多余的字符
    public static char findTheDifference(String s, String t) {
        char[] stochar = s.toCharArray();//转换成数组
        char[] ttochar = t.toCharArray();
        char ret = '\0';
        for (char c : ttochar) {
            ret ^= c;
        }
        for (char c : stochar) {
            ret ^= c;
        }
        return ret;
    }

}
