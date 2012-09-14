package Library;

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

    public String checkLibraryNum(String customerName) {
        for (Customer customer: customerList){
            if(customer.getName().equals(customerName)){
                return customer.getId();
            }
        }
        return null;
    }

    public Customer getCustomer(String id) {
        for (Customer customer: customerList){
            if(customer.getId().equals(id)){
                return customer;
            }
        }
        return null;
    }
}
