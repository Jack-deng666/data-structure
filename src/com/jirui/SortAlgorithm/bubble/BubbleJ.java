package com.jirui.SortAlgorithm.bubble;

import java.util.Arrays;
import java.util.List;

/**
 * @author jack Deng
 * @version 1.0
 * @date 2022/3/14 11:35
 */
public class BubbleJ {
    public static void main(String[] args) {
        int[] list = {1, 34, 56, 6, 8, 9, 43, 876};
        int[] sort = Sort(list);
        System.out.println(Arrays.toString(sort));
    }
    public static int[] Sort(int[] list){
        int size = list.length;
        for(int i=0;i<size;i++){
            for(int j=0;j<size-i-1;j++){
                if(list[j]>list[j+1]){
                    int temp = list[j];
                    list[j] = list[j+1];
                    list[j+1] = temp;
                }
            }
        }
        return list;
    }
}
