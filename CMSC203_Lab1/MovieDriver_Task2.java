
/*
 * Class: CMSC203 CRN 40398
 * Program: Lab 1
 * Instructor: Professor Eivazi
 * Summary of Description: Write a program that reads input for multiple movies. Prompt the user to enter the name and rating of a movie.
 * Then, ask the user for the number of tickets sold for that movie. Finally, continue to ask the user if they wish to enter another movie
 * until they indicate no, or "n" to end the program.
 * Due Date: 07/01/2024
 * Integrity Pledge: I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source.
 * 
*/

import java.util.Scanner;

public class MovieDriver_Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String choice = "y";
        while (choice.equalsIgnoreCase("y")) {
            Movie movie = new Movie();

            System.out.println("Enter the name of a movie: ");
            String title = scanner.nextLine();
            movie.setTitle(title);

            System.out.println("Enter the rating of the movie: ");
            String rating = scanner.nextLine();
            movie.setRating(rating);

            System.out.println("Enter the number of tickets sold for this movie: ");
            int ticketsSold = scanner.nextInt();
            movie.setSoldTickets(ticketsSold);

            System.out.println(movie.toString());

            System.out.println("Do you want to enter another? (y or n): ");
            scanner.nextLine(); // Consume the newline character
            choice = scanner.nextLine();
        }

        scanner.close();
        System.out.println("Goodbye");
    }
}