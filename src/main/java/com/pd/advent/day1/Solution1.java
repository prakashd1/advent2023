package com.pd.advent.day1;


import com.pd.advent.InputUtil;

import java.io.BufferedReader;

public class Solution1 {
    public static void main(String[] args) throws Exception {

        Solution1 s = new Solution1();
        int output;
        try (BufferedReader reader = InputUtil.readInput("./src/main/resources/day1/input.txt")) {
            StringBuilder content = new StringBuilder();
            String line;
            output = 0;


            while ((line = reader.readLine()) != null) {
                String translatedLine = s.replaceAll(line);

                int num = s.getFirstNumber(translatedLine) * 10 + s.getLastNumber(translatedLine);
                System.out.println(line + "=" + num);
                output += num;
            }
        }
        System.out.println(output);
    }

    public String replaceAll(String s) {
        return s.replaceAll("one", "o1e")
                .replaceAll("two", "t2o")
                .replaceAll("three", "t3e")
                .replaceAll("four", "f4r")
                .replaceAll("five", "f5e")
                .replaceAll("six", "s6e")
                .replaceAll("seven", "s7n")
                .replaceAll("eight", "e8t")
                .replaceAll("nine", "n9e");
    }

    public int getFirstNumber(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                return c - '0';
            }


        }
        return -1;
    }

    public int getLastNumber(String s) {

        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                return c - '0';
            }
        }
        return -1;
    }


}



