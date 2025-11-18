//Xandra Quevedo
//11-18-25
//CardGame.java - Main class for the card game

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
		
		Card[] player1Hand = new Card[1];
		for(int i = 0; i < player1Hand.length; i++)
			player1Hand[i] = cardList.getFirst();
            
        Card[] player2Hand = new Card[1];
		for(int i = 0; i < player2Hand.length; i++)
			player2Hand[i] = cardList.getFirst();

		System.out.println("Player 1's hand");
		for(int i = 0; i < player1Hand.length; i++)
			System.out.println(player1Hand[i]);
        System.out.println("Player 2's hand");
        for(int i = 0; i < player2Hand.length; i++)
			System.out.println(player2Hand[i]);

        if (player1Hand[0].getCardValue() > player2Hand[0].getCardValue()) {
            System.out.println("Player 1 wins!");
        }
        else if (player1Hand[0].getCardValue() == player2Hand[0].getCardValue()) {
            System.out.println("It's a draw!");
        }
        else {
            System.out.println("Player 2 wins!");
        }


		
		System.out.println();
        //Edit - Commented this out to remove massive print statement -XQ
		//System.out.println("the deck");
		//cardList.displayList();

        //War – Each player draws the top card, higher card wins the round.

	}//end main

}//end class
