package com.LY.LeetCode;

import java.util.Stack;

public class LeetCode316 {
    //去除重复字母
    public static void main(String[] args) {
        System.out.println(removeDuplicateLetters("cbacdcbc"));
    }

    public static String removeDuplicateLetters(String s) {
        int len = s.length();

        char[] charArray = s.toCharArray();
        int [] lastIndex = new int[26];
        for(int i = 0;i < len;i++){
            lastIndex[charArray[i] - 'a'] = i;//记录下每个字符最后出现的位置
        }
        Stack<Character> stack = new Stack<Character>();
        boolean[] visited = new boolean[26];
        for (int i = 0; i < len; i++) {//遍历字符串
            if(visited[charArray[i] - 'a']){//如果当前字符在栈中已经存在，则丢弃
                continue;
            }

            //如果栈顶元素的值大于当前字符的值，且栈非空,且当前栈顶元素在之后仍然出现
            while(!stack.isEmpty() && stack.peek() > charArray[i] && lastIndex[stack.peek() - 'a'] > i){
                Character top = stack.pop();
                visited[top - 'a'] = false;//将出栈的字符的访问值置为false
            }

            stack.add(charArray[i]);//加入当前字符
            visited[charArray[i] - 'a'] = true;//置当前字符的访问值为true
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Character character : stack) {
            stringBuilder.append(character);
        }
        return stringBuilder.toString();
    }

}
