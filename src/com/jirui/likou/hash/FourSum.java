package com.jirui.likou.hash;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for(int j=0;j<nums.length;j++){
            if(nums[j]>0 && nums[j] >= target){return result;}
            if(j>0 && nums[j]==nums[j-1]) continue;
            for(int i=j+1;i<nums.length;i++){
                if(i>j+1 && nums[i]==nums[i-1]) continue;
                int head=i+1,tail = nums.length-1;
                while (head < tail) {
                    long i1 = (long) nums[i] + nums[j] + nums[head] + nums[tail];
                    if(i1==target){
                        result.add(Arrays.asList(nums[i],nums[head],nums[tail]));
                        while(head<tail && nums[head]==nums[head+1]) head++;
                        while(head<tail && nums[tail]==nums[tail-1]) tail--;
                        head++;
                        tail--;
                    }else if (i1 > target) {
                        tail--;
                    } else{
                        head++;
                    }
                }
            }
        }
        return result;

    }
}
