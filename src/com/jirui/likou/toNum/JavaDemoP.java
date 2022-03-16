package com.jirui.likou.toNum;

import org.junit.Test;

/**
 * @author jack Deng
 * @version 1.0
 * @date 2022/3/16 17:14
 */
public class JavaDemoP {
    public static void main(String[] args) {
        long l = myAtoi("  -4234324dwstweg ");
        System.out.println(l);
    }
    public static int myAtoi(String s) {
        String str = s.trim();

        long ans = 0;
        // 判断数字正负
        boolean positionNumber = true;
        for (int i=0;i<str.length();i++){
            char a = str.charAt(i);
            if(i==0 && (a=='-' || a =='+'))
            {
                positionNumber = a != '-';
            }
            else if(Character.isDigit(a)) {
                ans = ans*10 + a - '0';
                ans = positionNumber ? Math.min(ans, Integer.MAX_VALUE) : Math.min(ans, -(long) Integer.MIN_VALUE);
            }
            else
                break;
        }
        return (int) (positionNumber? ans: -ans);
    }
}
