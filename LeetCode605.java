package com.LY.LeetCode;

public class LeetCode605 {
    /**
     * 1/1 种花问题
     * 假设你有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花卉不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
     *
     * 给定一个花坛（表示为一个数组包含0和1，其中0表示没种植花，1表示种植了花），和一个数 n 。能否在不打破种植规则的情况下种入 n 朵花？能则返回True，不能则返回False。
     *
     * 输入: flowerbed = [1,0,0,0,1], n = 1
     * 输出: True
     *
     * 输入: flowerbed = [1,0,0,0,1], n = 2
     * 输出: False
     */

    public static void main(String[] args) {
        int[] flowerbed = {0,0,1,0,0,0,0,1,0,1,0,0,0,1,0,0,1,0,1,0,1,0,0,0,1,0,1,0,1,0,0,1,0,0,0,0,0,1,0,1,0,0,0,1,0,0,1,0,0,0,1,0,0,1,0,0,1,0,0,0,1,0,0,0,0,1,0,0,1,0,0,0,0,1,0,0,0,1,0,1,0,0,0,0,0,0};
        int n = 17;
        System.out.println(canPlaceFlowers(flowerbed,n));
    }
    //解法2 巧解 首位加0解决边界问题 遇到连续的3个空则在中间栽花
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;
        int[] newFlowerbed = new int[len + 2];
        int j = 1;
        for(int i : flowerbed){
            newFlowerbed[j++] = i;
        }
        for(int i = 1;i < len + 1;i++){
            if(newFlowerbed[i - 1] == 0 && newFlowerbed[i] == 0 && newFlowerbed[i + 1] == 0){
                newFlowerbed[i] = 1;
                n--;
            }
        }
        return n <= 0;
    }
    //解法1 硬解 不改变数组在边界问题上很花逻辑 1ms 100% 代码逻辑混乱
//    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
//        int count = 0;
//        int count0 = 0;
//        boolean isFirst = true;
//        boolean noFlower = true;
//        if(flowerbed[0] == 1){
//            isFirst = false;
//        }
//        for (int i : flowerbed) {
//            if (i == 0) {//为0状态直接自加
//                count0++;
//            } else {//为1状态进行切割分析
//                if(noFlower){//花坛里面有花
//                    noFlower = false;
//                }
//                if(isFirst && count0 > 1){//头部只要有2个空位即可插入
//                    count += count0 / 2;
//                    isFirst = false;
//                }
//                else if (count0 > 2) {//非头部情况
//                    count += (count0 - 1) / 2;
//                }
//                count0 = 0;//0位置数量不够 重置计数器
//            }
//        }
//        if(noFlower && count0 > 0){//无花情况处理
//            count += (count0 + 1) / 2;
//        }
//        else if(count0 > 1){//尾部为0特殊处理 只要有2个空位即可插入
//            count += count0 / 2;
//        }
//        //System.out.println(count);
//        return count >= n;
//    }
}
