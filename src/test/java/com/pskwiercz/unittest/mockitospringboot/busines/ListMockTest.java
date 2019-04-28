package com.pskwiercz.unittest.mockitospringboot.busines;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ListMockTest {

    @Mock
    List mock;

    @Mock
    List<String> mockListStrings;

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

    @Test
    public void mockReturnWithGenericParametersTest() {
        when(mock.get(anyInt())).thenReturn("Example String");
        assertEquals("Example String", mock.get(0));
        assertEquals("Example String", mock.get(1));
    }

    @Test
    public void verificationBasics() {
        String value1 = mockListStrings.get(0);
        String value2 = mockListStrings.get(1);

        // Verify
        verify(mockListStrings).get(0);
        verify(mockListStrings, times(2)).get(anyInt());
        verify(mockListStrings, atLeast(1)).get(anyInt());
        verify(mockListStrings, atLeastOnce()).get(anyInt());
        verify(mockListStrings, atMost(2)).get(anyInt());
        verify(mockListStrings, never()).get(2);
    }
}
