package com.xiaou.sore;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 选择排序
 * @author xiaou
 */
public class SelectSortTest {
    private int [] numbers;
    @Before
    public void before() {
        numbers = new int[]{ 0,12,10,18,8,9,1};;
    }
    @Test
    public void selectSort() {
        for (int i = 0; i < numbers.length - 1; i++) {
            int minIndex = i;
            int min = numbers[i];
            // 跟后面数进行比较
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[j] < min) {
                    minIndex = j;
                    min = numbers[j];
                }
            }
            if (minIndex != i) {
                // 与查找到的最小值交换位置
                numbers[minIndex] = numbers[i];
                numbers[i] = min;
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
