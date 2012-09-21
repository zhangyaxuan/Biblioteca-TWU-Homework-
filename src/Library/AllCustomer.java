package library;

import java.util.ArrayList;
import java.util.List;

public class AllCustomer {
    private List<Customer> customerList;

    public AllCustomer(){
        this.customerList = new ArrayList<Customer>();
    }
    public List<Customer> getCustomerList() {
        return customerList;
    }

    public String checkPassword(String customerName) {
        for (Customer customer: customerList){
            if(customer.getLibraryNumber().equals(customerName)){
                return customer.getPassword();
            }
        }
        return null;
    }

    public boolean isCustomerRegist(String username, String password){
        for (Customer customer: customerList){
            if(customer.getLibraryNumber().equals(username)&&customer.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }

    public Customer getCustomer(String username) {
        for (Customer customer: customerList){
            if(customer.getLibraryNumber().equals(username)){
                return customer;
            }
        }
        return null;
    }

    public void initCustomerList() {
        customerList.add(new Customer("111-1111", "asdfjkl1"));
        customerList.add(new Customer("111-1112", "asdfjkl2"));
        customerList.add(new Customer("111-1113", "asdfjkl3"));
    }
}
