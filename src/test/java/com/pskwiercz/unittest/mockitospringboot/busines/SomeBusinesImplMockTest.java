package com.pskwiercz.unittest.mockitospringboot.busines;

import com.pskwiercz.unittest.mockitospringboot.data.DataService;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SomeBusinesImplMockTest {

    SomeBusinesImpl someBusines = new SomeBusinesImpl();
    DataService dataServiceMock = mock(DataService.class);

    @Before
    public void setUp() {
        someBusines.setDataService(dataServiceMock);
    }

    @Test
    public void calculateSumUsingDataServiceTest() {
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{1,2,3});
        assertEquals(6, someBusines.calculateSum());
    }

    @Test
    public void calculateSumUsingDataService_EmptyArrayTest() {
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{});
        assertEquals(0, someBusines.calculateSum());
    }

    @Test
    public void calculateSumUsingDataServic_OneValueTest() {
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{5});
        assertEquals(5, someBusines.calculateSum());
    }
}