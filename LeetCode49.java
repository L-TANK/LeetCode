package com.LY.LeetCode;

import java.util.*;

public class LeetCode49 {
//    字母异位词分组 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
//    输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
//    输出:
//            [
//            ["ate","eat","tea"],
//            ["nat","tan"],
//            ["bat"]
//            ]

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, ArrayList<String>> map = new HashMap<>();//建立一个以字符串为key，list为value的map
        for (int i = 0; i < strs.length ; i++) {
            char[] chars = strs[i].toCharArray();//字符串转字符组
            Arrays.sort(chars);//字符组排序
            String key = String.valueOf(chars);//排序后的字符组设为key
            if (!map.containsKey(key)) {//判断key在map中是否存在。如果存在则返回true 不存在则返回false
                map.put(key, new ArrayList<>());//设定一个新的映射关系
            }
            map.get(key).add(strs[i]);//由获取的key去向该value中加入该字符串
        }
        return new ArrayList<>(map.values());
    }

//    public List<List<String>> groupAnagrams(String[] strs) {
//        Map<String, List<String>> map = new HashMap<String, List<String>>();
//        for (String str : strs) {
//            char[] array = str.toCharArray();
//            Arrays.sort(array);
//            String key = new String(array);
//            List<String> list = map.getOrDefault(key, new ArrayList<String>());
//            //官方解法中使用了getOrDefault，如果map中含有指定的key，就返回该key对应的value，否则使用该方法的第二个参数作为默认值返回
//            list.add(str);
//            map.put(key, list);
//        }
//        return new ArrayList<List<String>>(map.values());
//    }
}


