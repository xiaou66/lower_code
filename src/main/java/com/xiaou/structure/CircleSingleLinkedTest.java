package com.xiaou.structure;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author xiaou
 */
public class CircleSingleLinkedTest {
    private CircleSingleLinked<Integer> circleSingleLinked;

    @Before
    public void before() {
        circleSingleLinked = new CircleSingleLinked<Integer>();
    }

    @Test
    public void addTest() {
        circleSingleLinked.add(1);
        circleSingleLinked.add(2);
        circleSingleLinked.add(3);
        circleSingleLinked.add(4);
        circleSingleLinked.add(5);
        //2->4->1->5->3
    }

    @Test
    public void YSFQuestionTest() {
        addTest();
        System.out.println(circleSingleLinked.YSFQuestion(2, 0));
    }
}