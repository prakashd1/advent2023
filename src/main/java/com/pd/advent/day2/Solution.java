package com.pd.advent.day2;

import com.pd.advent.InputUtil;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;


public class Solution {

    public static void main(String[] args) throws Exception {

        Solution s = new Solution();
        int output=0;
        try (BufferedReader reader = InputUtil.readInput("./src/main/resources/day2/input.txt")) {

            String line;

            while ((line = reader.readLine()) != null) {
                Game game = s.parseLine(line);
                if(s.isGameQualified(game)){
                    output+=game.gameNumber;
                }


            }
        }
        System.out.println(output);
    }

    public boolean isGameQualified(Game game){
        for(BagSet b: game.list){
            if(b.red > 12 || b.green>13 || b.blue>14 )
                return false;
        }
        return true;
    }

    public Game parseLine(String line){
        Game game=new Game();
        List<BagSet> list=new ArrayList<>();

        String [] s1=line.split(":");
        int gameNumber = Integer.parseInt(s1[0].replace("Game ",""));
        game.gameNumber=gameNumber;
        String []content = s1[1].split(";");
        for(String s2:content){
            String []s3 = s2.split(",");
            BagSet set=new BagSet();
            for(String s4:s3){
                s4=s4.trim();
                String []s5 = s4.split(" ");
                String s = s5[1];
                int quantity = Integer.parseInt(s5[0]);
                if("red".equalsIgnoreCase(s)){
                    set.red = quantity;
                }else if("blue".equalsIgnoreCase(s)){
                    set.blue = quantity;
                }else if("green".equalsIgnoreCase(s)){
                    set.green = quantity;
                }
            }
            list.add(set);

        }
        game.list=list;

        return game;
    }


}
