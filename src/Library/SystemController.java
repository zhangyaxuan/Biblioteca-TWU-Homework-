package library;

import java.io.IOException;
import java.util.Scanner;

public class SystemController {
    public void control(Customer customer, library.BookRepository libraryBookRepository, MovieRepository libraryMovieRepository) throws IOException {
        Scanner userScanner = new Scanner(System.in);
        while (customer.isLogin()) {
            System.out.println(LibraryMenu.userMenu);
            switch (userScanner.nextInt()) {
                case UserOptions.VIEW_ALL_BOOKS:
                    notifyMessageWhenSelectOption(UserOptions.VIEW_ALL_BOOKS);
                    libraryBookRepository.showBooks();
                    break;
                case UserOptions.VIEW_ALL_MOVIES:
                    notifyMessageWhenSelectOption(UserOptions.VIEW_ALL_MOVIES);
                    libraryMovieRepository.showMovies();
                    break;
                case UserOptions.VIEW_ALL_MY_BOOKS:
                    notifyMessageWhenSelectOption(UserOptions.VIEW_ALL_MY_BOOKS);
                    BookRepository myBookResitory =  customer.getMyBookRepository();
                    myBookResitory.showBooks();
                    break;
                case UserOptions.COLLECT_BOOK:
                    notifyMessageWhenSelectOption(UserOptions.COLLECT_BOOK);
                    String selectedBookId = userScanner.next();
                    if (libraryBookRepository.isBookInBookcase(selectedBookId)) {
                        customer.collectBook(libraryBookRepository.findBook(selectedBookId));
                        System.out.println(Notice.bookReserved);
                    } else {
                        System.out.println(Notice.bookNotIn);
                    }
                    break;
                case UserOptions.COLLECT_MOVIE:
                    notifyMessageWhenSelectOption(UserOptions.COLLECT_MOVIE);
                    String selectedMovieId = userScanner.next();
                    if (libraryMovieRepository.isMovieInMovieList(selectedMovieId)) {
                        customer.collectMovie(libraryMovieRepository.findMovie(selectedMovieId));
                        System.out.println(Notice.movieReserved);
                    } else {
                        System.out.println(Notice.movieNotIn);
                    }
                    break;
                case UserOptions.LOGOUT:
                    customer.setLogin(false);
                    break;
                default:
                    notifyMessageWhenSelectOption(UserOptions.UNVALID_OPTION);
                    break;
            }
        }
    }

    private void notifyMessageWhenSelectOption(int options){
        switch (options){
            case UserOptions.VIEW_ALL_BOOKS:
                System.out.println("Books in this library : ID + Name");
                break;
            case UserOptions.VIEW_ALL_MOVIES:
                System.out.println("Movies in this library : ID + Name");
                break;
            case UserOptions.VIEW_ALL_MY_BOOKS:
                System.out.println("Books in my library : ID: Name");
                break;
            case UserOptions.COLLECT_BOOK:
                System.out.println("Please input the book id");
                break;
            case UserOptions.COLLECT_MOVIE:
                System.out.println("Please input the movie id");
                break;
            case UserOptions.UNVALID_OPTION:
                System.out.println("Select a valid option!!");
                break;
        }
    }
}
