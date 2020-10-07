package com.xiaou.leetcode;

import org.junit.Test;

/**
 * @author xiaou
 */
public class T10 {
    @Test
    public void test(){
        System.out.println(isPalindrome(121));
        // System.out.println(isPalindrome(321123));
    }
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int div = 1;
        // 计算最高位
        while (x / div >= 10) {
            div *= 10;
        }
        while (x > 0) {
            // 取出左边的数字
            int left = x / div;
            // 取出右边的数字
            int right = x % 10;
            if (left != right) {
                return false;
            }

            x = (x % div) / 10;
            div /= 100;
        }
        return true;
    }
}
