package Test;

import Library.AllCustomer;
import Library.Customer;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class AllCustomerTest {
    @Test
    public void should_get_library_number_when_give_a_name() {
        AllCustomer allCustomer = new AllCustomer();
        allCustomer.getCustomerList().add(new Customer("Nancy", "123456"));
        assertThat(allCustomer.checkLibraryNum("Nancy"), is("123456"));
    }
}
