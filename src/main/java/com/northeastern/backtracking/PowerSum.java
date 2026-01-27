package com.northeastern.backtracking;

public class PowerSum {
    public static void main(String[] args) {
        powerSum(100, 2);
    }

    static void powerSum(int x, int n){
        powerSum(x, n, 1, 0, 0);
    }

    static void powerSum(int x, int n,  int i, int sum, int count){
        if (i == 50){
            if(x == sum){
                System.out.println(++count);
            }
            return;
        }

        if (sum + Math.pow(i, n) < x){
            powerSum(x, n, i + 1, sum + (int) Math.pow(i, n), count);
        }

        powerSum(x, n, i+ 1, sum, count);
    }
}
