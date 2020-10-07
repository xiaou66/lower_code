package com.xiaou.leetcode.lc.string;

import org.junit.Test;

import java.util.Arrays;

/**
 * @url https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnhbqj/
 * @author xiaou
 */
public class LcReverseStringTest {
    public void reverseString(char[] s) {
        char temp;
        for (int i = 0, j = s.length - 1; i < j; i ++, j--) {
            temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }
        System.out.println(Arrays.toString(s));
    }
    @Test
    public void test() {
        char[] chars = {'1', '2', '3', '4'};
        reverseString(chars);
    }
}
