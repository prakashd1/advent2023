package com.pd.advent.day8;

import com.pd.advent.InputUtil;

import java.io.BufferedReader;
import java.util.*;

public class Solution {
    char []instructions;
    Map<String, Direction> directionMap = new HashMap<>();

    Set<String> visited = new HashSet<>();
    public static void main(String[] args) throws Exception {
        int count = 0;
        int output=-1;
        Solution s= new Solution();
        try (BufferedReader reader = InputUtil.readInput("./src/main/resources/day8/input.txt")) {

            String line;

            while ((line = reader.readLine()) != null) {
                if(count==0) {
                    s.setInstructions(line);
                }else if(count>=2){
                    s.processDirections(line);
                }
                count++;

            }
            output = s.followInstructions();
        }
        System.out.println(output);
    }

    public int followInstructions() {
        int count=0;
        Direction curr = directionMap.get("AAA");

        return reachZZZ(curr, count);


    }

    private int reachZZZ(Direction curr, int count) {
        while(!"ZZZ".equalsIgnoreCase(curr.name)){
            for(char c: this.instructions){
                if("ZZZ".equalsIgnoreCase(curr.name)){
                    break;
                }
                if(c =='L'){
                    curr = curr.left;
                }else if(c=='R'){
                    curr = curr.right;
                }
                count++;
            }
        }
        return count;

    }

    private void processDirections(String line) {
        String []lines = line.split("=");
        String name = lines[0].trim();

        if(!directionMap.containsKey(name)){
            directionMap.put(name,new Direction(name));
        }
        Direction d = directionMap.get(name);
        String []lr = lines[1].split(",");
        String left = lr[0].trim().replace("(", "");
        String right = lr[1].trim().replace(")", "");
        if(!this.directionMap.containsKey(left)){
            directionMap.put(left, new Direction(left));
        }
        d.left = directionMap.get(left);
        if(!this.directionMap.containsKey(right)){
            directionMap.put(right, new Direction(right));
        }
        d.right = directionMap.get(right);


    }

    public void setInstructions(String line){
        this.instructions = line.toCharArray();
    }
}
