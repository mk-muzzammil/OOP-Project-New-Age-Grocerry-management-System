package Login_SignUp_Validation;
import Users.Customer;
import Users.Manager;
import Users.UserWriter;
import Users.Person;

import java.util.ArrayList;


public class credentialsVerification {
    private String username, password, type;
    private ArrayList<Person> users;
    private ArrayList<Manager> managers;
    private Manager manager;
    private Customer customer;


    public credentialsVerification(String type) {
        this.type = type;
        users = UserWriter.LoadArrayList(users, type);
    }



    public credentialsVerification(String username, String password, String type) {
        this.username = username;
        this.password = password;
        this.type = type;
        users = UserWriter.LoadArrayList(users, type);
        if (type.equalsIgnoreCase("manager")) {
            this.manager = verfiyManagerLogin();
        }
        else if(type.equalsIgnoreCase("customer")){
            this.customer=verfiyCustomerLogin();
        }
    }

    public credentialsVerification() {

        managers = UserWriter.LoadArrayList(managers);
        for (Manager m: managers){
            System.out.println(m.getUsername());
        }
    }

    public Customer getCustomer() {
        return customer;
    }

    public Manager getManager() {
        return this.manager;
    }


    public boolean verfiyLogin() {
        boolean found = false;
        if (users == null) {
            return found;
        }

        for (Person p : users) {

            if (p.getUsername().equals(username) || p.getEmail().equals(username)) {
                if (p.getPassword().equals(password)) {
                    found = true;
                    return found;
                }
            }
        }
        return found;
    }

    //======================================this function is used for manager Screen Management============================
    public Manager verfiyManagerLogin() {
        boolean found = false;
        if (users == null) {
            return null;
        } else {
            for (Person manager1 : users) {

                if (manager1.getUsername().equals(username) || manager1.getEmail().equals(username)) {
                    if (manager1.getPassword().equals(password)) {
                        found = true;
                        return (Manager) manager1;
                    }
                }
            }
        }

        return null;
    }

    public Customer verfiyCustomerLogin() {
        boolean found = false;
        if (users == null) {
            return null;
        } else {
            for (Person customer1 : users) {

                if (customer1.getUsername().equals(username) || customer1.getEmail().equals(username)) {
                    if (customer1.getPassword().equals(password)) {
                        found = true;
                        return (Customer) customer1;
                    }
                }
            }
        }

        return null;
    }





    public boolean isUnique(String userData) {
        for (Person p : users) {

            if (p.getUsername().equals(userData)) {
                return false;
            } else if (p.getEmail().equals(userData)) {
                return false;
            } else if (p.getCNIC().equals(userData)) {
                return false;
            }


        }
        return true;
    }

    public boolean isUniqueManager(String id) {
        for (Manager m : managers) {

            if (m.getUsername().equals(id)) {
                return false;
            } else if (m.getEmail().equals(id)) {
                return false;
            } else if (m.getId().equals(id)) {
                return false;
            }
        }
        return true;
    }


}

