package com.pskwiercz.unittest.mockitospringboot.busines;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
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
    @Mock
    ArrayList mockArrayList;
    @Spy
    ArrayList spyMockArrayList;

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

    @Test
    public void argumentCapturingTest() {
        mockListStrings.add("Example string");

        // Verification
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mockListStrings).add(captor.capture());

        assertEquals("Example string", captor.getValue());
    }

    @Test
    public void multipleArgumentsCapturingTest() {
        mockListStrings.add("Example string 1");
        mockListStrings.add("Example string 2");

        // Verification
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mockListStrings, times(2)).add(captor.capture());

        List<String> captureValues = captor.getAllValues();

        assertEquals("Example string 1", captureValues.get(0));
        assertEquals("Example string 2", captureValues.get(1));
    }

    @Test
    public void mockingTest() {
        mockArrayList.get(0); // null
        mockArrayList.size(); // 0
        mockArrayList.add("Test1");
        mockArrayList.add("Test2");
        mockArrayList.size(); //!!!!!!! stil 0 THIS IS MOCK NOT REAL OBJECT !!!!!!
        when(mockArrayList.size()).thenReturn(5);
        mockArrayList.size(); // 5 !!!!
    }

    @Test
    public void spyingTest() {
        spyMockArrayList.add("Test0");
        spyMockArrayList.get(0); // Test0
        spyMockArrayList.size(); // 1
        spyMockArrayList.add("Test1");
        spyMockArrayList.add("Test2");
        spyMockArrayList.size(); // 3

        when(spyMockArrayList.size()).thenReturn(5);
        System.out.println(spyMockArrayList.size()); // 5 !!!!

        // NOTICE
        spyMockArrayList.add("Test3");
        System.out.println(spyMockArrayList.size()); // STILL 5 !!!!!

        verify(spyMockArrayList).add("Test2");
        verify(spyMockArrayList, never()).add("Test4");
    }
}
