package com.northeastern.module8.problemb;

import java.util.List;

public class IntegersCheckerVariantB {

    private IntegersCheckerVariantB(){}

    static boolean checkList(List<Integer> integerList) {
        return checkRec(0, integerList, false, false, false);
    }

    private static boolean checkRec(
            int index,
            List<Integer> list,
            boolean hasPositiveOdd,
            boolean hasEven,
            boolean hasInRange) {

        // ✅ all requirements satisfied
        if (hasPositiveOdd && hasEven && hasInRange) {
            return true;
        }

        // ❌ ran out of numbers
        if (index >= list.size()) {
            return false;
        }

        int n = list.get(index);

        // 1️⃣ try skipping this number
        if (checkRec(index + 1, list, hasPositiveOdd, hasEven, hasInRange)) {
            return true;
        }

        // 2️⃣ try using it for positive odd
        if (!hasPositiveOdd && n > 0 && n % 2 != 0
            && checkRec(index + 1, list, true, hasEven, hasInRange)) {
            return true;
        }


        // 3️⃣ try using it for even
        if (!hasEven && n % 2 == 0
            && checkRec(index + 1, list, hasPositiveOdd, true, hasInRange)) {
            return true;
        }


        // 4️⃣ try using it for in-range
        if (!hasInRange && n >= 5 && n <= 10
            && checkRec(index + 1, list, hasPositiveOdd, hasEven, true)) {
            return true;
        }


        return false;
    }
}