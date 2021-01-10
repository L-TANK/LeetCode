package com.LY.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode228 {
    /**
     * 1/10 汇总区间
     * 给定一个无重复元素的有序整数数组 nums 。
     * 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表。
     * 也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，
     * 并且不存在属于某个范围但不属于 nums 的数字 x 。
     *
     * 输入：nums = [0,1,2,4,5,7]
     * 输出：["0->2","4->5","7"]
     * 解释：区间范围是：
     * [0,2] --> "0->2"
     * [4,5] --> "4->5"
     * [7,7] --> "7"
     */
    public static void main(String[] args) {
        int[] nums = {0,1,2,4,5,7};
        System.out.println(summaryRanges(nums));
    }

    //大佬解法 0ms :)
    public static List<String> summaryRanges(int[] nums) {
        int len = nums.length;
        ArrayList<String> strings = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < len; ++i){
            if(!(i + 1 < len && nums[i] + 1 == nums[i + 1])){
                if(sb.length() > 0) {
                    sb.append("->");
                }
                sb.append(nums[i]);
                strings.add(sb.toString());
                sb = new StringBuilder();
            } else{
                if(sb.length() == 0) {
                    sb.append(nums[i]);
                }
            }
        }
        return strings;
    }

    //快慢指针 7ms :(
//    public static List<String> summaryRanges(int[] nums) {
//        int len = nums.length;
//        ArrayList<String> strings = new ArrayList<>();
//        int start = 0;
//        int end = 0;
//        while(start < len){
//            while(end + 1 < len && nums[end + 1] == nums[end] + 1){
//                end++;
//            }
//            if(start == end){
//                strings.add(String.valueOf(nums[start]));
//            }
//            else{
//                strings.add(nums[start] + "->" + nums[end]);
//            }
//            if(end == len - 1){
//                break;
//            }
//            else{
//                start = end + 1;
//                end++;
//            }
//        }
//        return strings;
//    }

}
