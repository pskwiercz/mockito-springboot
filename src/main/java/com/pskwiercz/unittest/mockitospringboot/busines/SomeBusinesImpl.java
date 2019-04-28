package com.pskwiercz.unittest.mockitospringboot.busines;

import com.pskwiercz.unittest.mockitospringboot.data.DataService;

import java.util.Arrays;

public class SomeBusinesImpl {

    private DataService dataService;

    public void setDataService(DataService dataService) {
        this.dataService = dataService;
    }

    public int calculateSum() {
        int[] data = dataService.retrieveAllData();

        return Arrays.stream(data).reduce(Integer::sum).orElse(0);
    }

    public int calculateSum(int[] data) {
//        int sum = 0;
//        for(int value : data) {
//            sum += value;
//        }
//        return sum;

        return Arrays.stream(data).reduce(Integer::sum).orElse(0);
    }
}
