package com.northeastern.backtracking;

import java.util.List;

public class BinarySequence {

    public static void main(String[] args) {
        kNStrings(List.of('0', '1'), 3);
    }

   static void kNStrings(List<Character> chars, int k){
        kNStrings(chars, k, "");
   }

    static void kNStrings(List<Character> chars, int k, String s){
        if(s.length() == k){
            System.out.println(s);
            return;
        }

        for(char c : chars){
            kNStrings(chars, k, s + c);
        }
    }

    static void generate(int n) {
        generate(n, "", 0, 0);
    }

    static void generate(int n, String s, int sum1, int sum2) {
        if (s.length() == 2 * n) {
            if (sum1 == sum2) {
                System.out.println(s);
            }
            return;
        }

        generate(n, s + "0", sum1, sum2);
        if (s.length() < n) {
            generate(n, s + "1", sum1 + 1, sum2);
        } else {
            generate(n, s + "1", sum1, sum2 + 1);
        }

    }

    static void digits(int index, String s) {
        if (index == 2) {
            System.out.println(s);
            return;
        }

        digits(index + 1, s + "0");
        digits(index + 1, s + "1");
        digits(index + 1, s + "2");
//        digits(index + 1, s + "3");
    }

    static void build(int index, String s) {
        if (index == 3) {
            System.out.println(s);
            return;
        }

        build(index + 1, s + "0");
        build(index + 1, s + "1");
    }

    static int sum(int n) {
        if (n == 0) {
            return n;
        }
        return n + sum(n - 1);
    }

    static void countDown(int n) {
        if (n == 0) {
            return;
        }
        System.out.println(n);
        countDown(n - 1);
    }

    static void generate(String s) {
        if (s.length() == 3) {   // base case
            System.out.println(s);
            return;
        }

        generate(s + "0");       // choice 1
        generate(s + "1");       // choice 2
    }

    static void subsets(int index, List<Integer> curr) {
        if (index == 3) {
            System.out.println(curr);
            return;
        }

        // exclude
        subsets(index + 1, curr);

        // include
        curr.add(index + 1);
        subsets(index + 1, curr);
        curr.removeLast(); // BACKTRACK
    }
}
