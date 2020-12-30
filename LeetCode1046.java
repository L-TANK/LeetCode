package com.LY.LeetCode;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class LeetCode1046 {
    /**
     * 12/30 最后一块石头的重量
     * 有一堆石头，每块石头的重量都是正整数。
     *
     * 每一回合，从中选出两块 最重的 石头，然后将它们一起粉碎。假设石头的重量分别为  x 和  y，且  x <= y。那么粉碎的可能结果如下：
     *
     * 如果  x == y，那么两块石头都会被完全粉碎；
     * 如果  x != y，那么重量为  x  的石头将会完全粉碎，而重量为  y  的石头新重量为  y-x。
     * 最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回 0。
     *
     * 输入：[2,7,4,1,8,1]
     * 输出：1
     * 解释：
     * 先选出 7 和 8，得到 1，所以数组转换为 [2,4,1,1,1]，
     * 再选出 2 和 4，得到 2，所以数组转换为 [2,1,1,1]，
     * 接着是 2 和 1，得到 1，所以数组转换为 [1,1,1]，
     * 最后选出 1 和 1，得到 0，最终数组转换为 [1]，这就是最后剩下那块石头的重量。
     *
     * 解法1：转换链表依次取出判断 比较慢 2ms 固定思维从前到后取有点笨
     * 解法2：利用sort升序排列 不断排序并从后取出石头进行比较 0ms
     * 解法3：官方解法 利用优先级队列 利用最大堆来实现 2ms
     *
     */

    public static void main(String[] args) {
        int[] stones = {2,7,4,1,8,1};
        System.out.println(lastStoneWeight(stones));
    }

    //解法3：
    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> b - a);
        for (int stone : stones) {
            pq.offer(stone);
        }

        while (pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();
            if (a > b) {
                pq.offer(a - b);
            }
        }
        return pq.isEmpty() ? 0 : pq.poll();
    }

//    //解法2：
//    public static int lastStoneWeight(int[] stones) {
//        Arrays.sort(stones);
//        int len = stones.length - 1;
//        for (int i = len; i > 0; i--) {
//            stones[len] = stones[len] - stones[len - 1];
//            stones[len - 1] = 0;
//            Arrays.sort(stones);
//        }
//        return stones[len];
//    }

    //解法1：
//    static class ListNode {
//        private int val;
//        private ListNode next;
//
//        public ListNode(int x) { val = x; }
//    }
//
//    public static int lastStoneWeight(int[] stones) {
//        int len = stones.length;
//        Integer newStones[] = new Integer [len];
//        for(int i = 0; i < len; i++){//转换数组类型
//            newStones[i]= new Integer(stones[i]);
//        }
//        Arrays.sort(newStones, Collections.reverseOrder());//降序排序
//        ListNode head = Array2LinkList(newStones);//转换成链表
////        while(head != null){
////            System.out.print(head.val + " ");
////            head = head.next;
////        }
//        while(head != null && head.next != null){
//            int firstStone = head.val;
//            int secondStone = head.next.val;//取出两块石头
//            head = head.next;//先只往后一颗石头 防止剩余石头过大 需要放在链表首部
//            if(firstStone == secondStone){//两块石头一样大 不需要将剩余石头插入链表 直接进到下一轮取第3块石头
//                head = head.next;
//            }
//            else{
//                ListNode leftoverStone = new ListNode(firstStone - secondStone);
//                if(head.next == null){//两块不一样的石头粉碎后 链表中仅仅剩下一块石头 不需要执行插入 直接返回
//                    return leftoverStone.val;
//                }
//                int newheadVal = head.next.val;//取出第3块石头的值
//                if(leftoverStone.val >= newheadVal){//新石头大过/等于第3块石头 新石头放在链表首部
//                    leftoverStone.next = head.next;
//                    head = leftoverStone;
//                }
//                else{//否则需要将新石头插入链表合适位置
//                    head = head.next;//设定新的头部为第三块石头
//                    ListNode flag = head;
//                    boolean success = false;
//                    while(flag.next != null){
//                        if(leftoverStone.val >= flag.next.val){
//                            leftoverStone.next = flag.next;
//                            flag.next = leftoverStone;
//                            success = true;
//                            break;
//                        }
//                        flag = flag.next;
//                    }
//                    if(!success){//未插入 则放在链表尾部
//                        flag.next = leftoverStone;
//                    }
//                }
//            }
//        }
//        if(head != null){//while中断情况1：剩下一块石头
//            return head.val;
//        }
//        return 0;//while中断情况2：不剩下石头
//    }
//
//    public static ListNode Array2LinkList(Integer[] stones){//数组转换链表 返回链表表头
//        ListNode listNode = new ListNode(stones[0]);
//        ListNode head = listNode;
//        for (int i = 1; i < stones.length; i++) {
//            ListNode next = new ListNode(stones[i]);
//            listNode.next = next;
//            listNode = next;
//        }
//        return head;
//    }
}
