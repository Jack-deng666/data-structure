package com.jirui.likou.tanxin;

public class MaxProfit {
    public static void main(String[] args) {
        int[]a = {7,1,5,3,6,4};
        int[]b = {1,2,3,4,5};
        System.out.println(MaxProfit.maxProfit(b));
    }

    public static int maxProfit(int[] prices) {
    int ans = 0;
        int size = prices.length;
        boolean hasProfit = false;
        for(int i=0;i<size-1;i++){
            if(hasProfit  && prices[i] > prices[i+1]){
                ans+=prices[i];
                hasProfit = false;
            } else if (!hasProfit  && prices[i] < prices[i+1] && i!=size-1) {
                ans-=prices[i];
                hasProfit = true;
            }else if(hasProfit && i+1==size-1){
                ans+=prices[i+1];
            }
        }
        return ans;
    }

}
