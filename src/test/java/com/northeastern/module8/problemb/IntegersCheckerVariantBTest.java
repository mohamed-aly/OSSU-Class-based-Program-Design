package com.northeastern.module8.problemb;

import org.junit.jupiter.api.Test;

import java.util.List;

import static com.northeastern.module8.problemb.IntegersCheckerVariantB.checkList;
import static org.junit.jupiter.api.Assertions.*;

class IntegersCheckerVariantBTest {

    @Test
    void minimalValidWithDuplicate() {
        assertTrue(checkList(List.of(6, 5, 6)));
    }

    @Test
    void validUsingDuplicateInRangeAndOdd() {
        assertTrue(checkList(List.of(5, 5, 2)));
    }

    @Test
    void validDistinctAssignments() {
        assertTrue(checkList(List.of(10, 3, 8)));
    }

    @Test
    void validWithExtraNumbers() {
        assertTrue(checkList(List.of(1, 2, 5, 6, 20)));
    }

    // ---------- INVALID CASES ----------

    @Test
    void invalidReusingSameNumber() {
        assertFalse(checkList(List.of(6, 5)));
    }

    @Test
    void singleElementFails() {
        assertFalse(checkList(List.of(5)));
    }

    @Test
    void onlyEvenNumbers() {
        assertFalse(checkList(List.of(2, 4, 6)));
    }

    @Test
    void onlyPositiveOddNumbers() {
        assertFalse(checkList(List.of(5, 7, 9)));
    }

    @Test
    void missingInRangeNumber() {
        assertFalse(checkList(List.of(2, 3)));
    }

    @Test
    void emptyListFails() {
        assertFalse(checkList(List.of()));
    }

    // ---------- EDGE & BOUNDARY ----------

    @Test
    void boundaryValuesUsedSeparately() {
        assertTrue(checkList(List.of(5, 10, 2)));
    }

    @Test
    void boundaryReuseNotAllowed() {
        assertFalse(checkList(List.of(10, 3)));
    }

}