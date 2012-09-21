package test;

import library.AllCustomer;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class AllCustomerTest {
    private AllCustomer allCustomer;
    @Before
    public void setup() {
        allCustomer = new AllCustomer();
        allCustomer.initCustomerList();
    }
    @Test
    public void testCkeckPasswordByLibraryNumber() {
        String libraryNumber = "111-1112";
        String password = "asdfjkl2";
        assertThat(allCustomer.checkPassword(libraryNumber), is(password));
    }
    @Test
    public void testIsCustomerRegist(){
        String libraryNumber1 = "111-1112";
        String libraryNumber2 = "111-1100";
        String password1 = "asdfjkl2";
        String password2 = "aaaaaaa2";
        assertThat(allCustomer.isCustomerRegist(libraryNumber1, password1),is(true));
        assertThat(allCustomer.isCustomerRegist(libraryNumber2, password2),is(false));
    }

}
