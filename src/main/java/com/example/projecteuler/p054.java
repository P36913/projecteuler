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

    public void solveProblem() throws IOException {
        System.out.println("Started the solution process for Problem 54.");
        List<String> lines = Files.readAllLines(Paths.get(res.getURI()), StandardCharsets.UTF_8);

        for (String line : lines) {
            String[] hands = line.split("\\s+");
            String[] player1Hand = Arrays.copyOfRange(hands, 0, hands.length/2);
            String[] player2Hand = Arrays.copyOfRange(hands, hands.length/2, hands.length);

            //compare player1Hand with player2Hand
        }

    }
}
