package com.xiaou.leetcode.lc.array;

import org.junit.Test;

import java.util.Arrays;

/**
 * @url https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2skh7/
 * @author xiaou
 */
public class LcRotateTest {
    public void rotate(int[] nums, int k) {
        while (k > 0) {
            int lastNum = nums[nums.length - 1];
            for (int i = nums.length - 1; i > 0; i--){
                nums[i] = nums[i - 1];
            }
            nums[0] = lastNum;
            k--;
        }
        System.out.println(Arrays.toString(nums));
    }
    @Test
    public void test() {
        int [] a = {1,2,3,4,5,6,7};
        rotate(a,3);
    }
}
