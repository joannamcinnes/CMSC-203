
import java.util.Scanner;

public class MovieDriver_Task1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Movie movie = new Movie();

		System.out.println("Enter the title of a movie: ");
		String title = scanner.nextLine();
		movie.setTitle(title);

		System.out.println("Enter the movie's rating: ");
		String rating = scanner.nextLine();
		movie.setRating(rating);

		System.out.println("Enter the number of tickets sold at an unnamed theater: ");
		int ticketsSold = scanner.nextInt();
		movie.setSoldTickets(ticketsSold);

		System.out.println(movie.toString());

		scanner.close();
	}
}
