package com.LY.LeetCode;

import java.util.HashMap;

public class LeetCode290 {
    //单词规律
    public static void main(String[] args) {
        System.out.println(wordPattern("abba","dog cat cat dog"));
    }

    public static boolean wordPattern(String pattern, String s) {
        if(pattern == null || s == null) return false;
        String[] strs = s.split(" ");//dog cat cat dog
        char[] patterns = pattern.toCharArray();//a b b a
        if(strs.length != patterns.length) return false;
        boolean[] used = new boolean[26];
        HashMap<String, Character> map = new HashMap<>();
        for (int i = 0; i < patterns.length; i++) {
            if(!map.containsKey(strs[i])){//若map中不含有对应的key
                if(used[patterns[i] - 'a']){//但used标记了该key存在
                    return false;//则出现冲突，返回错误
                    //例如 dog cat cat pig
                    //    a    b    b  a
                    //此时pig进入发现map无该key 但patterns为true
                }
                map.put(strs[i],patterns[i]);//将dog-a cat-b放入
                used[patterns[i] - 'a'] = true;
            }else {//若map中含有对应的key
                if(map.get(strs[i]) != patterns[i]){
                    return false;
                }
                //对当前key对应的value和该位置上的patterns进行比对 若冲突则报错
            }
        }
        System.out.println(map);
        return true;
    }
}
