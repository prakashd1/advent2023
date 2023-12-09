package com.pd.advent.day9;

import com.pd.advent.InputUtil;

import java.io.BufferedReader;


public class MirageMaintenance {
    public static void main(String[] args) throws Exception{
        MirageMaintenance s=new MirageMaintenance();

        long output;
        try (BufferedReader reader = InputUtil.readInput("./src/main/resources/day9/input.txt")) {

            String line;
            output = 0;


            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                output+=s.processLineAndCalculate(line);

            }
        }
        System.out.println(output);
    }

    private long processLineAndCalculate(String line) {
        long result=0;
        String []lines = line.split("\\s");
        long []first = new long[lines.length];
        for (int i=0;i<lines.length;i++){
            first[i] = Long.parseLong(lines[i]);
        }
        Mirage start = new Mirage();
        start.arr = first;
        int count =0 ;
        Mirage curr=start;
        while(!allZeros(curr.arr)){
            Mirage next = new Mirage();
            next.arr = new long[curr.arr.length-1];
            next.parent=curr;
            curr.child=next;
            for(int i=0;i<next.arr.length;i++){
                next.arr[i] = curr.arr[i+1] - curr.arr[i];
            }
            curr=curr.child;
        }

        while(curr!=null){
            result+=curr.arr[curr.arr.length-1];
            curr=curr.parent;
        }
        return result;
    }

    public boolean allZeros(long []arr){
        for(long i:arr){
            if(i!=0) return false;
        }
        return true;
    }
}
