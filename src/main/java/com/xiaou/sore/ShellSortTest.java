package com.xiaou.sore;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

/**
 * 希尔排序
 * @author xiaou
 */
public class ShellSortTest {
    private int [] numbers;
    @Before
    public void before() {
        numbers = new int[]{ 0,12,10,18,8,9,1};;
    }

    /**
     *  交换
     */
    @Test
    public void shellSortSwap() {
        // 对当前数组进行分组 gap 增量
        for (int gap = numbers.length / 2; gap > 0 ; gap /= 2) {
            // 对当前所分的组进行依次循环比较
            for (int i = gap; i < numbers.length; i++) {
                for (int j = i - gap; j >= 0; j -= gap) {
                    // 比较当前数与对应分组的数比较大小
                    if(numbers[j] > numbers[j + gap]) {
                        int temp = numbers[j];
                        numbers[j] = numbers[j + gap];
                        numbers[j + gap] = temp;
                    }
                }
                
            }
            System.out.println(Arrays.toString(numbers));
        }
    }

    /**
     * 移动
     * 插入法
     */
    @Test
    public void shellSortMove() {
        // 对当前数组进行分组 gap 增量
        for (int gap = numbers.length / 2; gap > 0 ; gap /= 2) {
            // 从 gap 元素开始逐个对其所在组直接进行插入排序
            for (int i = gap; i < numbers.length; i++) {
                int j = i;
                int temp = numbers[i];
                while (j - gap >= 0 && temp < numbers[ j - gap ]) {
                    // 元素向后移动找到插入位置
                    numbers[j] = numbers[j-gap];
                    j-= gap;
                }
                if (i != j) {
                    // 插入
                    numbers[j] = temp;
                }
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
