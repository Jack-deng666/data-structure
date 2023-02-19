package com.jirui.recursion;

public class Fibonacci {
    public static void main(String[] args) {
        for (int i=1;i<10;i++){
            int j = Fibonacci.FBNQArray(i);
            System.out.println(j);
        }

    }
    public static int FBNQArray(int n){
        if(n==2 || n==1){
            return 1;
        }
        return FBNQArray(n-2)+FBNQArray(n-1);
    }
}
