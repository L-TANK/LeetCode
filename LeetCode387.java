package com.LY.LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LeetCode387 {
    /**
     * 字符串中的第一个唯一字符
     * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
     */

    public static void main(String[] args) {
        System.out.println(firstUniqChar_1("loveleetcode"));
    }
    //利用map记录下标 重复出现的直接为-1 23ms
    public static int firstUniqChar_1(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] clist = s.toCharArray();
        int len = clist.length;
        for(int i = 0;i < len;i++){
            Character key = clist[i];
            if (map.containsKey(key)) {//判断key在map中是否存在。如果存在则返回true 不存在则返回false
                map.put(key,-1);//存在则说明该字符重复 置为-1标记
                continue;
            }
            map.put(key, i);//不存在则 设定一个新的映射关系 记录下下标
        }
        int min = -1;
        for(int i:map.values()){
            if(i != -1 && (i < min || min == -1)){
                min = i;
            }
        }
        return min;
    }
    //利用长度26的数组记录出现次数 最快4ms
    public static int firstUniqChar_2(String s) {
        int[] freq = new int[26];
        char[] chars = s.toCharArray();
        for (char ch : chars) {
            freq[ch - 'a']++;
        }
        for (int i = 0; i < chars.length; i++) {
            if (freq[chars[i] - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
    //利用map记录字符出现频率 38ms
    public static int firstUniqChar_3(String s) {
        Map<Character, Integer> map = new HashMap<>(26);
        char[] chars = s.toCharArray();
        for (char ch : chars) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < chars.length; i++) {
            if (map.get(chars[i]) == 1) {
                return i;
            }
        }
        return -1;
    }
    //利用接口寻找该字符在字符串中出现的最早和最后位置 若一样则直接返回 32ms
    public static int firstUniqChar_4(String s) {
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (s.indexOf(ch) == s.lastIndexOf(ch)) {
                return i;
            }
        }
        return -1;
    }
}
