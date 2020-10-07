package com.xiaou.leetcode;

import org.junit.Test;

/**
 * @url https://leetcode-cn.com/problems/reverse-integer/
 * @author xiaou
 */
public class T7 {
    @Test
    public void Test(){
        System.out.println(reverse1(1056389759));
    }
    public int reverse(int x) {
        if (x < 10 && x >= 0){
            return x;
        }
        int fig = 1;
        String xString = String.valueOf(x);
        if (x < 0){
            fig = -1;
            xString = xString.substring(1);
        }
       try {
           return Integer.parseInt(new StringBuilder(xString).reverse().toString()) * fig;
       }catch (Exception e){
           return 0;
       }

    }
    public int reverse1(int x) {
        long n = 0;
        while (x != 0) {
            n *= 10;
            n += x % 10;
            x /= 10;
        }
        int u = (int) n;
        return u==n ? (int)u : 0;
    }
}
