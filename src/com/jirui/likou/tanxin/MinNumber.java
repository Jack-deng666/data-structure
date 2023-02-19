package com.jirui.likou.tanxin;

import java.util.Arrays;

public class MinNumber {
    public String minNumber(int[] nums){
        int size = nums.length;
        String[] a = new String[size];
        for(int i=0;i<size;i++){
            a[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(a,(x,y)->(x+y).compareTo(y+x));
//        quickSorted(a,0,size-1);
        StringBuilder stringBuffer = new StringBuilder();
        for(String value: a){
            stringBuffer.append(value);
        }
        return stringBuffer.toString();
    }
    public void quickSorted(String[] initStringArray,int start, int end){
        if (end<=start) return ;
        int i = start;
        int j = end;
        String tmp = initStringArray[start];
        while(i<j){
            while((initStringArray[j]+initStringArray[start]).compareTo(initStringArray[start]+initStringArray[j])>=0
                    && i<j) j--;
            while((initStringArray[start]+initStringArray[i]).compareTo(initStringArray[i]+initStringArray[start])>=0
                    && i<j) i++;
            tmp = initStringArray[i];
            initStringArray[i] = initStringArray[j];
            initStringArray[j] = tmp;
        }
        initStringArray[i] = initStringArray[start];
        initStringArray[start] = tmp;
        quickSorted(initStringArray, start,i-1);
        quickSorted(initStringArray,i+1,end);
    }

    public static void main(String[] args) {
        int[] b = {1,2,3,1};
        System.out.println(new MinNumber().minNumber(b));
    }
}
