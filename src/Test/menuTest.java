package Test;

import Library.LibraryMenu;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class menuTest {
    @Test
    public void should_show_menu_options(){
        LibraryMenu libraryMenu = new LibraryMenu();
       // String[] options = new String[] {"View all books", "View my bookcase"};
        String[] options = libraryMenu.getOptions();
        assertThat(options.length, is(4));
        assertThat(options[0], is("View all books"));
    }
}
