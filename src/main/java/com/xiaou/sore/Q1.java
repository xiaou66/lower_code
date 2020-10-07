package com.xiaou.sore;

public class Q1 {
    private static String candy(int t,int l, int day){
        if(day % 2 == 0){
            // 偶数天
            l-= day;
            if(l < 0){
                return"liangliang";
            }
        }else {
            // 奇数天
            t-= day;
            if(t < 0){
                return "taotao";
            }
        }
        return Q1.candy(t, l, day + 1);
    }
    public static void main(String[] args) {
        System.out.println( candy(1,1,1));
    }
}
