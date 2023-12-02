package com.pd.advent.day1;

import com.pd.advent.InputUtil;

import java.io.BufferedReader;

public class Solution {
    String[] numMap = new String[]{"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

    public static void main(String[] args) throws Exception {

        Solution s = new Solution();


        BufferedReader reader = InputUtil.readInput("./src/main/resources/day1/input.txt");
        StringBuilder content = new StringBuilder();
        String line;
        int output = 0;


        while ((line = reader.readLine()) != null) {
            int num = s.getFirstNumber(line) * 10 + s.getLastNumber(line);
            System.out.println(line + "=" + num);
            output += num;
        }
        System.out.println(output);
    }

    public int getFirstNumber(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                return c - '0';
            } else {
                String str = (i + 5 > s.length()) ? s.substring(i, s.length() - 1) : s.substring(i, i + 5);
                for (int j = 0; j < numMap.length; j++) {
                    if (str.startsWith(numMap[j])) {
                        return j + 1;
                    }
                }
            }


        }
        return -1;
    }

    public int getLastNumber(String s) {

        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                return c - '0';
            } else {
                String str = (i - 5 < 0) ? s.substring(0, i + 1) : s.substring(i - 4, i + 1);

                for (int j = 0; j < numMap.length; j++) {
                    if (str.endsWith(numMap[j])) {
                        return j + 1;
                    }
                }
            }


        }
        return -1;
    }


}
