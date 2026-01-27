package com.northeastern.module8.problemb;

import java.util.List;

public class IntegersCheckerVariantA {

    private IntegersCheckerVariantA() {
        //utility class
    }

    public static boolean checkList(List<Integer> integerList) {

        return checkRec(0, integerList, false, false, false);
    }

    private static boolean checkRec(int index, List<Integer> integerList, boolean hasPositiveOdd, boolean hasEven, boolean hasInRange){
        if (hasEven && hasPositiveOdd && hasInRange){
            return true;
        }

        if(index >= integerList.size()){
            return false;
        }

        int n = integerList.get(index);

        return checkRec(index + 1, integerList,
                hasPositiveOdd || (n > 0 && n % 2 != 0),
                hasEven || n % 2 == 0,
                hasInRange || (n % 2 == 1));
    }
}
