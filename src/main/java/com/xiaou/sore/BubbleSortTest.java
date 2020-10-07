package com.xiaou.sore;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * 1. 一共进行 数据大小 - 1 次排序
 * 2. 每一趟排序的次数在逐渐减少
 * 3. 如果在某一趟中未发生一次交换就可以提前结束排序
 * 4. 时间复杂度 O(n^2)
 * @author xiaou
 */
public class BubbleSortTest {
    private int [] numbers;
    @Before
    public void before() {
        numbers = new int[]{ 0,12,10,18,8,9,1};;
    }
    @Test
    public void sort() {
        for (int i = 0; i < numbers.length - 1; i++) {
            boolean fig = true;
            for (int j = 0; j < numbers.length - i - 1; j++) {
               if (numbers[j] > numbers[j + 1]) {
                   int temp = numbers[j + 1];
                   numbers[j + 1] = numbers[j];
                   numbers[j] = temp;
                   fig = false;
               }
            }
            if (fig) {
                // 未发生一次交换就可以提前结束排序
                break;
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
