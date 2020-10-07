package com.xiaou.leetcode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @url https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * @author xiaou
 */
public class t3 {
    public static void main(String[] args) {
        t3 t3 = new t3();
        System.out.println(t3.lengthOfLongestSubstring("pwwkew"));
    }
    public int lengthOfLongestSubstring(String s) {
        System.out.println(s);
        Set<String> strings = new HashSet<String>();
        StringBuffer stringBuffer = new StringBuffer();
        int index = 0;
        for(int i = index; i < s.length(); i++){
            if (stringBuffer.length() != 0 && s.charAt(i) == stringBuffer.charAt(0)){
                index = i - 1;
                strings.add(stringBuffer.toString());
                stringBuffer = new StringBuffer();
            }
            stringBuffer.append(s.charAt(i));
        }
        int max = -1;
        for (String str : strings){
            if(max < str.length()){
                max = str.length();
            }
        }
        return max;
    }
}
