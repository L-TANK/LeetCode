package com.LY.LeetCode;

public class LeetCode509 {
    /**
     * 1/4 斐波那契数列
     * 通常用 F(n) 表示，形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和
     * 解法1：常规递归，代码简单，容易超时
     * 解法2：数组解法，利用数组进行记忆，操作数组速度中等
     * 加法3：整型替换，利用整型记录各项的值，操作整型速度最快
     */

    public static void main(String[] args) {
        System.out.println(fib(4));
    }
    //解法1
//    public static int fib(int n) {
//         if(n == 0 || n == 1) {
//             return n;
//         }
//         return fib(n - 1) + fib(n - 2);
//    }
    //解法2
//    public static int fib(int n) {
//        if(n == 0 || n == 1) {
//            return n;
//        }
//        int[] arr = new int[n + 1];
//        arr[0] = 0;
//        arr[1] = 1;
//        for(int i = 2;i <= n;i++){
//            arr[i] = arr[i - 1] + arr[i - 2];
//        }
//        return arr[n];
//    }
    //解法3
    public static int fib(int n) {
         if(n == 0 ||n == 1){
             return n;
         }
         int a = 0;
         int b = 1;
         int sum = 0;
         for(int i = 2;i <= n;i++){
             sum = a + b;
             a = b;
             b = sum;
         }
         return sum;
    }
}
