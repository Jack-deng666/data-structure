package com.jirui.arrayQ;

public class ArraySqrtSorted {
    public int[] sortedSquares(int[] nums) {
        int size = nums.length;
        int k = size-1;
        int[] result = new int[size];
        for(int i=0, j=size-1; i<=j;){
            if(Math.pow(nums[i],2)>Math.pow(nums[j],2)){
                result[k] = (int)Math.pow(nums[i],2);
                k--;
                i++;
            }else{
                result[k] = (int)Math.pow(nums[j],2);
                k--;
                j--;
            }
        }
        return result;
    }

}
