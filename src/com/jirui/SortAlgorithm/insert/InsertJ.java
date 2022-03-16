package com.jirui.SortAlgorithm.insert;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @author jack Deng
 * @version 1.0
 * @date 2022/3/14 13:53
 */
public class InsertJ {

    public static void main(String[] args) {
        int[] list = {1, 34, 56, 6, 8, 9, 43, 876};
        int[] sort = Sort(list);
        System.out.println(Arrays.toString(sort));
    }
    public static int[] Sort(int[] list){
        int size = list.length;
        int[] arr = Arrays.copyOf(list, size);
        for(int i=1;i<size;i++){
            int tmp = arr[i];
            int j = i;
            while(j>0 && tmp<arr[j-1]){
                arr[j] = arr[j-1];
                j--;
            }
            if(j != i){
                arr[j] = tmp;
            }
        }
        return arr;
    }
}
