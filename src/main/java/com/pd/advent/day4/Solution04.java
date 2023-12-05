package com.pd.advent.day4;

import com.pd.advent.InputUtil;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution04 {
    public static void main(String[] args) throws Exception{
        Solution04 s=new Solution04();
        long output = 0;
        StringBuffer sb = new StringBuffer();

        try (BufferedReader reader = InputUtil.readInput("./src/main/resources/day4/input.txt")) {

            String line;

            while ((line = reader.readLine()) != null) {
                output+=s.parseCard(line);
            }
        }
        System.out.println(output);
    }
    public int parseCard(String line){
        String []cards = line.split(":");
        String []bothCards = cards[1].trim().split("\\|");
        String []winningCards = bothCards[0].trim().split("\\s");
        String []yourCards = bothCards[1].trim().split("\\s");


        List<Integer> winCard = new ArrayList<>();
        List<Integer> yourCard = new ArrayList<>();

        for(String x:winningCards){
            if(!x.isBlank() && !x.isEmpty()){
                winCard.add(Integer.parseInt(x));
            }
        }

        for(String x:yourCards){
            if(!x.isBlank() && !x.isEmpty()){
                yourCard.add(Integer.parseInt(x));
            }
        }

        winCard.retainAll(yourCard);


        System.out.println(winCard.size());

        return !winCard.isEmpty() ? ((int)Math.pow(2, winCard.size()-1)) : 0;

    }
}
