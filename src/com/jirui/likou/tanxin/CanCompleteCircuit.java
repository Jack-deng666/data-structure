package com.jirui.likou.tanxin;

public class CanCompleteCircuit {
    public static void main(String[] args) {
        for(int i=0;i<10;i++){
            if(i==3){
                i=5;
            }
            System.out.println(i);
        }
    }
    public static int canCompleteCircuit(int[] gas, int[] cost){
        int length = gas.length;
        int i = 0;
        while(i<length){
            int sumGas = 0;
            int sumCost = 0;
            int cnt = 0;
            while(cnt<length){
                int j = (i+cnt) %length;
                sumCost+=cost[j];
                sumGas+=gas[j];
                if(sumCost>sumGas){
                    break;
                }
                cnt++;

            }
            if(cnt==length){
                return length;
            }else{
                i = i+cnt+1;
            }
        }
        return -1;
    }
}
