package com.LY.LeetCode;

public class LeetCode86 {
    /**
     * 1/3 分隔链表
     * 给你一个链表和一个特定值 x ，请你对链表进行分隔，使得所有小于 x 的节点都出现在大于或等于 x 的节点之前。
     *
     * 你应当保留两个分区中每个节点的初始相对位置。
     * 输入：head = 1->4->3->2->5->2, x = 3
     * 输出：1->2->2->4->3->5
     */

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(4);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(2);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(2);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next = null;
        ListNode listNode = partition(listNode1,3);
        while(listNode != null){
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }

    public static ListNode partition(ListNode head, int x) {
        ListNode low = new ListNode(0);
        ListNode high = new ListNode(0);
        ListNode head_low = low;
        ListNode head_high = high;

        while(head != null){
            ListNode temp = head;
            head = head.next;
            if(temp.val >= x){
                high.next = temp;
                high = high.next;
                high.next = null;
            }
            else{
                low.next = temp;
                low = low.next;
                low.next = null;
            }
        }
        low.next = head_high.next;
        return head_low.next;
    }
}
