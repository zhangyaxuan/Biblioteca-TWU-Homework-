package Test;

import Library.Bookcase;
import Library.LibraryBook;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BookcaseTest {
    @Test
    public void should_check_book_is_in_bookcase_or_not()
    {
        Bookcase bookcase = new Bookcase();
        LibraryBook book = new LibraryBook("0004", "Java");
        assertThat(bookcase.isBookInBookcase(book.getId()), is(false));
        bookcase.getBookList().add(book);
        assertThat(bookcase.isBookInBookcase(book.getId()), is(true));
    }
}
