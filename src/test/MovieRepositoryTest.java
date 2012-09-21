package test;

import library.Movie;
import library.MovieRepository;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MovieRepositoryTest {
    @Test
    public void testCheckBookInBookRepositoryOrNot(){
        MovieRepository movieRepository = new MovieRepository();
        movieRepository.initMovieList();
        Movie movie = new Movie("00001", "movie1", "director1", "***       ", 1987);
        assertThat(movieRepository.isMovieInMovieList(movie.getId()), is(true));
    }
    @Test
    public void shouldGetBookById(){
        MovieRepository movieRepository = new MovieRepository();
        movieRepository.initMovieList();
        Movie movie = new Movie("00001", "movie1", "director1", "***       ", 1987);
        assertThat(movieRepository.findMovie("00001"), is(movie));
    }
}
