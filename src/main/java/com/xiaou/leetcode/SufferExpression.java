package com.xiaou.leetcode;

import java.util.Stack;

/**
 * @author xiaou
 */
public class SufferExpression {
    /**
     * 将 中缀表达式 转换 后缀表达式
     * @param infix 中缀表达式
     * @return String 后缀表达式
     */
    public static String conversion(String infix) {
        Stack<Character> s2 = new Stack<Character>();
        Stack<Character> s1 = new Stack<Character>();
        for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);
            if(isSymbol(c)) {
                while (true) {
                    if(s1.empty()) {
                        // 当临时符号栈为空时
                        s1.push(c);
                        break;
                    } else {

                        // 当临时符号栈不为空时, 跟站顶的操作符进行比较
                        char symbolsTop = s1.peek();
                        if(c == '(') {
                            s1.push(c);
                            break;
                        }else if(c == ')') {
                            // 当前符号为右括号时,进行对临时符号栈进行弹栈直到弹到上一个括号
                            // 目的为了移除括号
                            while (symbolsTop != '(') {
                                s2.push(s1.pop());
                                symbolsTop = s1.peek();
                            }
                            s1.pop();
                            break;
                        }else  {
                            // 比较当前运算符和符号栈顶的符号的优先级
                            if(symbolsTop == '(' || symbolRank(c) > symbolRank(symbolsTop)) {
                                s1.push(c);
                                break;
                            }
                            s2.push(s1.pop());
                        }
                    }
                }
            }else{
                // 是数字
                s2.push(c);
            }
        }
        while (!s1.empty()) {
            s2.push(s1.pop());
        }
        StringBuffer sb = new StringBuffer();
        while (!s2.empty()) {
            sb.insert(0, s2.pop());
        }
        return sb.toString();
    }
    public static int calculation(String suffer) {
        Stack<Integer> integers = new Stack<Integer>();
        for (int i = 0; i < suffer.length(); i++) {
            char c = suffer.charAt(i);
            if(isSymbol(c)) {
                // 如果是符号则弹出两个数字进行运算
                Integer num1 = integers.pop();
                Integer num2 = integers.pop();
                int res =  0;
                switch (c){
                    case '+':
                        res = num1 + num2;
                        break;
                    case '-':
                        res = num2 - num1;
                        break;
                    case '*':
                        res = num2 * num1;
                        break;
                    case '/':
                        res = num2 / num1;
                        break;
                    default:
                        break;
                }
                integers.push(res);

            }else{
                // 如果是数字压入数字栈
                integers.push(c - 48);
            }
        }
        return integers.pop();
    }

    /**
     * 判断字符是否是运算符号
     * @param c 字符
     * @return false/ true
     */
    private static boolean isSymbol(char c) {
        return !(c >=48 && c <= 57);
    }

    /**
     * 运算符号优先级
     * @param c 运算符号
     * @return 优先级
     */
    private static int symbolRank(char c) {
        if(c=='(' || c == ')') {
            return 3;
        }
        if(c == '*' || c == '/') {
            return 2;
        }
        if(c == '+' || c == '-') {
            return 1;
        }
        throw new RuntimeException("运算符不支持");
    }
}
