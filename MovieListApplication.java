public class MovieListApplication {
    private CustomArrayList<Movie> movieList;

    public MovieListApplication() {
        movieList = new CustomArrayList<>();
    }

    public CustomArrayList<Movie> getMovieList() {
        return movieList;
    }

    public void setMovieList(CustomArrayList<Movie> movieList) {
        this.movieList = movieList;
    }

    public void addMovie(String title, int releaseYear, double rating) {
        Movie movie = new Movie(title, releaseYear, rating);
        movieList.add(movie);
    }

    public void displayMovies() {
        for (int i = 0; i < movieList.size(); i++) {
            System.out.println(movieList.get(i).toString());
        }
    }

    public double calculateAverageRating() {
        if (movieList.size() == 0) {
            return 0.0;
        }
        double sum = 0;
        for (int i = 0; i < movieList.size(); i++) {
            sum += movieList.get(i).getRating();
        }
        return sum / movieList.size();
    }

    public void removeMovieByTitle(String title) {
        for (int i = 0; i < movieList.size(); i++) {
            if (movieList.get(i).getTitle().equals(title)) {
                movieList.remove(i);
                return;
            }
        }
    }

    public static void main(String[] args) {
        MovieListApplication test = new MovieListApplication();

        test.addMovie("Kyeiwaa part one", 2010, 8.8);
        test.addMovie("Kyeiwaa part two", 1999, 8.7);
        test.addMovie("Kyeiwaa part three", 2014, 8.6);

        System.out.println("All Movies:");
        test.displayMovies();

        System.out.println(String.format("Average Rating: %.2f", test.calculateAverageRating()));



        test.removeMovieByTitle("Kyeiwaa part two");

        System.out.println("All Movies after removal:");
        test.displayMovies();
    }

    
}
