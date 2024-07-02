import java.util.Scanner;

public class MovieDriver_Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String choice = "y";
        while (choice.equalsIgnoreCase("y")) {
            Movie movie = new Movie();

            System.out.println("Enter the title of a movie: ");
            String title = scanner.nextLine();
            movie.setTitle(title);

            System.out.println("Enter the rating of the movie: ");
            String rating = scanner.nextLine();
            movie.setRating(rating);

            System.out.println("Enter the number of tickets sold for this movie: ");
            int ticketsSold = scanner.nextInt();
            movie.setSoldTickets(ticketsSold);

            System.out.println(movie.toString());

            System.out.println("Do you want to enter another? (y/n): ");
            scanner.nextLine(); // Consume the newline character
            choice = scanner.nextLine();
        }

        scanner.close();
    }
}