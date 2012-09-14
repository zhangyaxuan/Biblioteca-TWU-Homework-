package Library;

public class LibraryMenu {
    private String[] options;

    public LibraryMenu (){
        this.options = new String[]{"View all books", "View my bookcase", "I want to collect a book", "Logout"};
    }

    public String[] getOptions() {
        return options;
    }
}
