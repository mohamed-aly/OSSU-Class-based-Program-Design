package com.northeastern.backtracking;

import java.util.ArrayList;
import java.util.List;

public class BackTracking {

    public static void main(String[] args) {
        subsets(0, new ArrayList<>());

    }

    static void subsets(int index, List<Integer> curr) {
        if (index == 3) {
            if (!curr.isEmpty()) {
                System.out.println(curr);
            }
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
