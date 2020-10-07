package com.xiaou.leetcode.lc.array;

import org.junit.Test;

import java.util.Arrays;

/**
 * @url https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2ba4i/
 * @author xiaou
 */
public class LcMoveZeroesTest {
    @Test
    public void test() {
        int [] nums = {0,0,1};
        System.out.println(Arrays.toString(moveZeroes(nums)));
    }
    public int[] moveZeroes(int[] nums) {
        int last = nums.length - 1;
        for(int i = 0; i <= last; i ++) {
            if (nums[i] == 0) {
                // 发现
                for (int j = i; j < last; j ++) {
                    nums[j] = nums[j + 1];
                }
                nums[last--] = 0;
                i--;
            }
        }
        return nums;
    }
}
