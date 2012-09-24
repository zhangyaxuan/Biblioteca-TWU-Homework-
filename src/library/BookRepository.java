package library;

import java.util.ArrayList;
import java.util.List;

public class BookRepository {
    private List<LibraryBook> bookList;
    public BookRepository(){
        this.bookList = new ArrayList<LibraryBook>();

    }
    public List<LibraryBook> getBookList() {
        return this.bookList;
    }

    public void showBooks() {
        if (bookList == null){
            System.out.println("No books in the library!");
        }
//        System.out.println("Books in this library : ID + Name");
        for (LibraryBook book : bookList) {
            System.out.println(book.getId() + ": " + book.getName());
        }
    }

    public Boolean isBookInBookcase(String bookId) {
        for (LibraryBook book: bookList)
        {
            if (book.getId().equals(bookId))
                return true;
        }
        return false;
    }

    public LibraryBook findBook(String bookId) {
        for (LibraryBook book: bookList)
        {
            if (book.getId().equals(bookId))
                return book;
        }
        return null;
    }

    public void initBookList() {
        bookList.add(new LibraryBook("0001", "book1"));
        bookList.add(new LibraryBook("0002", "book2"));
        bookList.add(new LibraryBook("0003", "book3"));
        bookList.add(new LibraryBook("0004", "book4"));
    }
}
