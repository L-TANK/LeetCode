package com.LY.LeetCode;

public class LeetCode135 {
    //分发糖果
    public static void main(String[] args) {
        int[] a = {1,3,4,5,2};
        System.out.println(candy(a));
    }
    //正序 逆序各遍历一次保证糖果分配的原则
    public static int candy(int[] ratings) {
        int len = ratings.length;
        int[] count = new int[len];
        for (int i = 0; i < len; i++) {
            count[i] = 1;
        }
        for (int i = 1; i < len; i++) {
            if(ratings[i] > ratings[i - 1]){
                count[i] = count[i - 1] + 1;
            }
        }
        for(int i = len - 2;i >= 0;i--){
            if(ratings[i] > ratings[i + 1] && count[i] <= count[i + 1]){
                count[i] = count[i + 1] + 1;
            }
        }
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += count[i];
            System.out.print(count[i] + " ");
        }
        System.out.println();

        return sum;
    }
}
