package com.pskwiercz.unittest.mockitospringboot.busines;

import org.junit.Test;

import static org.junit.Assert.*;

public class SomeBusinesImplTest {

    @Test
    public void calculateSumTest() {
        SomeBusinesImpl someBusines = new SomeBusinesImpl();
        int sum = someBusines.calculateSum(new int[]{1, 2, 3});

        assertEquals(6, sum);
    }

    @Test
    public void calculateSumEmptyArrayTest() {
        SomeBusinesImpl someBusines = new SomeBusinesImpl();
        int sum = someBusines.calculateSum(new int[]{});

        assertEquals(0, sum);
    }

    @Test
    public void calculateSumOneValueTest() {
        SomeBusinesImpl someBusines = new SomeBusinesImpl();
        int sum = someBusines.calculateSum(new int[]{5});

        assertEquals(5, sum);
    }
}