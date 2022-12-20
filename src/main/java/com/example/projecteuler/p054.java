package com.example.projecteuler;

import java.util.Arrays;
import java.io.IOException;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;

import org.springframework.stereotype.Service;
import org.springframework.core.io.Resource;
import org.springframework.beans.factory.annotation.Value;

@Service
public class p054 {

    @Value("classpath:poker.txt")
    private Resource res;

    public int solveProblem() throws IOException {
        System.out.println("Started the solution process for Problem 54.");
        List<String> lines = Files.readAllLines(Paths.get(res.getURI()), StandardCharsets.UTF_8);
        int player1WinCount = 0;

        for (String line : lines) {
            String[] hands = line.split("\\s+");
            pokerHand player1 = new pokerHand(Arrays.copyOfRange(hands, 0, hands.length / 2));
            pokerHand player2 = new pokerHand(Arrays.copyOfRange(hands, hands.length / 2, hands.length));
            // player1.sortAscValue();
            // System.out.println(Arrays.toString(player1.hand));

            // compare player1Hand with player2Hand
            int winningHandPlayer = compareHands(player1, player2);

            if (winningHandPlayer == 1) {
                player1WinCount++;
            }
        }

        return player1WinCount;
    }

    private int compareHands(pokerHand player1, pokerHand player2) {
        int winningPlayer = 0;
        int player1Evaluation = player1.evaluateHand();
        int player2Evaluation = player2.evaluateHand();
        // Every time only one player has a better hand !!!
        if (player1Evaluation > player2Evaluation) {
            winningPlayer = 1;
        } else if (player1Evaluation == player2Evaluation) {
            if (player1Evaluation == 2) { // One Pair
                if (player1.getFirstPairValue() > player2.getFirstPairValue()) {
                    winningPlayer = 1;
                } else if (player1.getFirstPairValue() == player2.getFirstPairValue()) {
                    winningPlayer = compareKickers(player1.getKicker(), player2.getKicker());
                } else {
                    winningPlayer = 2;
                }
            } else if (player1Evaluation == 3) { // Two Pairs
                // second pair because in pokerHand hand is sorted in ascending order
                if (player1.getSecondPairValue() > player2.getSecondPairValue()) {
                    winningPlayer = 1;
                } else if (player1.getSecondPairValue() == player2.getSecondPairValue()) {
                    winningPlayer = compareKickers(player1.getKicker(), player2.getKicker());
                } else {
                    winningPlayer = 2;
                }
            } else if (player1Evaluation == 4) { // Three of a Kind
                if (player1.getThreeOfAKindValue() > player2.getThreeOfAKindValue()) {
                    winningPlayer = 1;
                } else if (player1.getThreeOfAKindValue() == player2.getThreeOfAKindValue()) {
                    winningPlayer = compareKickers(player1.getKicker(), player2.getKicker());
                } else {
                    winningPlayer = 2;
                }
            } else if (player1Evaluation == 7) { // Full House
                if (player1.getThreeOfAKindValue() > player2.getThreeOfAKindValue()) {
                    winningPlayer = 1;
                } else if (player1.getThreeOfAKindValue() == player2.getThreeOfAKindValue()) {
                    winningPlayer = compareKickers(player1.getKicker(), player2.getKicker());
                } else {
                    winningPlayer = 2;
                }
            }  else if (player1Evaluation == 8) { // Four of a Kind
                if (player1.getFourOfAKindValue() > player2.getFourOfAKindValue()) {
                    winningPlayer = 1;
                } else if (player1.getFourOfAKindValue() == player2.getFourOfAKindValue()) {
                    winningPlayer = compareKickers(player1.getKicker(), player2.getKicker());
                } else {
                    winningPlayer = 2;
                }
            }  else { // High Card, Straight, Flush, Straight Flush
                winningPlayer = compareKickers(player1.getKicker(), player2.getKicker());
            }
        } else {
            winningPlayer = 2;
        }
        
        return winningPlayer;
    }

    private int compareKickers(int player1Kicker, int player2Kicker) {
        int winningPlayer = 0;

        if (player1Kicker > player2Kicker) {
            winningPlayer = 1;
        } else {
            winningPlayer = 2;
        }

        return winningPlayer;
    }

}
