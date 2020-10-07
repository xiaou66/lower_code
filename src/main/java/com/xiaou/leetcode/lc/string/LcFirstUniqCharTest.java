package com.xiaou.leetcode.lc.string;

import org.junit.Test;

import java.util.HashMap;

/**
 * @url https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xn5z8r/
 * @author xiaou
 */
public class LcFirstUniqCharTest {
    public int firstUniqChar(String s) {
        byte[] bytes = s.getBytes();
        for (int i = 0; i < bytes.length; i++) {
            boolean fig = false;
            for (int j = 0; j < bytes.length; j++) {
                if (bytes[i] == bytes[j] && i != j) {
                    fig = true;
                    break;
                }
            }
            if (!fig) {
                return i;
            }
        }
        return -1;
    }
    @Test
    public void test() {
        System.out.println(firstUniqChar("cc"));
    }
}
