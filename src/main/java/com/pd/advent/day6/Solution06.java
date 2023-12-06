package com.pd.advent.day6;

import com.pd.advent.InputUtil;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution06 {

    Long[] times;
    Long[] distances;

    public static void main(String[] args) throws Exception {
        Solution06 s = new Solution06();
        try (BufferedReader reader = InputUtil.readInput("./src/main/resources/day6/input.txt")) {

            String line;

            while ((line = reader.readLine()) != null) {
                s.prepareInput(line);
            }
        }
        System.out.println(s.findCombination());

    }

    public long findCombination() {
        long result = 1;
        for (int i = 0; i < times.length; i++) {

            long time = times[i];
            long distance = distances[i];
            int exceed = 0;
            for(int j=0;j<=time;j++){
                long currDistance = j * (time-j);
                if(currDistance>distance) exceed++;
            }
            result*=exceed;

        }
        return result;
    }

    public void prepareInput(String line) {
        if (line.startsWith("Time: ")) {
            String[] x1 = line.split(":");
            String[] y1 = x1[1].split("\\s");

            StringBuilder sb = new StringBuilder();
            for(String y: y1){
                y = y.trim();
                if(!y.isEmpty() && !y.isBlank()){
                    sb.append(y);

                }
            }
            times = new Long[1];
            times[0] = Long.parseLong(sb.toString());



        } else if (line.startsWith("Distance: ")) {
            String[] x1 = line.split(":");
            String[] y1 = x1[1].split("\\s");

            StringBuilder sb = new StringBuilder();
            for(String y: y1){
                y = y.trim();
                if(!y.isEmpty() && !y.isBlank()){
                    sb.append(y);

                }
            }
            distances = new Long[1];
            distances[0] = Long.parseLong(sb.toString());

        }

    }
}
