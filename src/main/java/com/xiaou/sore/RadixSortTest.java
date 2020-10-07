package com.xiaou.sore;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

/**
 * 基数排序
 * @author xiaou
 */
public class RadixSortTest {
    private int [] numbers;
    @Before
    public void before() {
        numbers = new int[]{ 0, 12, 10, 216, 18, 8, 9, 1, -1, -99};;
    }
    @Test
    public void radixSort() {
        int max = numbers[0];
        int min = numbers[0];
        boolean fig = false;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
            if (numbers[i] < min) {
                min = numbers[i];
            }
        }
        if (min <= 0) {
            // 负数处理
            fig = true;
            for (int i = 0; i < numbers.length; i++) {
                numbers[i] += Math.abs(min);
            }
        }
        int maxLength = (max + "").length();
        // 创建桶
        int [][] bucket = new int[10][numbers.length];
        // 创建每个桶的实际元素最后一个下标指向
        int [] bucketIndex = new int[10];
        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            for (int j = 0; j < numbers.length; j++) {
                // 取出位数
                int digit = numbers[j] / n % 10;
                // bucket[digit][bucketIndex[digit]++] = numbers[j];
                bucket[digit][bucketIndex[digit]] = numbers[j];
                // 当前桶下移
               bucketIndex[digit]++;
            }
            // 遍历每一个桶, 并将桶中的数据依次取出 (先进先出)
            // 然后放入原始数组
            int index = 0;
            for (int k = 0; k < bucketIndex.length; k++) {
                if (bucketIndex[k] == 0) {
                    // 这个桶内如果没有数据则跳过
                    continue;
                }
                for (int j = 0; j < bucketIndex[k]; j++) {
                    numbers[index++] = bucket[k][j];
                }
            }
            // 清空桶的下标
            Arrays.fill(bucketIndex, 0);
        }
        // 负数处理
        if (fig) {
            for (int i = 0; i < numbers.length; i++) {
                numbers[i] -= Math.abs(min);
            }
        }

    }
    @After
    public void after() {
        for (int i = 0; i < numbers.length; i++) {
            System.out.printf("%d\t", numbers[i]);
        }
    }
}
