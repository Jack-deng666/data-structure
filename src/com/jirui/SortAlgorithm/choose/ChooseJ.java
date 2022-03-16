package com.jirui.SortAlgorithm.choose;

import java.util.Arrays;

/**
 * @author jack Deng
 * @version 1.0
 * @date 2022/3/14 10:51
 */

/**
 * 选择排序就是遍历两次，找出未遍历的区域的最小值，与第一次遍历的初始值替换，就可以保证每次排序后，最小值都被找出来，且放在最前面。
 */
public class ChooseJ {
    public static void main(String[] args) {
        int[] list = {1, 34, 56, 6, 8, 9, 43, 876};
        int[] sort = Sort(list);
        System.out.println(Arrays.toString(sort));
    }
    public static int[] Sort(int[] list){
        int size = list.length;
        for(int i=0;i<size;i++){
            int minIndex = i;
            for(int j=i+1;j<size;j++){
                if(list[j]<list[minIndex]){
                    minIndex = j;
                }
            }
            if(i!=minIndex){
                int temp = list[i];
                list[i] = list[minIndex];
                list[minIndex] = temp;
            }
        }
        return list;
    }
}
