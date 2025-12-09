import java.util.Scanner;

public class WatchListManagerDriver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        WatchListManager manager = new WatchListManager();

        int choice = -1;

        do {
            System.out.println("\n=== Movie Watchlist Manager ===");
            System.out.println("1. Add Movie");
            System.out.println("2. Remove Movie");
            System.out.println("3. View Watchlist");
            System.out.println("4. View Unique Genres");
            System.out.println("5. View Recently Added Movies");
            System.out.println("6. Exit");
            System.out.print("Enter selection from 1 to 6: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number from 1 to 6.");
                scanner.nextLine();
                continue;
            }

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter movie title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter genre: ");
                    String genre = scanner.nextLine();
                    manager.addMovie(title, genre);
                    break;

                case 2:
                    System.out.print("Enter movie title to remove: ");
                    String removeTitle = scanner.nextLine();
                    manager.removeMovie(removeTitle);
                    break;

                case 3:
                    manager.displayWatchlist();
                    break;

                case 4:
                    manager.displayGenres();
                    break;

                case 5:
                    manager.displayRecentAdds();
                    break;

                case 6:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 6);

        scanner.close();
    }
}