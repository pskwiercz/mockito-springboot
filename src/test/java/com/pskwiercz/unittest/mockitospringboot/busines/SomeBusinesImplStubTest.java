package com.pskwiercz.unittest.mockitospringboot.busines;

import com.pskwiercz.unittest.mockitospringboot.data.DataService;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

class DataServiceStub implements DataService {
    @Override
    public int[] retrieveAllData() {
        return new int[]{1, 2, 3};
    }
}

class DataServiceStubEmpty implements DataService {
    @Override
    public int[] retrieveAllData() {
        return new int[]{};
    }
}

class DataServiceStubOneValue implements DataService {
    @Override
    public int[] retrieveAllData() {
        return new int[]{5};
    }
}

public class SomeBusinesImplStubTest {

    @Test
    public void calculateSumUsingDataServiceTest() {
        SomeBusinesImpl someBusines = new SomeBusinesImpl();
        someBusines.setDataService(new DataServiceStub());
        int sum = someBusines.calculateSum();

        assertEquals(6, sum);
    }

    @Test
    public void calculateSumUsingDataService_EmptyArrayTest() {
        SomeBusinesImpl someBusines = new SomeBusinesImpl();
        someBusines.setDataService(new DataServiceStubEmpty());
        int sum = someBusines.calculateSum();

        assertEquals(0, sum);
    }

    @Test
    public void calculateSumUsingDataServic_OneValueTest() {
        SomeBusinesImpl someBusines = new SomeBusinesImpl();
        someBusines.setDataService(new DataServiceStubOneValue());
        int sum = someBusines.calculateSum();

        assertEquals(5, sum);
    }
}