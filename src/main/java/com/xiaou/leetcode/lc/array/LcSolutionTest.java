package com.xiaou.leetcode.lc.array;

import org.junit.Test;

import java.util.Arrays;

/**
 * @url https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2jrse/
 * @author xiaou
 */
public class LcSolutionTest {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int [] {i, j};
                }
            }
        }
        return new int[]{};
    }
    @Test
    public void test() {
        int[] nums = {3,2,4};
        int target = 6;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }
}
