package com.jirui.string;

import java.util.Arrays;

public class BoyerMoore {
    /**
     * 构建模式串的散列表
     * @param a
     * @param size
     * @param bc
     * @return
     */
    private int[] generateBC(char[] a, int size, int[]  bc ){
        for(int i=0;i<size;i++){
            int ascii = a[i];
            bc[ascii] = i;
        }
        return bc;
    }

    /**
     * bm的坏字符规则
     * @param a 主串
     * @param b 模式串
     * @return 匹配上的初始索引位置
     */
    public int bM(char[] a, char[] b ){
        int mainLen = a.length;
        int patternLen = b.length;
        int[] bc = new int[256];
        Arrays.fill(bc, -1);
        generateBC(b,patternLen,bc);
        int i=0;
        while (i<=mainLen-patternLen){
            int j;
            for( j=patternLen-1; j>=0;j--){
                if(a[j+i]!=b[j]) {
                    break;
                }
            }
            if(j<0) return i;
            i = i+(j-bc[b[j]]);
        }
        return -1;
    }

}
