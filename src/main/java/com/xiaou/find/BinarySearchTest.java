package com.xiaou.find;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 二分查找法
 * 待查找数组必须有序
 * 默认 数组可以按从小到大已经排序好了
 * @author xiaou
 */
public class BinarySearchTest {
    private int [] numbers;
    @Before
    public void before() {
        numbers = new int[]{ 0,1,8,9,10,12,12,18,20};;
    }
    @Test
    public void sore() {
        System.out.println(binarySearch(numbers, 0 , numbers.length -1, 222));
        System.out.println(binarySearchMore(numbers,0 , numbers.length -1, 12));
        System.out.println(insertValueSearch(numbers,0 , numbers.length -1, 12));
    }

    /**
     * 二分查找 单个数字
     * @param arr 待查找数字
     * @param left 左边索引
     * @param right 右边索引
     * @param findVal 查找值
     * @return
     */
    private int binarySearch(int [] arr, int left, int right, int findVal) {
        if (right < left) {
            // 未找到数据
            return -1;
        }
        // 取中间值的下标
        int middle = (right + left) / 2;
        // 取中间值
        int middleValue = arr[middle];
        if (findVal > middleValue) {
            // 如果中间的数字比查找的数据小的话就向右递归
            return binarySearch(arr, middle + 1, right, findVal);
        } else if (findVal < middleValue){
            // 如果中间的数字比查找的数据大的话就向左递归
            return binarySearch(arr, left, middle - 1, findVal);
        }else {
            // 返回值
            return middle;
        }
    }
    /**
     * 差值查找 单个数字
     * @param arr 待查找数字
     * @param left 左边索引
     * @param right 右边索引
     * @param findVal 查找值
     * @return
     */
    private int insertValueSearch(int [] arr, int left, int right, int findVal) {
        if (right < left) {
            // 未找到数据
            return -1;
        }
        // 取中间值的下标
        int middle = left + (findVal - arr[left]) / (arr[right] - arr[left]) * (right - left);
        // 取中间值
        int middleValue = arr[middle];
        if (findVal > middleValue) {
            // 如果中间的数字比查找的数据小的话就向右递归
            return insertValueSearch(arr, middle + 1, right, findVal);
        } else if (findVal < middleValue){
            // 如果中间的数字比查找的数据大的话就向左递归
            return insertValueSearch(arr, left, middle - 1, findVal);
        }else {
            // 返回值
            return middle;
        }
    }
    /**
     * 二分查找 多个数字
     * @param arr 待查找数字
     * @param left 左边索引
     * @param right 右边索引
     * @param findVal 查找值
     * @return
     */
    private List<Integer> binarySearchMore(int [] arr, int left, int right, int findVal) {
        if (right < left) {
            return null;
        }
        int middle = (right + left) / 2;
        int middleValue = arr[middle];
        if (findVal > middleValue) {
            return binarySearchMore(arr, middle + 1, right, findVal);
        } else if (findVal < middleValue){
            return binarySearchMore(arr, left, middle - 1, findVal);
        }else {
            List<Integer> num = new ArrayList<Integer>();
            int temp = middle;
            // 因为数组是有序的所以使用查找数组周围相同的数据比较是否是同一个数据
            while (true) {
                if (numbers[temp] != middleValue) {
                    break;
                }
                num.add(temp--);
            }
            while (true) {
                if (numbers[temp] != middleValue) {
                    break;
                }
                num.add(temp++);
            }
            return num;
        }
    }
    @After
    public void after() {
        for (int i = 0; i < numbers.length; i++) {
            System.out.printf("%d\t", numbers[i]);
        }
    }
}
