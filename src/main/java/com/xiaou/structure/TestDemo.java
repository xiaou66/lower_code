package com.xiaou.structure;

import org.junit.Test;


/**
 * @author xiaou
 */
public class TestDemo {
    @Test
    public void queueTest(){
        Queue queue = new Queue(4);
        queue.push("1");
        queue.push("2");
        queue.push("3");
        System.out.println(queue.size());
        queue.get();
        System.out.println(queue.peek());
        queue.push("ww");
        System.out.println(queue.toString());
        System.out.println(queue.size());
    }
    @Test
    public void linkedListDemo() {
        LinkedList linkedList = new LinkedList();
        linkedList.push("1");
        linkedList.push("2");
        linkedList.push("3");
        System.out.println(linkedList.toString());
    }
}
