package library;

import java.util.ArrayList;
import java.util.List;

public class MovieRepository {
    private List<Movie> movieList;

    public MovieRepository() {
        this.movieList = new ArrayList<Movie>();
    }

    public void initMovieList() {
        this.movieList.add(new Movie("00001", "movie1", "director1", "***       ", 1987));
        this.movieList.add(new Movie("00002", "movie2", "director2", "***       ", 1987));
        this.movieList.add(new Movie("00003", "movie3", "director3", "****      ", 1991));
        this.movieList.add(new Movie("00004", "movie4", "director4", "********  ", 1995));
        this.movieList.add(new Movie("00005", "movie5", "director5", "**********", 2010));
        this.movieList.add(new Movie("00006", "movie6", "director6", "******    ", 1998));
        this.movieList.add(new Movie("00007", "movie7", "director7", "N/A       ", 2012));
        this.movieList.add(new Movie("00008", "movie8", "director8", "N/A       ", 2012));
        this.movieList.add(new Movie("00009", "movie9", "director9", "***       ", 1987));
        this.movieList.add(new Movie("00010", "movie10", "director10", "*****    ", 1989));
        this.movieList.add(new Movie("00011", "movie11", "director11", "*****    ", 1987));
        this.movieList.add(new Movie("00012", "movie12", "director12", "*****    ", 1987));
        this.movieList.add(new Movie("00013", "movie13", "director13", "*****    ", 1987));
        this.movieList.add(new Movie("00014", "movie14", "director14", "******   ", 2011));
        this.movieList.add(new Movie("00015", "movie15", "director15", "**       ", 1993));

    }

    public List<Movie> getMovieList() {
        return movieList;
    }

    public void showMovies() {
        if (this.movieList == null) {
            System.out.println("No movies in the library!");
        }
//        System.out.println("Movies in this library:");
        System.out.println("Id\t\tMovie\t\tYear\t\tDirector\t\tRating");
        for (Movie movie : movieList) {
            System.out.println(movie.getId() + "\t\t" + movie.getName() + "\t\t" + movie.getYear() + "\t\t" + movie.getDirector() + "\t\t" + movie.getRating());
        }

    }

    public Movie findMovie(String movieId) {
        for (Movie movie: movieList)
        {
            if (movie.getId().equals(movieId))
                return movie;
        }
        return null;
    }

    public boolean isMovieInMovieList(String selectedMovieId) {
        for (Movie movie: movieList)
        {
            if (movie.getId().equals(selectedMovieId))
                return true;
        }
        return false;
    }
}
