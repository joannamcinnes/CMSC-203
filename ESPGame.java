/*
 * Class: CMSC203 CRN: 40398
 * Program: Assignment #1
 * Instructor: Professor Eivazi
 * Description: Create a program that tests your extrasensory perception (ESP). The program should display a list of colors 
 * and then randomly select the name of a color from a file named colors.txt. The program should ask the user to enter the color the computer selected.
 * After the user guesses a color three times, the program should then display the number of times the user guessed correctly.
 * Next, the program should prompt the user to enter their name, a personal description, and the due date of this assignment. 
 * At the end of the program, the user input will be displayed.
 * Due: 06/10/2024
 * Platform/compiler: Eclipse Java
 * I pledge that I have completed the programming assignment independently. I have not copied the code from a student or any source.
 * I have not given my code to any student.
 * Print your Name here: Joanna McInnes
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class ESPGame {

	public static void main(String[] args) {
		Scanner stringScanner = new Scanner(System.in);
		Random randomNumbers = new Random();
		final String COLOR_BLACK = "black";
		final String COLOR_WHITE = "white";
		final String COLOR_GRAY = "gray";
		final String COLOR_SILVER = "silver";
		final String COLOR_MAROON = "maroon";
		final String COLOR_RED = "red";
		final String COLOR_PURPLE = "purple";
		final String COLOR_FUCHSIA = "fuchsia";
		final String COLOR_GREEN = "green";
		final String COLOR_LIME = "lime";
		final String COLOR_OLIVE = "olive";
		final String COLOR_YELLOW = "yellow";
		final String COLOR_NAVY = "navy";
		final String COLOR_BLUE = "blue";
		final String COLOR_TEAL = "teal";
		final String COLOR_AQUA = "aqua";
		
		int correctGuess = 0;
		String userGuess;
		
		System.out.println("CMSC203 Assignment 1: Test your ESP skills!");
		System.out.println("Enter the filename: ");
		System.out.println("There are sixteen colors from a file: ");
		
		// Read color names from file
		try {
			Scanner scannerFile = new Scanner(new File("colors.txt"));
			while (scannerFile.hasNextLine()) {
	    		System.out.println(scannerFile.nextLine());
		}
			scannerFile.close(); 
    	}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		System.out.println("");
		
		// For loop to ask user color input 3 times
		for (int i = 0; i < 3; i++) {
				int count = i + 1;
				System.out.println("Round " + count + "\n");
				System.out.println("I am thinking of a color.\nIs it one of colors listed above?");
				
				// Do while statement to validate the name of a color from the user.
				do {
					System.out.println("Enter your guess: ");
					userGuess = stringScanner.nextLine();
				}
				while (!userGuess.equalsIgnoreCase(COLOR_BLACK) && !userGuess.equalsIgnoreCase(COLOR_WHITE) && !userGuess.equalsIgnoreCase(COLOR_GRAY) 
						&& !userGuess.equalsIgnoreCase(COLOR_SILVER) && !userGuess.equalsIgnoreCase(COLOR_MAROON) && !userGuess.equalsIgnoreCase(COLOR_RED)
						&& !userGuess.equalsIgnoreCase(COLOR_PURPLE) && !userGuess.equalsIgnoreCase(COLOR_FUCHSIA) && !userGuess.equalsIgnoreCase(COLOR_GREEN)
						&& !userGuess.equalsIgnoreCase(COLOR_LIME) && !userGuess.equalsIgnoreCase(COLOR_OLIVE) && !userGuess.equalsIgnoreCase(COLOR_YELLOW)
						&& !userGuess.equalsIgnoreCase(COLOR_NAVY) && !userGuess.equalsIgnoreCase(COLOR_BLUE) && !userGuess.equalsIgnoreCase(COLOR_TEAL) 
						&& !userGuess.equalsIgnoreCase(COLOR_AQUA));
			
				//String computerColor = colors[number];
				int number = randomNumbers.nextInt(16); 
				String randomColor;
				
				// Start the switch statement 
				switch(number) {
					case 0:
						randomColor = COLOR_BLACK;
						break;
					case 1:
						randomColor = COLOR_WHITE;
						break;
					case 2:
						randomColor = COLOR_GRAY;
						break;
					case 3:
						randomColor = COLOR_SILVER;
						break;
					case 4:
						randomColor = COLOR_MAROON;
						break;
					case 5:
						randomColor = COLOR_RED;
						break;	
					case 6:
						randomColor = COLOR_PURPLE;
						break;
					case 7:
						randomColor = COLOR_FUCHSIA;
						break;
					case 8:
						randomColor = COLOR_GREEN;
						break;
					case 9:
						randomColor = COLOR_LIME;
						break;
					case 10:
						randomColor = COLOR_OLIVE;
						break;
					case 11:
						randomColor = COLOR_YELLOW;
						break;
					case 12:
						randomColor = COLOR_NAVY;
						break;
					case 13:
						randomColor = COLOR_BLUE;
						break;
					case 14:
						randomColor = COLOR_TEAL;
						break;
					case 15:
						randomColor = COLOR_AQUA;
						break;
				default:
						randomColor = "";
				}

			System.out.println("\nI was thinking of " + randomColor + ".");
			
			// If statement checking if colors were guessed correctly
			if (userGuess.equalsIgnoreCase(randomColor)) {
				correctGuess++;
			}
		}
		
		// End of for loop
		System.out.println("Game Over");
		System.out.println("\nYou guessed " + correctGuess + " out of 3 colors correctly.");
		
		// Prompting for user input.
		System.out.println("Enter your name: ");
		String name = stringScanner.nextLine();
				
		System.out.println("Describe yourself: ");
		String describe = stringScanner.nextLine();
				
		System.out.println("Due Date: ");
		String dueDate = stringScanner.nextLine();
		
		// End of program. Displays correct guesses and user input.
		System.out.println("User Name: " + name);
		System.out.println("User Description: " + describe);
		System.out.println("Date: " + dueDate);
	}
}

