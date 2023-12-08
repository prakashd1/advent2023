package com.pd.advent.day8;

import com.pd.advent.InputUtil;

import java.io.BufferedReader;
import java.util.*;

public class Solution08 {
    char[] instructions;
    Map<String, Direction> directionMap = new HashMap<>();

    List<String> aNodes = new ArrayList<>();


    public static void main(String[] args) throws Exception {
        int count = 0;
        long output = -1;
        Solution08 s = new Solution08();
        try (BufferedReader reader = InputUtil.readInput("./src/main/resources/day8/input.txt")) {

            String line;

            while ((line = reader.readLine()) != null) {
                if (count == 0) {
                    s.setInstructions(line);
                } else if (count >= 2) {
                    s.processDirections(line);
                }
                count++;
            }
            output = s.processInput();
        }
        System.out.println(output);
    }

    public long processInput() {
        long count = 0;
        for (String name : directionMap.keySet()) {
            if (name.endsWith("A")) {
                aNodes.add(name);
            }

        }
        count = reachZZZ();
        return count;
    }

    private long reachZZZ() {
        int count = 0;
        List<Integer> cycle = new ArrayList<>();
        while (true) {
            for (int i = 0; i < aNodes.size(); i++) {
                Direction node = directionMap.get(aNodes.get(i));
                Direction next = instructions[count % instructions.length] == 'L' ? node.left : node.right;
                if(next.name.endsWith("Z")){
                    cycle.add(count+1);
                }
                aNodes.set(i, next.name);
            }
            if(cycle.size()==aNodes.size()){
                break;
            }
            count++;

        }
        int []arr = new int[cycle.size()];
        for(int x=0;x<cycle.size();x++) arr[x] = cycle.get(x);
        return lcm_of_array_elements(arr);


    }

    public long lcm_of_array_elements(int[] element_array)
    {
        long lcm_of_array_elements = 1;
        int divisor = 2;

        while (true) {
            int counter = 0;
            boolean divisible = false;

            for (int i = 0; i < element_array.length; i++) {

                // lcm_of_array_elements (n1, n2, ... 0) = 0.
                // For negative number we convert into
                // positive and calculate lcm_of_array_elements.

                if (element_array[i] == 0) {
                    return 0;
                }
                else if (element_array[i] < 0) {
                    element_array[i] = element_array[i] * (-1);
                }
                if (element_array[i] == 1) {
                    counter++;
                }

                // Divide element_array by devisor if complete
                // division i.e. without remainder then replace
                // number with quotient; used for find next factor
                if (element_array[i] % divisor == 0) {
                    divisible = true;
                    element_array[i] = element_array[i] / divisor;
                }
            }

            // If divisor able to completely divide any number
            // from array multiply with lcm_of_array_elements
            // and store into lcm_of_array_elements and continue
            // to same divisor for next factor finding.
            // else increment divisor
            if (divisible) {
                lcm_of_array_elements = lcm_of_array_elements * divisor;
            }
            else {
                divisor++;
            }

            // Check if all element_array is 1 indicate
            // we found all factors and terminate while loop.
            if (counter == element_array.length) {
                return lcm_of_array_elements;
            }
        }
    }

    private void processDirections(String line) {
        String[] lines = line.split("=");
        String name = lines[0].trim();

        if (!directionMap.containsKey(name)) {
            directionMap.put(name, new Direction(name));
        }
        Direction d = directionMap.get(name);
        String[] lr = lines[1].split(",");
        String left = lr[0].trim().replace("(", "");
        String right = lr[1].trim().replace(")", "");
        if (!this.directionMap.containsKey(left)) {
            directionMap.put(left, new Direction(left));
        }
        d.left = directionMap.get(left);
        if (!this.directionMap.containsKey(right)) {
            directionMap.put(right, new Direction(right));
        }
        d.right = directionMap.get(right);


    }

    public void setInstructions(String line) {
        this.instructions = line.toCharArray();
    }
}
