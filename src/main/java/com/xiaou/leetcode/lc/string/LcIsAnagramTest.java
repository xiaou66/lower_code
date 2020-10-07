package com.xiaou.leetcode.lc.string;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @url https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xn96us/
 * @author xiaou
 */
public class LcIsAnagramTest {
    @Test
    public void test() {
        String s = "anagram", t = "nagaram";
        System.out.println(isAnagram(s, t));
    }
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }
}
