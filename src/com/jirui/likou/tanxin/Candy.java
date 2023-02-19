package com.jirui.likou.tanxin;

public class Candy {
    public static void main(String[] args) {
        int[] b = {1,0,2};
        System.out.println(Candy.candy(b));
    }
    public static int candy(int[] ratings){
        int size = ratings.length;
        int[] a = new int[size];
        for(int i = 0;i<size;i++){
            if(i>0 && ratings[i]>ratings[i-1]){
                a[i] = a[i-1]+1;
            }else {
                a[i] = 1;
            }
        }
        int end = 0;
        int ans = 0;
        for(int j = size-1;j>=0;j--){
            if(j<size-1 && ratings[j]>ratings[j+1]){
                end++;
            }else{
                end=1;
            }
            ans += Math.max(a[j],end);
        }
        return ans;
    }
}
