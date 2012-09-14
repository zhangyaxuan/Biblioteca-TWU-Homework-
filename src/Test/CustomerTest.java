package Test;

import Library.Customer;
import Library.LibraryBook;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CustomerTest {
    @Test
    public void should_get_customer_name_and_library_userId()
    {
        Customer customer = new Customer("Nancy", "123456");
        assertThat(customer.getName(), is("Nancy"));
        assertThat(customer.getId(), is("123456"));
    }
    @Test
    public void should_get_customer_collect_books(){
        Customer customer = new Customer("Nancy", "123456");
        assertThat(customer.getMyBookcase().getBookList().size(), is(0));
        LibraryBook book = new LibraryBook("0003", "JavaScript: The Good Parts");
        customer.collectBook(book);
        assertThat(customer.getMyBookcase().getBookList().size(),is(1));
    }
}
