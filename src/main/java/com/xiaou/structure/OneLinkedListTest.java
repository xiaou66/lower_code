package com.xiaou.structure;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author xiaou
 */
public class OneLinkedListTest {
    private OneLinkedList<String> oneLinkedList;
    @Before
    public void before() {
        oneLinkedList = new OneLinkedList<String>();
        oneLinkedList.add("666");
        oneLinkedList.add("662");
        oneLinkedList.add("661");
    }
    @Test
    public void add() {
        oneLinkedList.insert("663", 3);
        System.out.println("size：" + oneLinkedList.size());
        System.out.println("删除前");
        System.out.println(oneLinkedList);
        System.out.println("删除后");
        oneLinkedList.reverse();
        System.out.println(oneLinkedList);
    }
    @Test
    public void spliceTest() {
        OneLinkedList<String> stringOneLinkedList = new OneLinkedList<String>();
        stringOneLinkedList.add("663");
        stringOneLinkedList.add("668");
        stringOneLinkedList.add("669");
        oneLinkedList.splice(stringOneLinkedList);
        System.out.println(oneLinkedList);
    }
}
