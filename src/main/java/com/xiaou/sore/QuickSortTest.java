package com.xiaou.sore;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 快速排序
 * @author xiaou
 */
public class QuickSortTest {
    private int [] numbers;
    @Before
    public void before() {
        numbers = new int[]{ 0,12,10,18,8,9,1};
    }
    @Test
    public void sort() {
        // quickSort1(numbers, 0, numbers.length -1);
        quickSort(numbers, 0, numbers.length -1);
    }
    private void quickSort(int [] arr, int left, int right) {
        if (left >= right) {
            // 只有一个数字时,或者 两边指定已经错开
            return;
        }
        int l = left;
        int r = right;
        // 基准值
        int benchmark = arr[left];
        while (l < r) {
            // 由于一开始的基准点设置在 数组的第一个元素所以必须先 右 -> 左
            while (l < r && arr[r] > benchmark) {
                r --;
            }
            if (l < r) {
                // 制造将基准填入的位置
                arr[l++] = arr[r];
            }
            // 在 middle 的左边一直找, 找到大于 middle值, 才退出 左 -> 右
            while (l < r && arr[l] < benchmark) {
                l ++;
            }
            if (l < r) {
                // 制造将基准填入的位置
                arr[r--] = arr[l];
            }
        }
        arr[l] = benchmark;
        quickSort(arr, left, l - 1);
        quickSort(arr, l + 1, right);
    }
    private void quickSort1 (int [] arr, int left, int right) {
        if (left >= right) {
            // 只有一个数字时,或者 两边指定已经错开
            return;
        }
        // 左边
        int l = left;
        // 右边
        int r = right;
        // 中间 (基准值)
        int middle = arr[(l + r) / 2];
        while (l < r) {
            // 在 middle 的左边一直找, 找到大于 middle值, 才退出 左 -> 右
            while (l < r && arr[l] < middle) {
                l++;
            }
            // 在 middle 的右边一直找, 找到小于 middle值, 才退出  右 -> 左
            while (l < r && arr[r] > middle) {
                r--;
            }
            if (l < r) {
                // 找到
               int temp = arr[l];
               arr[l] = arr[r];
               arr[r] = temp;
            }
        }
        quickSort1(arr, left, l - 1);
        quickSort1(arr, l + 1, right);
    }
    private void quickSort2(int [] arr, int left, int right) {
        int l = left;
        int r = right;
        int middle = arr[(l + r) / 2];
        // while 循环的目的让比 middle 值小的放到左边
        // 比 middle 值大的放到右边
        while (l < r) {
            // 在 middle 的左边一直找, 找到大于 middle值, 才退出
            while (arr[l] < middle) {
                l++;
            }
            // 在 middle 的右边一直找, 找到小于 middle值, 才退出
            while (arr[r] > middle) {
                r--;
            }
            if (l >= r) {
                // 上面的循环结束表示找到了位置或者(i>=j)了，交换两个数在数组中的位置
                break;
            }
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            // 左边找完了
            if(arr[l] == middle) {
                r--;
            }
            // 右边找完了
            if (arr[r] == middle) {
                l++;
            }
            if (l == r) {
                l++;
                r--;
            }
            if (left < r) {
                quickSort1(arr, left, r);
            }
            if (right > l) {
                quickSort1(arr, l, right);
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
