package com.pskwiercz.unittest.mockitospringboot.busines;

import com.pskwiercz.unittest.mockitospringboot.data.DataService;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SomeBusinesImplMockTest {



    @Test
    public void calculateSumUsingDataServiceTest() {
        DataService dataServiceMock = mock(DataService.class);
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{1,2,3});

        SomeBusinesImpl someBusines = new SomeBusinesImpl();
        someBusines.setDataService(dataServiceMock);

        assertEquals(6, someBusines.calculateSum());
    }

    @Test
    public void calculateSumUsingDataService_EmptyArrayTest() {
        DataService dataServiceMock = mock(DataService.class);
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{});

        SomeBusinesImpl someBusines = new SomeBusinesImpl();
        someBusines.setDataService(dataServiceMock);

        assertEquals(0, someBusines.calculateSum());
    }

    @Test
    public void calculateSumUsingDataServic_OneValueTest() {
        DataService dataServiceMock = mock(DataService.class);
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{5});

        SomeBusinesImpl someBusines = new SomeBusinesImpl();
        someBusines.setDataService(dataServiceMock);

        assertEquals(5, someBusines.calculateSum());
    }
}