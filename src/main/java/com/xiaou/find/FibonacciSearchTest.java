package com.xiaou.find;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;


/**
 * 斐波那契查找
 * @author xiaou
 */
public class FibonacciSearchTest {
    private int [] numbers;
    private int maxSize = 20;
    @Before
    public void before() {
        numbers = new int[]{ 0,1,8,9,10,12,18,20};;
    }

    /**
     * 斐波那契数列
     * @return 返回斐波那契数列
     */
    public int[] fib() {
        int [] f = new int[maxSize];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < maxSize; i++) {
            f[i] = f[i-1] + f[i-2];
        }
        return f;
    }
    @Test
    public void fibonacciSearchTest() {
        System.out.println(fibonacciSearch(numbers, 10));
    }
    /**
     *
     * @param arr 待查找数组
     * @param key 待查找值
     * @return 返回对应下标，没有则返回 -1
     */
    public int fibonacciSearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length -1;
        int mid;
        // 斐波那契分割数值的下标
        int k = 0;
        // 获取斐波那契数列
        int [] f = fib();
        // 获取到斐波那契数列分割的下标
        while (high > f[k] - 1) {
            k++;
        }
        // 因为发 f[k] 可能大于数值长度, 因此我们需要使用 Arrays 类构造一个新的数组并且指向 a
        int [] temp = Arrays.copyOf(arr, f[k]);
        // 使用a数组最后的数进行填充 temp
        for (int i = high + 1; i < temp.length; i++) {
            temp[i] = arr[high];
        }
        // 开始查询 key
        while (low <= high) {
            mid = low + f[k-1] -1;
            if (key < temp[mid]) {
                // 向数组的左边查找
                high = mid - 1;
                // 1. 全部元素 = 前面元素 + 后面元素
                // 2. f[k] = f[k-1] + f[l-2]
                // 因为前面有 f[k-1] 个元素,所以我们可以继续拆分 f[k-1] = f[k-2] + f[k-3]
                // 在 f[k-1] 的前面继续查找 k--
                k--;
            }else if (key > temp[mid]) {
                // 向数组的右边查找
                low = mid + 1;
                // 1. 全部元素 = 前面元素 + 后面元素
                // 2. f[k] = f[k-1] + f[l-2]
                // 因为后面有 f[k-2] 个元素 所以可以继续拆分 f[k-1] = f[k-3] + f[k-4]
                // 在 f[k-2] 的前面进行查找 k-=2
                // mid = f[k-1-2] -1
                k -= 2;
            } else {
                //  返回小的下标
               if (mid <= high) {
                   return mid;
               }else {
                   return high;
               }
            }

        }
        return -1;
    }
    @After
    public void after() {
        for (int i = 0; i < numbers.length; i++) {
            System.out.printf("%d\t", numbers[i]);
        }
    }
}
