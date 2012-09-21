package test;

import library.BookRepository;
import library.LibraryBook;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BookRepositoryTest {

    @Test
    public void testCheckBookInBookRepositoryOrNot(){
        BookRepository bookRepository = new BookRepository();
        bookRepository.initBookList();
        LibraryBook book = new LibraryBook("0004", "Java");
        assertThat(bookRepository.isBookInBookcase(book.getId()), is(true));
    }
    @Test
    public void shouldGetBookById(){
        BookRepository bookRepository = new BookRepository();
        bookRepository.initBookList();
        LibraryBook book = new LibraryBook("0004", "book4");
        assertThat(bookRepository.findBook("0004"), is(book));
    }
}
