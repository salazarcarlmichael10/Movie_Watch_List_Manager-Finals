public class WatchListManager {
    private ArrayList watchlist;
    private LinkedList genresHead;
    private Queue recentlyAdded;

    public WatchListManager() {
        watchlist = new ArrayList();
        genresHead = null;
        recentlyAdded = new Queue();
    }

    public void addMovie(String title, String genre) {
        watchlist.add(title + " (" + genre + ")");

        if (!genreExists(genre)) {
            LinkedList newGenre = new LinkedList(genre);
            if (genresHead == null) {
                genresHead = newGenre;
            } else {
                LinkedList temp = genresHead;
                while (temp.next != null) temp = temp.next;
                temp.next = newGenre;
            }
        }

        recentlyAdded.enqueue(title);
        if (recentlyAdded.size() > 5) {
            recentlyAdded.dequeue();
        }

        System.out.println("Movie added successfully!");
    }

    private boolean genreExists(String genre) {
        LinkedList temp = genresHead;
        while (temp != null) {
            if (temp.getgenreName().equalsIgnoreCase(genre)) return true;
            temp = temp.next;
        }
        return false;
    }

    // UPDATED: Case-insensitive removal + automatic genre cleanup
    public void removeMovie(String title) {
        ArrayList newWatchlist = new ArrayList();
        boolean removed = false;

        for (int i = 0; i < watchlist.size(); i++) {
            String movie = watchlist.get(i);

            String storedTitle = movie.substring(0, movie.indexOf(" (")).trim();

            if (storedTitle.equalsIgnoreCase(title)) {
                removed = true;
                continue;
            }

            newWatchlist.add(movie);
        }

        watchlist = newWatchlist;

        if (removed) {
            System.out.println("Movie removed successfully!");
            rebuildGenres();
        } else {
            System.out.println("Movie not found.");
        }
    }

    // Rebuild genres after movie removals
    private void rebuildGenres() {
        genresHead = null;

        for (int i = 0; i < watchlist.size(); i++) {
            String movie = watchlist.get(i);

            int start = movie.indexOf("(") + 1;
            int end = movie.indexOf(")");
            String genre = movie.substring(start, end).trim();

            if (!genreExists(genre)) {
                LinkedList newNode = new LinkedList(genre);

                if (genresHead == null) {
                    genresHead = newNode;
                } else {
                    LinkedList temp = genresHead;
                    while (temp.next != null) temp = temp.next;
                    temp.next = newNode;
                }
            }
        }
    }

    public void displayWatchlist() {
        if (watchlist.isEmpty()) {
            System.out.println("Your watchlist is empty.");
            return;
        }

        System.out.println("\n--- Your Watchlist ---");
        for (int i = 0; i < watchlist.size(); i++) {
            System.out.println((i + 1) + ". " + watchlist.get(i));
        }
    }

    public void displayGenres() {
        System.out.println("\n--- Genres ---");

        if (genresHead == null) {
            System.out.println("(No genres available)");
            return;
        }

        LinkedList temp = genresHead;
        while (temp != null) {
            System.out.println("- " + temp.getgenreName());
            temp = temp.next;
        }
    }

    public void displayRecentAdds() {
        System.out.println("\n--- Recently Added Movies ---");
        String[] recent = recentlyAdded.getAll();
        for (String title : recent) {
            System.out.println("- " + title);
        }
    }
}