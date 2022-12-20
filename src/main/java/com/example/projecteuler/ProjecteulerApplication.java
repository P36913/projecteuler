package com.example.projecteuler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class ProjecteulerApplication implements CommandLineRunner {

	@Autowired
	private p054 p054;

	public static void main(String[] args) {
		SpringApplication.run(ProjecteulerApplication.class, args);
	}

	@Override
  	public void run(String... args) throws Exception {
    int player1WinCount = p054.solveProblem();
	System.out.println("Player 1 has won: " + player1WinCount + " games.");
  }

}
