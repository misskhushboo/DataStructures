package com.slidingwindow;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of integers deposits representing daily deposit values, calculate the 3-day rolling average for each valid window.
 * Return the rolling averages as a list of floats, each rounded to 2 decimal places. The rolling average for day i (0-indexed, starting from i = 2) is the average of deposits on days i-2, i-1, and i.
 * If the array has fewer than 3 elements, return an empty list.
 *
 * E.g
 *
 Input: deposits = [100,200,300,400,500]
 Output: [200,300,400]
 Explanation: Window [100,200,300] -> 200.0, Window [200,300,400] -> 300.0, Window [300,400,500] -> 400.0.
 */
public class RollingAverage {

    public static void main(String[] args){
        new RollingAverage().rollingAverage(new int[]{100,200,300,400,500});
    }

    private void rollingAverage(int[] inputArray) {

        List<Float> averageList= new ArrayList<>(inputArray.length-2);
        if(inputArray.length<3) return;
        for(int i=2; i<inputArray.length; i++){

            float averageNumber = (inputArray[i]+inputArray[i-1]+inputArray[i-2])/3;
            averageList.add(averageNumber);

        }
        averageList.stream().forEach(System.out::println);
    }
}
