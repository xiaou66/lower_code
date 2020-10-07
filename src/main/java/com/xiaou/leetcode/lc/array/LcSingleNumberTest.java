package com.xiaou.leetcode.lc.array;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author xiaou
 */
public class LcSingleNumberTest {
    @Test
    public void test() {
        int [] nums = {1,4,4,1,2};
        System.out.println(singleNumber(nums));
    }
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        int i = 0;
        for (;i < nums.length - 1; i += 2) {
            if (nums[i] != nums[i + 1]) {
                break;
            }
        }
        return nums[i];
    }
}
