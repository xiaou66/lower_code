package com.xiaou.leetcode;

import org.junit.Test;

/**
 * @author xiaou
 */
public class SufferExpressionTest {
    @Test
    public void conversionTest() {
        System.out.println(SufferExpression.calculation(SufferExpression.conversion("1+((2+3)*4)-5")));
    }
}
