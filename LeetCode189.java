package com.LY.LeetCode;

public class LeetCode189 {
    /**
     * 1/8 旋转数组
     * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
     */

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        rotate_3(nums,2);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    /**
     * 解法0：开辟另一个数组空间 略
     */

    /**
     * 解法1：头插法 259ms :(
     */
    public static void rotate_1(int[] nums, int k) {
        int len = nums.length;
        k %= len;//防止k大于len出现冗余移动
        for(int i = 0;i < k;i++){
            int temp = nums[len - 1];
            for (int j = len - 1; j > 0; j--) {
                nums[j] = nums[j - 1];
            }
            nums[0] = temp;
        }
    }

    /**
     * 解法2：翻转
     * 1234567->7654321->7612345->6712345 0ms :)
     */
    public static void rotate_2(int[] nums, int k) {
        int len = nums.length;
        k %= len;//防止k大于len出现冗余移动
        reverse(nums,0,len - 1);
        reverse(nums,k,len - 1);
        reverse(nums,0,k - 1);
    }

    public static void reverse(int[] nums,int start,int end){
        while(start < end){
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }

    /**
     * 解法3：循环交换 1ms :|
     * 1234567 1<->6 2<->7
     * 6734512 3<->1 4<->2
     * 6712534 5<->3 5<->4
     * 6712345
     */
    public static void rotate_3(int[] nums, int k) {
        int length = nums.length;
        int len = nums.length;
        k %= len;
        // 第一次交换完毕后，前 k 位数字位置正确，后 n-k 位数字中最后 k 位数字顺序错误，继续交换
        for (int start = 0; start < length && k != 0; len -= k, start += k, k %= len) {
            for (int i = 0; i < k; i++) {
                swap(nums, start + i, length - k + i);
            }
            for (int num : nums) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
        System.out.println("--------------------");
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
