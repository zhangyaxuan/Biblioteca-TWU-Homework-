package library;

import java.io.IOException;
import java.util.Scanner;

public class SystemController {
    public void control(Customer customer, library.BookRepository libraryBookRepository, MovieRepository libraryMovieRepository) throws IOException {
        Scanner scanner2 = new Scanner(System.in);
        while (customer.isLogin()) {
            System.out.println(LibraryMenu.userMenu);
            switch (scanner2.nextInt()) {
                case UserOptions.VIEW_ALL_BOOKS: //view all books the library has
                    System.out.println("Books in this library : ID + Name");
                    libraryBookRepository.showBooks();
                    break;
                case UserOptions.VIEW_ALL_MOVIES:
                    System.out.println("Movies in this library : ID + Name");
                    libraryMovieRepository.showMovies();
                    break;
                case UserOptions.VIEW_ALL_MY_BOOKS:
                    System.out.println("Books in my library : ID: Name");
                    customer.getMyBookRepository().showBooks();
                    break;
                case UserOptions.COLLECT_BOOK:
                    //select a book and add it in customer bookRepository
                    System.out.println("Please input the book id");
                    String selectedBookId = scanner2.next();
                    if (libraryBookRepository.isBookInBookcase(selectedBookId)) {
                        customer.collectBook(libraryBookRepository.findBook(selectedBookId));
                        System.out.println(Notice.bookReserved);
                    } else {
                        System.out.println(Notice.bookNotIn);
                    }
                    break;
                case UserOptions.COLLECT_MOVIE:
                    System.out.println("Please input the movie id");
                    String selectedMovieId = scanner2.next();
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
                    System.out.println("Select a valid option!!");
                    break;
            }
        }
    }
}
