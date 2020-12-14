package com.LY.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LeetCode217 {
    //存在重复元素 数组去重
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        System.out.println(containsDuplicate(nums));//true
    }
    //利用hashset去重
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int x : nums) {
            if (!set.add(x)) {
                return true;
            }
        }
        return false;
    }
    //暴力遍历检索
//    public boolean containsDuplicate(int[] nums) {
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                if(nums[i] == nums[j]) return true;
//            }
//        }
//        return false;
//    }
    //排序后比较相邻元素是否相同
//    public static boolean containsDuplicate(int[] nums) {
//        Arrays.sort(nums);
//        for(int i = 1; i < nums.length; i++){
//            if(nums[i] == nums[i-1]){
//                return true;
//            }
//        }
//        return false;
//    }
}
