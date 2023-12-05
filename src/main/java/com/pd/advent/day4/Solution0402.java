package com.pd.advent.day4;

import com.pd.advent.InputUtil;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

public class Solution0402 {
    List<Card> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        Solution0402 s = new Solution0402();
        long output = 0;


        try (BufferedReader reader = InputUtil.readInput("./src/main/resources/day4/input.txt")) {

            String line;

            while ((line = reader.readLine()) != null) {
                s.list.add(s.parseCard(line));
            }
        }

        System.out.println(s.processCards());
    }

    public int processCards() {
        int output = 0;
        for (int i = 0; i < list.size(); i++) {
            Card c = list.get(i);
            int match = c.matches;
            for (int j = i + 1; j < list.size() && j <= i + match; j++) {
                Card c1 = list.get(j);
                c1.quantity = c1.quantity + c.quantity;
            }
            output+=c.quantity;

        }
        return output;
    }

    public Card parseCard(String line) {
        String[] cards = line.split(":");
        String[] bothCards = cards[1].trim().split("\\|");
        String[] winningCards = bothCards[0].trim().split("\\s");
        String[] yourCards = bothCards[1].trim().split("\\s");


        List<Integer> winCard = new ArrayList<>();
        List<Integer> yourCard = new ArrayList<>();

        for (String x : winningCards) {
            if (!x.isBlank() && !x.isEmpty()) {
                winCard.add(Integer.parseInt(x));
            }
        }

        for (String x : yourCards) {
            if (!x.isBlank() && !x.isEmpty()) {
                yourCard.add(Integer.parseInt(x));
            }
        }

        winCard.retainAll(yourCard);
        return new Card(winCard.size());


    }
}
