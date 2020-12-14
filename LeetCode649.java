package com.LY.LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode649 {
    //DOTA2参议院
    public static void main(String[] args) {
        System.out.println(predictPartyVictory("RDD"));//D
    }

    //官方双队列解法
    public static String predictPartyVictory(String senate) {
        Queue<Integer> R = new LinkedList<>();
        Queue<Integer> D = new LinkedList<>();
        int n = senate.length();
        for(int i = 0;i < n;i++){
            if(senate.charAt(i) == 'R') R.offer(i);
            else D.offer(i);
        }
        while(!R.isEmpty() && !D.isEmpty()){
            int r = R.poll();
            int d = D.poll();
            if(r < d) R.offer(r + n);
            else D.offer(d + n);
        }
        return R.isEmpty() ? "Dire" : "Radiant";
    }

    /* 大佬的计数器解法
    public String predictPartyVictory(String senate) {
        int Rnumber = 0;//R阵营总人数
        int Dnumber = 0;//D阵营总人数
        int curBanR = 0;//当前被ban
        int curBanD = 0;//当前被ban
        int totalBanR = 0;//被ban总数
        int totalBanD = 0;//被ban总数
        char[] chars = senate.toCharArray();
        boolean flag = true;
        while(true){
            for(int i = 0;i < chars.length;i++){
                char cur = chars[i];
                if(cur == 'R'){
                    if(flag)
                        Rnumber++;
                    if(curBanR == 0){
                        curBanD++;
                        totalBanD++;
                        if(totalBanD == Dnumber  && !flag)return "Radiant";
                    }else{
                        curBanR--;
                        chars[i] = 'r';
                    }
                }else if(cur == 'D'){
                    if(flag)
                        Dnumber++;
                    if(curBanD == 0){
                        curBanR++;
                        totalBanR++;
                        if(totalBanR == Rnumber  && !flag)return "Dire";
                    }else{
                        curBanD--;
                        chars[i] = 'd';
                    }
                }
            }
            flag = false;
            if(totalBanD >= Dnumber)return "Radiant";
            if(totalBanR >= Rnumber)return "Dire";
        }
    }

*/
}
