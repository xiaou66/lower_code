package com.xiaou.leetcode.lc.array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * @ url https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2y0c2/
 * @author xiaou
 */
public class LcIntersectTest {
    @Test
    public void test() {
        int [] nums1 = {4,9,5};
        int [] nums2 = {9,4,9,8,4};
        System.out.println(Arrays.toString(intersect(nums1, nums2)));
    }
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int  resultIndex = 0;
        int [] result = new int[Math.min(nums2.length, nums1.length)];
        int preIndex = -1;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = preIndex + 1; j < nums2.length; j ++) {
                if (nums1[i] < nums2[j]) {
                    break;
                }
                if (nums1[i] == nums2[j]) {
                    preIndex = j;
                    result[resultIndex++] = nums1[i];
                    break;
                }
            }
        }
        int [] re = new int[resultIndex];
        for (int i = 0; i < resultIndex; i++) {
            re[i] = result[i];
        }
        return re;
    }
}
