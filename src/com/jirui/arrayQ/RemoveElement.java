package com.jirui.arrayQ;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int size = nums.length;
        int fast ,low = 0;
        for(fast=0;fast<size;fast++){
            if(nums[fast]!=val){
               nums[low++] = nums[fast];
            }
        }
        return low;
    }
}
