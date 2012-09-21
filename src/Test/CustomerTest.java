package test;

import library.Customer;
import library.LibraryBook;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CustomerTest {
    @Test
    public void shouldGetCustomerNameAndLibraryUserId()
    {
        Customer customer = new Customer("Nancy", "123456");
        assertThat(customer.getLibraryNumber(), is("Nancy"));
        assertThat(customer.getPassword(), is("123456"));
    }
    @Test
    public void testCollectBook(){
        Customer customer = new Customer("Nancy", "123456");
        assertThat(customer.getMyBookRepository().getBookList().size(), is(0));
        LibraryBook book = new LibraryBook("0003", "JavaScript: The Good Parts");
        customer.collectBook(book);
        assertThat(customer.getMyBookRepository().getBookList().size(),is(1));
        assertThat(customer.getMyBookRepository().findBook("0003"), is(book));
    }
}
