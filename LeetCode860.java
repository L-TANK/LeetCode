package com.LY.LeetCode;

public class LeetCode860 {
    //柠檬汽水找零
    public static void main(String[] args) {
        int[] bills = {5,5,10,10,20};
        System.out.println(lemonadeChange(bills));//false
    }
    //贪心算法 通过模拟的方式 逐步找零 在需要对20面额进行找零时有限使用10面额的进行找零
    public static boolean lemonadeChange(int[] bills) {
        int change5 = 0;
        int change10 = 0;
        //int change20 = 0;
        for(int i = 0;i < bills.length;i++){
            if(bills[i] == 5) change5++;
            else if(bills[i] == 10){
                if(change5 > 0){
                    change5--;
                    change10++;
                }
                else return false;
            }
            else{
                if(change10 > 0 && change5 > 0){
                    change5--;
                    change10--;
                    //change20++;
                }
                else if(change5 > 2){
                    change5 -= 3;
                }
                else return false;
            }
        }
        return true;
    }
}
