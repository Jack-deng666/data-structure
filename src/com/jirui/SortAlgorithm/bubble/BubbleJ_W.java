package com.jirui.SortAlgorithm.bubble;


import java.util.Arrays;

/**
 * @author jack Deng
 * @version 1.0
 * @date 2022/3/14 10:21
 */

/**
 冒泡排序就是通过遍历，比较相邻两个元素，将大的或者小的交换位置放在最右边。
 */
public class BubbleJ_W {
    public static void main(String[] args) {
        int[] list = {100,1, 34, 56, 6, 8, 9, 43, 876,0};
        int[] sort = Sort(list);
        System.out.println(Arrays.toString(sort));
    }
    public static int[]  Sort(int[] list){
        int size = list.length;
        for(int i=0;i<size;i++){
            for(int j=i;j<size ;j++){
                if(list[i]>list[j]){
                    int temp = list[j];
                    list[j] = list[i];
                    list[i] = temp;
                }
            }
        }
        return list;
    }
}