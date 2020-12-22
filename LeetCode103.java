package com.LY.LeetCode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class LeetCode103 {

    static class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int x) { val = x; }
    }

    //二叉树的锯齿形层序遍历
    public static void main(String[] args) {
        int[] treeval = {3,9,20,-1,-1,15,7};
        TreeNode treeNode = buildTree(treeval);
        //System.out.println(treeNode.getVal());
        //inOrder1(treeNode);
        System.out.println(zigzagLevelOrder(treeNode));
    }

    //二叉树的中序遍历
    public static void inOrder1(TreeNode root)      //递归中序遍历
    {
        if(root != null)
        {
            inOrder1(root.left);
            System.out.print(root.val + " ");
            inOrder1(root.right);
        }
    }


    //建立二叉树
    public static TreeNode buildTree(int[] treeval) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        int len = treeval.length;
        TreeNode treeNode = new TreeNode(treeval[0]);
        queue.add(treeNode);
        int i = 1;
        while(i < len){
            TreeNode temp = queue.remove();
            if(treeval[i] != -1){
                TreeNode left = new TreeNode(treeval[i]);
                temp.left = left;
                queue.add(left);
            }
            i++;
            if(treeval[i] != -1){
                TreeNode right = new TreeNode(treeval[i]);
                temp.right = right;
                queue.add(right);
            }
            i++;
        }
        return treeNode;
    }

    //二叉树的锯齿形层序遍历 双栈实现
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        LinkedList<List<Integer>> ret = new LinkedList<List<Integer>>();
        if(root == null){
            return ret;
        }

        Stack<TreeNode> stack1 = new Stack<>();
        stack1.push(root);//根结点压栈
        Stack<TreeNode> stack2 = new Stack<>();

        while (!stack1.isEmpty() || !stack2.isEmpty()){
            LinkedList<Integer> integers = new LinkedList<>();

            if(stack2.isEmpty()){//如果2栈为空
                while(!stack1.isEmpty()){//把1栈的都弹出
                    TreeNode pop = stack1.pop();//弹栈
                    integers.add(pop.val);//加入队列
                    if(pop.left != null){//先左后右
                        stack2.push(pop.left);
                    }
                    if(pop.right != null){
                        stack2.push(pop.right);
                    }
                }
            }
            else{//如果1栈为空
                while(!stack2.isEmpty()){//把2栈的都弹出
                    TreeNode pop = stack2.pop();//弹栈
                    integers.add(pop.val);//加入队列中
                    if(pop.right != null){//先右后左
                        stack1.push(pop.right);
                    }
                    if(pop.left != null){
                        stack1.push(pop.left);
                    }
                }
            }
            ret.add(integers);
        }
        return ret;
    }
}
