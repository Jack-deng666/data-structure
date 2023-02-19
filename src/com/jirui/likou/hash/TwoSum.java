package com.jirui.likou.hash;

import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
        int[] b = {3,2,4};
        System.out.println(new TwoSum().twoSum(b, 6));
    }
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> a = new HashMap<>();

        for(int j=0;j<nums.length;j++){
            Integer value = a.getOrDefault(target - nums[j], -1);
            if(value != -1 &&  j!=value){
                result[0] = j;
                result[1] = value;
                break;
            }
            a.put(nums[j], j);
        }
        return result;
    }
}
