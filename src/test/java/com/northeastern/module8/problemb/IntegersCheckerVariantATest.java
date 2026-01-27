package com.northeastern.module8.problemb;

import org.junit.jupiter.api.Test;

import java.util.List;

import static com.northeastern.module8.problemb.IntegersCheckerVariantA.checkList;
import static org.junit.jupiter.api.Assertions.*;

class IntegersCheckerVariantATest {

    @Test
    void testSingleNumberSatisfiesAll() {
        assertFalse(checkList(List.of(5)));
    }

    @Test
    void testExampleFromProblem() {
        assertTrue(checkList(List.of(6, 5)));
    }

    @Test
    void testMissingEven() {
        assertFalse(checkList(List.of(1, 3, 5, 7)));
    }

    @Test
    void testMissingPositiveOdd() {
        assertFalse(checkList(List.of(2, 4, 6)));
    }

    @Test
    void testEmptyList() {
        assertFalse(checkList(List.of()));
    }

    @Test
    void testBoundaryValues() {
        assertTrue(checkList(List.of(10, 3)));
    }

}