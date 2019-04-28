package com.pskwiercz.unittest.mockitospringboot.busines;

import com.pskwiercz.unittest.mockitospringboot.data.DataService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SomeBusinesImplMockTest {

    @InjectMocks
    SomeBusinesImpl someBusines;

    @Mock
    DataService dataServiceMock;

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