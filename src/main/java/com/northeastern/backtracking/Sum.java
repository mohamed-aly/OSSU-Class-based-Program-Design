package com.northeastern.backtracking;

public class Sum {

    public static void main(String[] args) {
        System.out.println(sumToN(5));
    }

    private static int sumToN(int n){
        if (n == 1){
            return n;
        }

        return n + sumToN(n - 1);
    }
}
