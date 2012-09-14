package Library;

import java.util.ArrayList;
import java.util.List;

public class Bookcase {
    private List<LibraryBook> bookList;
    public Bookcase(){
        this.bookList = new ArrayList<LibraryBook>();

    }
    public List<LibraryBook> getBookList() {
        return this.bookList;
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
}
