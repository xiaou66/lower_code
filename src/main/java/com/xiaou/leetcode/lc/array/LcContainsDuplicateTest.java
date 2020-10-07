package com.xiaou.leetcode.lc.array;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @url https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x248f5/
 * @author xiaou
 */
public class LcContainsDuplicateTest {
    @Test
    public void test() {
        int [] nums = {1,2,3,4};
        System.out.println(containsDuplicate2(nums));
    }
    public boolean containsDuplicate2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i+1]) {
                return true;
            }
        }
        return false;
    }
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> integers = new HashSet<Integer>();
        for (int i : nums) {
            integers.add(i);
        }
        return nums.length != integers.size();
    }
}
