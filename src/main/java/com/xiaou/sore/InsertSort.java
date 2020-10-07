package com.xiaou.sore;


import org.junit.Before;
import org.junit.Test;

/**
 * 插入排序
 * @author xiaou
 */
public class InsertSort {
    private int [] array;
    @Before
    public void init (){
        this.array =  new int[]{ 0,12,10,18,8,9,1};
    }
    /**
     * 普通的插入排序
     */
    @Test
    public void InsertSort(){
        int data,j;
        // i=1 因为第一个数据不用比较
        for(int i = 1; i < this.array.length ; i++){
            // 取出待比较的数据
            data = this.array[i];
            // 前一个下标
            j = i-1;
            // 整个数组向后移动 给待插入数据空间
            while (j >=0 && this.array[j] > data){
                this.array[j+1]= this.array[j];
                j--;
            }
            // 插入 比较数据
            this.array[j+1] = data;
        }
        for (int i : this.array) {
            System.out.println(i);
        }
    }
    /**
     * 折半插入排序
     */
    @Test
    public void reduceInsertSort(){
        int start,mid,end;
        for(int i = 1; i < array.length; i++){
            // 记录被比较数据
            int data = array[i];
            start = 0;
            end = i-1;
            while (start <= end ){
                // 得到中间位置
                mid = (end + start) / 2;
                // 用当前中间的位置 跟被比较数据大小
                // 并减少比较数据的范围
                if(array[mid] > data){
                    end = mid -1;
                }else{
                    start = mid +1;
                }
            }
            // 如果前面的数据有比被比较数据的小(大)时
            // 被比较数据的前面到被比较数据小(大)的数据位置往后面移动
            // 空出插入位置
            for(int j = i; j > start;j--){
                array[j] = array[j-1];
            }
            // 被比较数据插入 空出来的位置
            array[start] = data;

        }
        for (int i : array) {
            System.out.println(i);
        }
    }
    /**
     * 环形插入排序
     *  (maxIndex + 1 - array.length) % array.length 前一个位置
     *  (maxIndex + 1 + array.length) % array.length 后一个位置
     */
    @Test
    public  void insert2Road(){
        // 创建一个与原数组大小一样的数组 用于记录排序
       int [] tempArray = new int[array.length];
       // 定义一个记录最大值和最小值位置的变量
       int minIndex,maxIndex=minIndex=0;
       tempArray[0] = array[0];
       for(int i = 1; i < array.length; i++){
           if(array[i] < tempArray[minIndex]){
               // 如果待插入数据比在新数组里的最小值小
               // 代插入数据放在数组最小值的左边
               minIndex = (minIndex -1 + array.length) % array.length;
               tempArray[minIndex] = array[i];
           }else if(array[i] > tempArray[maxIndex]){
               // 如果待插入数据比在新数组里的最小值大
               // 代插入数据放在数组最小值的右边
               maxIndex = (maxIndex + 1 + array.length) % array.length;
               tempArray[maxIndex] = array[i];
           }else {
               // 待插入数据 当前新数组最大值和最小值的中间
               int k = (maxIndex + 1 + array.length) % array.length;
               while (tempArray[((k - 1) + array.length) % array.length] > array[i]){
                   tempArray[(k + array.length) % array.length] = tempArray[(k - 1 + array.length) % array.length];
                   k = (k - 1 + array.length) % array.length;
               }
               tempArray[(k + array.length) % array.length] = array[i];
               maxIndex = (maxIndex + 1 + array.length) % array.length;
           }

       }
        for (int i = 0; i < tempArray.length; i++) {
            // 通过最小值的下标开始取值 放回原来的数组
            array[i] = tempArray[(minIndex + i) % tempArray.length];
        }
        Tool.printArray(array,"排序完成>>");
    }
}
