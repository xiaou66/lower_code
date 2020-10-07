package com.xiaou.structure;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author xiaou
 */
public class Queue {
    private String [] queue;
    private int next;
    private int prev;
    private int size;
    public Queue(int size) {
       queue = new String[size];
       this.size = size;
       next = 0;
       prev = 0;
    }
    /**
     * 队列长度
     * @return 队列长度 (int)
     */
    public int size () {
        return (next - prev) + 1;
    }
    public boolean isEmpty() {
        return (next - prev) % size == 0;
    }
    public boolean isFull() {
        return (next - prev)  == size;
    }
    public String get(){
        if (isEmpty()) {
           throw new RuntimeException("队列为空");
        }
        return queue[prev++];
    }
    public void push(String item) {
        if (isFull()) {
            System.out.println("队列已满");
            return;
        }
        queue[next++] = item;
    }
    public String  peek () {
        if(isFull()) {
            throw new RuntimeException("队列为空");
        }
        return queue[prev];
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = prev; i < next; i++) {
            stringBuffer.append("index:"+i+ "\t" + "value:"+queue[i]+"\n");
        }
        return stringBuffer.toString();
    }
}
