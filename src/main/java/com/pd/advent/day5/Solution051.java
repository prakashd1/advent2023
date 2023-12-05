package com.pd.advent.day5;

import com.pd.advent.InputUtil;

import java.io.BufferedReader;
import java.util.*;

public class Solution051 {
    ArrayList<Long> seeds = new ArrayList<>();

    List<Interval> seedsInterval = new ArrayList<>();
    List<Interval> seedToSoilInterval = new ArrayList<>();
    List<Interval> soilToFertInterval = new ArrayList<>();
    List<Interval> fertToWaterInterval = new ArrayList<>();
    List<Interval> waterToLightInterval = new ArrayList<>();
    List<Interval> lightToTempInterval = new ArrayList<>();
    List<Interval> tempToHumInterval = new ArrayList<>();
    List<Interval> humToLocInterval = new ArrayList<>();



    public static void main(String[] args) throws Exception {
        Solution051 s = new Solution051();
        long output = 0;
        StringBuffer sb = new StringBuffer();

        try (BufferedReader reader = InputUtil.readInput("./src/main/resources/day5/input.txt")) {

            String line;

            while ((line = reader.readLine()) != null) {
                sb.append(line).append("\n");
            }
        }
        String[] s1 = (sb.toString().split("\n\n"));
        s.prepareInput(s1);
        long min = Long.MAX_VALUE;

        for(Interval interval: s.seedsInterval){
            for(long i=interval.start; i<interval.end;i++){
                long location = s.findLocation(i);
                min = Math.min(min, location);
            }
        }


        System.out.println(min);


    }

    private long findLocation(long seed) {
        long soil = findDestFromInterval(seed, seedToSoilInterval);
        long fert = findDestFromInterval(soil, soilToFertInterval);
        long water = findDestFromInterval(fert, fertToWaterInterval);
        long light = findDestFromInterval(water, waterToLightInterval);
        long temp = findDestFromInterval(light, lightToTempInterval);
        long hum = findDestFromInterval(temp, tempToHumInterval);
        return findDestFromInterval(hum, humToLocInterval);

    }

    public long findDestFromInterval(long n, List<Interval> list){

        for(Interval i : list){
            if( n >= i.start && n <=i.end){
                return i.dest + (n-i.start);
            }
        }
        return n;
    }

    public void prepareInput(String[] s) {

        for (String a : s) {
            if (a.startsWith("seeds:")) {
                String[] seedArray = a.split(":")[1].trim().split(" ");
                for(int i=1;i<seedArray.length;i+=2){
                    long begin = Long.parseLong(seedArray[i-1]);
                    long range = Long.parseLong(seedArray[i]);
                    Interval seedInter = new Interval(begin,begin,range);
                    seedsInterval.add(seedInter);
                }
//                seeds.addAll(Arrays.stream(seedArray).map(Long::parseLong).toList());
            }
            if (a.startsWith("seed-to-soil map:")) {
                String[] b = a.replace("seed-to-soil map:", "").trim().split("\n");
                addValuesToMap(b, seedToSoilInterval);
            }
            if (a.startsWith("soil-to-fertilizer map:")) {
                String[] b = a.replace("soil-to-fertilizer map:", "").trim().split("\n");
                addValuesToMap(b, soilToFertInterval);
            }
            if (a.startsWith("fertilizer-to-water map:")) {
                String[] b = a.replace("fertilizer-to-water map:", "").trim().split("\n");
                addValuesToMap(b, fertToWaterInterval);
            }
            if (a.startsWith("water-to-light map:")) {
                String[] b = a.replace("water-to-light map:", "").trim().split("\n");
                addValuesToMap(b, waterToLightInterval);
            }
            if (a.startsWith("light-to-temperature map:")) {
                String[] b = a.replace("light-to-temperature map:", "").trim().split("\n");
                addValuesToMap(b, lightToTempInterval);
            }
            if (a.startsWith("temperature-to-humidity map:")) {
                String[] b = a.replace("temperature-to-humidity map:", "").trim().split("\n");
                addValuesToMap(b, tempToHumInterval);
            }
            if (a.startsWith("humidity-to-location map:")) {
                String[] b = a.replace("humidity-to-location map:", "").trim().split("\n");
                addValuesToMap(b, humToLocInterval);
            }
        }


    }

    private void addValuesToMap(String[] b, List<Interval> list) {

        for (String c : b) {
            String[] d = c.split(" ");
            long source = Long.parseLong(d[1]);
            long dest = Long.parseLong(d[0]);
            long interval = Long.parseLong(d[2]);
            Interval intervalObj = new Interval(source,dest,interval);

            list.add(intervalObj);

        }

    }


}
