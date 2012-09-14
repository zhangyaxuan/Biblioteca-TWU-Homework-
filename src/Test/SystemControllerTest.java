package Test;

import Library.Bookcase;
import Library.LibraryBook;
import Library.LibraryMenu;
import Library.SystemController;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SystemControllerTest {
    @Test
    public void should_show_welcome_when_application_start(){
        SystemController controller = new SystemController();
    }
    @Test
    public void should_show_all_options_in_menu(){
        LibraryMenu menu = new LibraryMenu();
        SystemController controller = new SystemController();
        controller.showMenu(menu);
    }
    @Test
    public void should_notice_valid_when_select_a_valid_option(){
        SystemController controller = new SystemController();
        LibraryMenu menu = new LibraryMenu();
        assertThat(controller.selectOption(6, menu), is(false));
    }
    @Test
    public void should_show_all_books(){
        SystemController controller = new SystemController();
        Bookcase bookcase = new Bookcase();
        bookcase.getBookList().add(new LibraryBook("0001", "Clean Code"));
        bookcase.getBookList().add(new LibraryBook("0002", "Agile"));
        controller.showBooks(bookcase.getBookList());
    }

}
