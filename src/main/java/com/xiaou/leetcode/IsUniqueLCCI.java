package com.xiaou.leetcode;

import org.junit.Test;

/**
 * @url https://leetcode-cn.com/problems/is-unique-lcci/
 * @author xiaou
 */
public class IsUniqueLCCI {
    public boolean isUnique(String astr) {
        char [] c = new char[128];
        for (int i = 0; i < astr.length(); i++) {
            if(c[astr.charAt(i)] != 0){
                return false;
            }
            c[astr.charAt(i)]++;
        }
        return true;
    }
    @Test
    public void test(){
        System.out.println(isUnique("absa"));
    }
}
