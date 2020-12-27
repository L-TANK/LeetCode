package com.LY.LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LeetCode205 {
    //同构字符串
    public static void main(String[] args) {
        String s = "egg";
        String t = "add";
        System.out.println(isIsomorphic(s,t));
    }
    //哈希表解法1：仿照LC209 错误原因：测试用例中String内不是纯字符串 修改方案：扩大used的大小到128 将下标的-'a'去除 保证全字符可用
    public static boolean isIsomorphic(String s, String t) {
        if(s == null || t == null) return false;
        char[] s2Char = s.toCharArray();
        char[] t2Char = t.toCharArray();
        if(s2Char.length != t2Char.length) return false;
        Map<Character, Character> map = new HashMap<>();//key :t v:s
        boolean[] used = new boolean[128];
        for(int i = 0;i < s2Char.length;i++){//建立哈希表
            if(!map.containsKey(t2Char[i])){//map中不含有对应的key
                if(used[s2Char[i]]){//但used标记了该key存在
                    return false;
                    //例如 a d d b---t
                    //    e g g e---s
                    //b进入时发现没有该key 但是used中e位置的标记为true
                }
                map.put(t2Char[i],s2Char[i]);//a-e,d-g放入
                used[s2Char[i]] = true;
            }else{//若map中含有对应的Key
                if(map.get(t2Char[i]) != s2Char[i]){
                    return false;
                }
            }
        }
        return true;
    }

    //官方双哈希解法
//    public static boolean isIsomorphic(String s, String t) {
//        Map<Character, Character> s2t = new HashMap<Character, Character>();
//        Map<Character, Character> t2s = new HashMap<Character, Character>();
//        int len = s.length();
//        for (int i = 0; i < len; ++i) {
//            char x = s.charAt(i), y = t.charAt(i);
//            if ((s2t.containsKey(x) && s2t.get(x) != y) || (t2s.containsKey(y) && t2s.get(y) != x)) {
//                return false;
//            }
//            s2t.put(x, y);
//            t2s.put(y, x);
//        }
//        return true;
//    }

}
