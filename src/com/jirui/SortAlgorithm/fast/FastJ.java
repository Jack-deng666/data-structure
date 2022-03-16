package com.jirui.SortAlgorithm.fast;

import java.util.Arrays;

/**
 * @author jack Deng
 * @version 1.0
 * @date 2022/3/14 16:19
 */
public class FastJ {
    public static void main(String[] args) {
        int[] list = {1, 34, 56, 6, 8, 9, 43, 876};
        int[] sort = Sort(list,0,list.length-1);
        System.out.println(Arrays.toString(sort));
    }
    public static int[] Sort(int[] list,int start,int end){
        if(start>=end){
            return list;
        }
        int pivot = list[start];
        int i = start;
        int j = end;
        while (i<j){
            while(i<j && list[j]>=pivot){
              j--;
            }
            while(i<j && list[i]<=pivot){
              i++;
            }
            if(j>i){
                int tmp = list[i];
                list[i] = list[j];
                list[j] = tmp;
            }
        }
        list[start] = list[i];
        list[i] = pivot;

        Sort(list,start,i-1);
        Sort(list,i+1,end);
        return list;
    }
}
