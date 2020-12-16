package com.LY.LeetCode;

public class LeetCode738 {
    /**
     * 单调递增的数字
     * 思路：
     *  从右向左扫描数字，若发现当前数字比其左边一位（较高位）小，
     *  则把其左边一位数字减1，并将该位及其右边的所有位改成9
     */
    public static void main(String[] args) {
        System.out.println(monotoneIncreasingDigits(332));//229
    }

    public static int monotoneIncreasingDigits(int N) {
        String s = String.valueOf(N);
        char[] chars = s.toCharArray();
        int length = s.length();
        int flag = length;
        for (int i = length - 1; i > 0; i--) {
            if(chars[i] < chars[i - 1]){//如果低位比高位小 则高位-1 记录下低位的位置 后续把低位后的全部变为9
                flag = i;
                chars[i - 1]--;
            }
        }

        for (int i = flag; i < length; i++) {
            chars[i] = '9';
        }

        return Integer.parseInt(new String(chars));
    }
}




