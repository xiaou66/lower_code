package com.xiaou.sore;

public final class Tool {
    public static void printArray(int [] arrays,String tips){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(tips);
        for (int array : arrays) {
           stringBuilder.append(array);
           stringBuilder.append("  ");
        }
        System.out.println(stringBuilder.toString());
    }
}
