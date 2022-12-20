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
        if (player1.isStraight()) {
            winningPlayer = 1;
        }

        return winningPlayer;
    }

}
