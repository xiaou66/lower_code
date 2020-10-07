package com.xiaou.sore;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 归并排序
 * @author xiaou
 */
public class MergerSortTest {
    private int [] numbers;
    @Before
    public void before() {
        numbers = new int[]{ 0,12,10,18,8,9,1};;
    }
    @Test
    public void mergerSort() {
        int [] temp = new int[numbers.length];
        divide(numbers, 0, numbers.length -1, temp);
    }
    private void divide(int[] arr, int left, int right, int [] temp) {
        if (left < right) {
            // 中间索引
            int middle = (left + right) / 2;
            // 向左边递归
            divide(arr, left, middle, temp);
            divide(arr, middle + 1, right, temp);
            // 合并
            merger(arr, left, middle, right, temp);
        }
    }
    /**
     * 合并方法
     * @param arr 排序原生数组
     * @param left 左边有序数列的初始索引
     * @param middle 中间索引
     * @param right 右边索引
     * @param temp 临时数组
     */
    private void merger(int [] arr, int left,int middle,  int right, int [] temp) {
        // 左边有序数列的索引
        int i = left;
        // 右边有序数列的索引
        int j = middle + 1;
        // 临时数组的当前索引
        int t = 0;
        while (i <= middle && j <= right) {
            // 先把左右两边的数据按规则填充到 temp 数组
            // 直到左右两边, 有一边处理完成为止
            if (arr[i] <= arr[j]) {
                // 左边的有序数组的当前元素, 小于右边的有序数组的当前元素
                // 进行将左边的当前元素加入到临时数组
                // temp[t++] = arr[i++];
                temp[t] = arr[i];
                // 移动下标
                t++;
                i++;
            } else {
                // 与上面相反
                temp[t] = arr[j];
                // 移动下标
                t++;
                j++;
            }
        }
        // 将剩余数据的一边的数据依次全部填充到 temp 数组
        while (i <= middle) {
            // 左边的还有剩余
            temp[t++] = arr[i++];
        }
        while (j <= right) {
            // 右边的还有剩余
            temp[t++] = arr[j++];
        }
        // 将 temp 数组元素拷贝到 arr 中
        t = 0;
        int tempLeft = left;
        while (tempLeft <= right) {
            arr[tempLeft++] = temp[t++];
        }
    }
    @After
    public void after() {
        for (int i = 0; i < numbers.length; i++) {
            System.out.printf("%d\t", numbers[i]);
        }
    }
}
