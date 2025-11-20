//Xandra Quevedo 
//Brice Yang
//11-18-25
//CardGame.java - Main class for the card game

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
//import java.util.ArrayList;
//import java.util.List;
import java.util.Scanner;

public class CardGame {
	
	private static LinkList cardList = new LinkList();  // make list

	public static void main(String[] args) {

		// File name to read from
        String fileName = "cards.txt"; // Ensure the file is in the working directory or specify the full path

        // Read the file and create Card objects
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Split the line into components
                String[] details = line.split(","); // Assuming comma-separated values
                if (details.length == 4) {
                    // Parse card details
                    String suit = details[0].trim();
                    String name = details[1].trim();
                    int value = Integer.parseInt(details[2].trim());
                    String pic = details[3].trim();

                    // Create a new Card object
                    Card card = new Card(suit, name, value, pic);

                    // Add the Card object to the list
                    cardList.add(card);
                } else {
                    System.err.println("Invalid line format: " + line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

        // Print the loaded cards
        System.out.println("Cards loaded:");
        cardList.displayList();
		
        //Added counts for rounds and both player's individual wins per round
        int roundCount = 0;
        int player1Wins = 0;
        int player2Wins = 0;
        
        //The game runs while the roundCount is under 3, so three rounds are played
        //Edit on 11/20 - Changed card arrays to single card objects,
        //since there was no reason to use an array for one card
        while (roundCount < 3) {
            //Each player's card is initialized
		    Card player1Hand = cardList.getFirst();
            
            Card player2Hand = cardList.getFirst();

            //Each player's card is printed
		    System.out.println("Player 1's card");
			System.out.println(player1Hand);
            System.out.println("Player 2's card");
		    System.out.println(player2Hand);

            //Compare the card values to determine the round's winner,
            //and increment their win count
            //If it's a draw, no win count is increased
            if (player1Hand.getCardValue() > player2Hand.getCardValue()) {
                System.out.println("Player 1 wins this round!");
                player1Wins++;
            }
      
            else if (player1Hand.getCardValue() == player2Hand.getCardValue()) {
                System.out.println("It's a draw!");
            }
            else {
                System.out.println("Player 2 wins this round!");
                player2Wins++;
            }

            //Increment roundCount to go to the next round
            roundCount++;
            System.out.println();
        }

        //Compare individual player wins to determine the overall winner
        if(player1Wins > player2Wins) {
            System.out.println("Player 1 wins the game!");
        }
        else if (player1Wins == player2Wins) {
            System.out.println("It's a draw! Nobody wins!");
        }
        else {
            System.out.println("Player 2 wins the game!");
        }
		
		System.out.println();
        //Edit - Commented this out to remove massive print statement -XQ
		//System.out.println("the deck");
		//cardList.displayList();

	}//end main

}//end class
