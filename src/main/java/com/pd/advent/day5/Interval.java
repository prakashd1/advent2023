package com.pd.advent.day5;

public class Interval {

    public Interval(long source, long dest, long interval) {
        this.source = source;
        this.dest = dest;
        this.interval = interval;

        this.start = source;
        this.end = source + interval;
    }

    long source;
    long dest;

    long start;
    long end;

    long interval;
}
