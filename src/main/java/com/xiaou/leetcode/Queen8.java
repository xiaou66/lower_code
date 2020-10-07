package com.xiaou.leetcode;

import java.util.Map;

/**'
 * 八皇后问题
 * 递归
 * @author xiaou
 */
public class Queen8 {
    /**
     * 皇后数量
     */
    private final static int MAX = 8;
    private static int [] result = new int[MAX];
    private static int count = 0;
    public static void main(String[] args) {
        check(0);
        System.out.printf("一共%d种", count);
    }

    /**
     * 放置第 n 个皇后
     * @param n 放置第 n 个皇后
     * @return boolean
     */
    private static void check(int n) {
        if (n == MAX) {
            // 当放完最后一个皇后
            print();
            count ++;
            return;
        }
        // 开始放皇后
        for (int i = 0; i < MAX; i++) {
            // 先把当前这个皇后 n, 放置到该行的第一列
            result[n] = i;
            // 放置第 n 个皇后 到 i 列 是否冲突
            if(judge(n)) {
                check(n + 1);
            }
            // 如果冲突, 就继续执行 array[n] = i;即将第n个皇后, 放置到本行的后移个位置
        }

    }
    /**
     *
     * @param n 表示放第 n 个皇后
     * @return
     */
    public static boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            // 判断是否在同一列或者是否在同一斜线上
            // 斜线根据 斜率来算 tan PI/4
            if(result[i] == result[n] || Math.abs(n - i) == Math.abs(result[n] - result[i])) {
                return false;
            }
        }
        return true;
    }

    /**
     * 打印
     */
    private static void print() {
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.println();
    }
}
