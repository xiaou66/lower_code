package com.xiaou.leetcode;

import org.junit.Test;

/**
 * @url https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
 * @author xiaou
 */
public class T4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int [] nums = new int[nums1.length + nums2.length];
        int i = 0;
        for (int j = 0; j < nums1.length; j++){
            nums[i++] = nums1[j];
        }
        for (int j = 0; j < nums2.length; j++){
            nums[i++] = nums2[j];
        }
        if (nums.length % 2 == 0){
            int num1Index = nums.length / 2;
            int num2Index = num1Index + 1;
            return nums[num1Index + num2Index];
        }else {
            return nums[Math.round(nums.length / 2)];
        }
    }
    @Test
    public void test(){
        int [] nums1 = new int[]{1, 3};
        int [] nums2 = new int[]{2};
        System.out.println(findMedianSortedArrays(nums1, nums2));

    }
}
