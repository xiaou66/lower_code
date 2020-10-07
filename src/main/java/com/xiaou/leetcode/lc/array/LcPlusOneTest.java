package com.xiaou.leetcode.lc.array;

import org.junit.Test;

import java.util.Arrays;

/**
 * @url https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2cv1c/
 * @author xiaou
 */
public class LcPlusOneTest {
    @Test
    public void Test() {
        int [] nums = {9,9};
        System.out.println(Arrays.toString(plusOne2(nums)));
    }
    public int[] plusOne2(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--){
            digits[i]++;
            digits[i] %= 10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
    public int[] plusOne(int[] digits) {
        // 位数
        int w = digits.length - 1;
        // 进位
        while (w >= 0) {
            digits[w] ++;
            if (digits[w] < 10) {
                break;
            }
            w--;
            if (w >= 0) {
                digits[w + 1] = 0;
            }
        }
        if (digits[0] < 10) {
            return digits;
        }else {
            digits[0] = 0;
        }
        int[] newDigits = new int[digits.length + 1];
        for (int i = 1; i < digits.length; i++){
            newDigits[i] = digits[i - 1];
        }
        newDigits[0] = 1;
        return newDigits;
    }

}
