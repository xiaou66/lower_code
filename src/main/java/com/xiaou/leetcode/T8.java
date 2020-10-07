package com.xiaou.leetcode;

import org.junit.Test;
import sun.applet.Main;

import java.util.HashMap;
import java.util.Map;

/**
 * @url https://leetcode-cn.com/problems/string-to-integer-atoi/
 * @author xiaou
 */
public class T8 {
    public int atoi(String str){
        Automaton automaton = new Automaton();
        int length = str.length();
        for (int i = 0; i < length; ++i){
            automaton.get(str.charAt(i));
        }
        return (int)(automaton.sign * automaton.ans);
    }
    public int atoi2(String str){
        byte[] bytes = str.trim().getBytes();
        if (bytes.length == 0) {
            return 0;
        }
        int res = 0, sign = 1, i = 0;
        if (bytes[0] == '+' || bytes[0] == '-'){
            sign = bytes[0] == '+' ? 1 : -1;
            i++;
        }
        for (;i < bytes.length; i++) {
            int num =  bytes[i] - '0';
            if (num < 0 || num > 9) {
                break;
            }
            if (Integer.MAX_VALUE / 10 < res || ( Integer.MAX_VALUE / 10 == res && Integer.MAX_VALUE % 10 < num)){
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res *= 10;
            res += num;

        }
        return res * sign;
    }
    @Test
    public void test(){
        System.out.println(atoi2("-123"));
    }
}
class Automaton {
    public int sign = 1;
    public long ans = 0;
    // 初始状态
    private String state = "start";
    private Map<String, String[]> table = new HashMap<String, String[]>(){{
        put("start", new String[]{"start","signed","in_number","end"});
        put("signed", new String[]{"end","end","in_number","end"});
        put("in_number", new String[]{"end","end","in_number","end"});
        put("end", new String[]{"end", "end", "end","end"});
    }};
    public void get(char c){
        state = table.get(state)[get_col(c)];
        if ("in_number".equals(state)) {
            ans *= 10;
            ans += c - '0';
            ans = sign == 1 ? Math.min(ans, (long) Integer.MAX_VALUE) : Math.min(ans, -(long) Integer.MIN_VALUE);
        } else if ("signed".equals(state)) {
            sign = c == '+' ? 1 : -1;
        }
    }
    private int get_col(char c){
        if (c == ' ') {
            return 0;
        }
        if (c == '+' || c == '-'){
            return 1;
        }
        if (Character.isDigit(c)){
            return  2;
        }
        return 3;
    }
}





















