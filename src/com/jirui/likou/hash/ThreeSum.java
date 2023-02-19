package com.jirui.likou.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        new ThreeSum().threeSum(new int[] {-1,0,1,2,-1,-4});
    }
    public List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0) return result;
            if(i>0 && nums[i] == nums[i-1]){continue;} // 重复的需要要在遍历，去重。
            int head=i+1,tail = nums.length-1;
            while (head < tail) {
                System.out.println(head+":"+tail);
                int i1 = nums[i] + nums[head] + nums[tail];
                if(i1==0){
                    result.add(Arrays.asList(nums[i],nums[head],nums[tail]));
                    while(head<tail && nums[head]==nums[head+1]) head++;
                    while(head<tail && nums[tail]==nums[tail-1]) tail--;
                    head++;
                    tail--;
                }else if (i1 > 0) {
                    tail--;
                } else{
                    head++;
                }
            }

        }
        return result;


    }
}
