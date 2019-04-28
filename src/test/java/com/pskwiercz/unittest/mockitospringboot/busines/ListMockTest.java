package com.pskwiercz.unittest.mockitospringboot.busines;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ListMockTest {

    @Mock
    List mock;

    @Test
    public void mockReturnOneValueTest() {
        when(mock.size()).thenReturn(5);
        assertEquals(5, mock.size());
    }

    @Test
    public void mockReturnMultipleValuesTest() {
        when(mock.size()).thenReturn(5).thenReturn(10);
        assertEquals(5, mock.size());
        assertEquals(10, mock.size());
    }

    @Test
    public void mockReturnWithParametersTest() {
        when(mock.get(0)).thenReturn("Example String");
        assertEquals("Example String", mock.get(0));
        assertEquals(null, mock.get(1));
    }
}
