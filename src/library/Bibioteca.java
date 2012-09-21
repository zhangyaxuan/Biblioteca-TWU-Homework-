package library;

import java.io.IOException;
import java.util.Scanner;

public class Bibioteca {
    public static void main(String args[]) throws IOException{
        System.out.println(Notice.welcome);
        AllCustomer customers = new AllCustomer();
        customers.initCustomerList();
        BookRepository libraryBookRepository = new BookRepository();
        libraryBookRepository.initBookList();
        MovieRepository libraryMovieRepository = new MovieRepository();
        libraryMovieRepository.initMovieList();
        //TODO:init user list
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        while (!exit){
            System.out.println(LibraryMenu.systemMenu);
            switch (scanner.nextInt()) {
                case SystemOptions.VIEW_ALL_BOOKS:
                    libraryBookRepository.showBooks();
                    break;
                case SystemOptions.VIEW_ALL_MOVIES:
                    libraryMovieRepository.showMovies();
                    break;
                case SystemOptions.LOGIN:
                    //TODO: Login
                    System.out.println("Please input your library number");
                    String username = scanner.next();
                    System.out.println("Please input your password");
                    String password = scanner.next();
                    if (customers.isCustomerRegist(username,password)){
                    Customer customer = customers.getCustomer(username);
                    //TODO: 进入Systemcontroller
                        customer.setLogin(true);
                        SystemController systemController = new SystemController();
                        systemController.control(customer, libraryBookRepository, libraryMovieRepository);
                    }
                    else {
                        System.out.println("Do you foget your library number");
                    }
                    break;
                case SystemOptions.CKECK_LIBRARY_NUMBER:
                    System.out.println(Notice.checkLibraryNum);
                    break;
                case SystemOptions.EXIT:
                    System.out.println("Bye");
                    exit = true;
                    break;
                default:
                    System.out.println(Notice.errorInput);
                    break;
            }
        }
    }
}
