package com.LY.LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode399 {
    /**
     * 1/6 除法求值
     * 给你一个变量对数组 equations 和一个实数值数组 values 作为已知条件，其中 equations[i] = [Ai, Bi] 和 values[i]
     * 共同表示等式 Ai / Bi = values[i] 。每个 Ai 或 Bi 是一个表示单个变量的字符串。
     *
     * 另有一些以数组 queries 表示的问题，其中 queries[j] = [Cj, Dj] 表示第 j 个问题，
     * 请你根据已知条件找出 Cj / Dj = ? 的结果作为答案。
     *
     * 返回 所有问题的答案 。如果存在某个无法确定的答案，则用 -1.0 替代这个答案。
     *
     * 输入：equations = [["a","b"],["b","c"]], values = [2.0,3.0],
     *      queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
     * 输出：[6.00000,0.50000,-1.00000,1.00000,-1.00000]
     * 解释：
     * 条件：a / b = 2.0, b / c = 3.0
     * 问题：a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
     * 结果：[6.0, 0.5, -1.0, 1.0, -1.0 ]
     */

    public static void main(String[] args) {
        List<List<String>> equations = new ArrayList<List<String>>();
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("a");
        list1.add("b");
        ArrayList<String> list2 = new ArrayList<>();
        list1.add("b");
        list1.add("c");
        equations.add(list1);
        equations.add(list2);

        double[] values = {2.0,3.0};

        List<List<String>> queries = new ArrayList<List<String>>();
        ArrayList<String> list3 = new ArrayList<>();
        list1.add("a");
        list1.add("c");
        ArrayList<String> list4 = new ArrayList<>();
        list1.add("b");
        list1.add("a");
        ArrayList<String> list5 = new ArrayList<>();
        list1.add("a");
        list1.add("e");
        ArrayList<String> list6 = new ArrayList<>();
        list1.add("a");
        list1.add("a");
        ArrayList<String> list7 = new ArrayList<>();
        list1.add("x");
        list1.add("x");
        queries.add(list3);
        queries.add(list4);
        queries.add(list5);
        queries.add(list6);
        queries.add(list7);

        double[] ret = calcEquation(equations,values,queries);
        for (double v : ret) {
            System.out.print(v + " ");
        }
    }
    //大佬的解法
    public static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int count=0;//统计出现的所有字符，并赋予对应的index
        Map<String,Integer> map=new HashMap<>();
        for (List<String> list:equations){//遍历equations
            for (String s:list){//遍历每个字母
                if(!map.containsKey(s)){//如果图中不存在则加入，同时计数器++
                    map.put(s,count++);
                }
            }
        }
        /**
         * a = 0,b = 1,c = 2
         */

        //构建一个矩阵来代替图结构
        double[][] graph=new double[count+1][count+1];

        //初始化
        for (String s:map.keySet()){
            int x=map.get(s);//获取每个字母对应的编号
            graph[x][x]=1.0;//将该对角线位置置为1 a/a = 1 -> (0,0) = 1
        }
        int index=0;
        for (List<String> list:equations){//将给定的条件放入数组中
            String a=list.get(0);//取出a
            String b=list.get(1);//取出b
            int aa=map.get(a);//获取a的下标aa
            int bb=map.get(b);//获取b的小标bb
            double value=values[index++];//获取value数组内的给定条件
            graph[aa][bb]=value;//置入数组矩阵
            graph[bb][aa]=1/value;
        }

        /**
         * 此时的矩阵结构：此时没有a->c的对应条件 因此a->c无关系
         *   a     b     c
         * a 1     2
         *
         * b 1/2   1     3
         *
         * c       1/3   1
         */

        //通过Floyd算法进行运算
        int n=count+1;
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                for (int k=0;k<n;k++){
                    if(j==k||graph[j][k]!=0) continue;//寻找为0的坐标位置
                    if(graph[j][i]!=0&&graph[i][k]!=0){
                        graph[j][k]=graph[j][i]*graph[i][k];//计算得出结果
                    }
                }
            }
        }

        /**
         * 此时的矩阵结构：
         *   a     b     c
         * a 1     2     6
         *
         * b 1/2   1     3
         *
         * c 1/6   1/3   1
         */

        //直接通过查询矩阵得到答案
        int len  = queries.size();
        double[] res=new double[len];
        for (int i=0;i<len;i++){
            List<String> q=queries.get(i);
            String a=q.get(0);
            String b=q.get(1);//获取2个请求的字母
            if(map.containsKey(a)&&map.containsKey(b)){//如果均存在
                double ans=graph[map.get(a)][map.get(b)];//取出答案
                res[i]=(ans==0?-1.0:ans);//若仍然为0 比如：a->b c->d 但是a->C无关系 则仍然为0 此时返回-1
            }else {//不存在直接-1 a/e = -1 x/x = -1
                res[i]=-1.0;
            }
        }
        return res;
    }
}
