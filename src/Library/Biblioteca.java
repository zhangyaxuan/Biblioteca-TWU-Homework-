package Library;
/*
Business Requirements
        The customer should see a welcome when they start the application.
        A customer should have a list of menu options at the start of the application.
        A customer should be able to select a menu option.
        A customer should be notified if they do not select a valid option with “Select a valid option!!”
        A customer should be able to view all books the library has.
        A customer should be able to reserve a book for collection.
        A customer should be notified if their selected book was reserved successfully with “Thank You! Enjoy the book.”
        A customer should be notified if their selected book is not available with “Sorry we don't have that book yet.”
        A customer should be able to check their library number and be notified with “Please talk to Librarian. Thank you.”
*/
import java.io.IOException;
import java.util.Scanner;

public class Biblioteca {
    public static void main(String args[]) throws IOException {
        AllCustomer customers = new AllCustomer();
        //TODO: add customers information
        customers.getCustomerList().add(new Customer("Nancy", "123456"));    //Just for test
        System.out.println(Notice.welcome);
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            System.out.println("a. Login\nb. Forget library number\nc. Exit");
            switch (System.in.read()) {
                case 'a':
                    System.out.println("Please input your library number");
                    Customer customer = customers.getCustomer(scanner.next());
                    if (customer == null) {
                        System.out.println("Do you foget your library number");
                        break;
                    }
                    SystemController controller = new SystemController(customer);
                    break;
                case 'b':
                    System.out.println(Notice.checkLibraryNum);
                    customers.checkLibraryNum(scanner.next());
                    break;
                case 'c':
                    System.out.println("Bye");
                    exit = true;
                    break;
                default:
                    System.out.println(Notice.errorInput);
            }
        }

    }

}
