package com.xiaou.sore;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import sun.security.util.Length;

/**
 * 堆排序
 * 1. 将待排序序列造成一个大顶堆
 * 2. 此时，整个序列的最大值就是堆顶的根节点
 * 3. 将其与末尾元素进行交换，此时, 整个序列的最大值就是堆顶的根节点
 * 4. 然后将剩余 n-1 个元素重新构造成一个堆，这样会得到 n 个元素的次小值。如此反复执行，使能得到一个有序系列
 * @author xiaou
 */
public class HeapSortTest {
    private int [] array;
    @Before
    public void init (){
        this.array =  new int[]{12,0,10,18,8,9,1};
    }
    @Test
    public void heapSortTest() {
        heapSort();

    }
    private void heapSort() {
        // 从第一个非叶子节点开始进行调整 arr.length / 2 - 1
        // 从 左->右 上->下
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            // 建立完全二叉树
            adjustHeap(array, i, array.length);
        }
        // 将堆顶元素与末尾元素交换，将最大元素"沉"到数组末端;
        // 再重新进行调整
        for (int i = array.length - 1; i > 0; i--) {
            // 交换
            int temp = array[i];
            array[i] = array[0];
            array[0] = temp;
            adjustHeap(array, 0, i);
        }
    }
    /**
     * 以 i
     * @param arr 待调整的数组
     * @param i 非叶子节点的索引
     * @param length 表示对多少个元素进行调整，length 在一步一步调整在逐渐减少
     */
    private void adjustHeap(int arr [], int i, int length) {
        int temp = arr[i];
        // 调整
        for (int k = i * 2+1; k < length; k= k * 2 + 1) {
            // 左子节点的值小于右子节点的值
            if (k + 1 < length && arr[k] < array[k+1]) {
                k++;
            }
            if (arr[k] > temp) {
                // 把较大的值赋给当前节点
                arr[i] = arr[k];
                // i 指向 k
                i=k;
            }else {
                break;
            }
        }
        // 当 for 循环结束后,我们已经将 i 为父节点的最大值放在了最顶部
        // 将 emp 放到调整后的位置
        arr[i] = temp;
    }
    @After
    public void after() {
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%d\t", array[i]);
        }
    }
}
