package Library;

import java.util.List;
import java.util.Scanner;

public class SystemController {
    public SystemController() {
        showNotice(Notice.welcome);
    }

    public SystemController(Customer customer) {
//        System.out.print(customerName + " ");
//        showNotice(Notice.welcome);
        LibraryMenu menu = new LibraryMenu();
        Bookcase bookcase = new Bookcase();
        //TODO:add books to bookcase
        bookcase.getBookList().add(new LibraryBook("0004", "Java"));
        boolean logout = false;
        while (!logout) {
            showMenu(menu);
            Scanner scanner2 = new Scanner(System.in);
            int optionNum = Integer.parseInt(scanner2.next());
            //if (selectOption(optionNum, menu)) {
            switch (optionNum) {
                case 1: //view all books the library has
                    System.out.println("Books in this library : ID + Name");
                    showBooks(bookcase.getBookList());
                    break;
                case 2:
                    //view books the customer has
                    System.out.println("Books in my library : ID: Name");
                    showBooks(customer.getMyBookcase().getBookList());
                    break;
                case 3:
                    //select a book and add it in customer bookcase
                    System.out.println("Please input the book id");
                    LibraryBook selectedBook = bookcase.findBook(scanner2.next());
                    if (selectedBook != null) {
                        customer.collectBook(selectedBook);
                        System.out.println(Notice.reserved);
                    } else {
                        showNotice(Notice.bookNotIn);
                    }
                    break;
                case 4:
                    logout = true;
                    break;
                default:
                    System.out.println("Select a valid option!!");
            }
        }
        //  }
    }

    private void showNotice(String noticeStr) {
        System.out.println(noticeStr);
        return;
    }

    public void showMenu(LibraryMenu menu) {
//        LibraryMenu menu = new LibraryMenu();
//        for (String option : menu.getOptions()){
        for (int i = 0; i < menu.getOptions().length; i++)
            System.out.println((i + 1) + ". " + menu.getOptions()[i]);
    }

    public boolean selectOption(int optionNum, LibraryMenu menu) {
        if (optionNum < 1 || optionNum > menu.getOptions().length) {
            System.out.println("Select a valid option");
            return false;
        }
        return true;
    }

    public void showBooks(List<LibraryBook> bookList) {

        for (LibraryBook book : bookList) {
            System.out.println(book.getId() + ": " + book.getName());
        }
    }
}

