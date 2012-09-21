package library;

public class Customer {
    private String libraryNumber;
    private String password;
    private boolean login;
    private BookRepository myBookRepository;
    private MovieRepository myMovieRepository;
    public void setLogin(boolean login) {
        this.login = login;
    }

    public boolean isLogin() {

        return login;
    }

    public Customer(String libraryNumber, String password) {
        this.libraryNumber = libraryNumber;
        this.password = password;
        this.login = false;
        this.myMovieRepository = new MovieRepository();
        this.myBookRepository = new BookRepository();
    }

    public String getLibraryNumber() {
        return libraryNumber;
    }

    public String getPassword() {
        return password;
    }

    public BookRepository getMyBookRepository() {
        return myBookRepository;
    }

    public boolean collectBook(LibraryBook book) {
        myBookRepository.getBookList().add(book);
        return true;
    }


    public boolean collectMovie(Movie selectedMovie) {
        myMovieRepository.getMovieList().add(selectedMovie);
        return true;
    }
}
