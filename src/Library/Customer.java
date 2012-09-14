package Library;

public class Customer {
    private String name;
    private String id;
    private Bookcase myBookcase;
    public Customer(String name, String id) {
        this.name = name;
        this.id = id;
        this.myBookcase = new Bookcase();
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public Bookcase getMyBookcase() {
        return myBookcase;
    }

    public boolean collectBook(LibraryBook book) {
        myBookcase.getBookList().add(book);
        return true;
    }


}
