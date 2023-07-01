package Users;


import java.io.Serializable;

public abstract class Person implements Serializable {
    protected String firstName;
    protected String lastName;
    protected String username;
    protected String email;
    protected String password;
    protected String city;
    protected String CNIC;

    protected DateOfBirth DOB;
    public Person(){

    }

    public Person(String firstName, String lastName, String username, String email, String password, String city, DateOfBirth DOB,String CNIC) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.password = password;
        this.city = city;
        this.DOB = DOB;
        this.CNIC = CNIC;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public DateOfBirth getDOB() {
        return DOB;
    }

    public String getCNIC() {
        return CNIC;
    }

    public void setCNIC(String CNIC) {
        this.CNIC = CNIC;
    }

    @Override
    public abstract String toString();

    public void setDOB(DateOfBirth DOB) {
        this.DOB = DOB;


    }
}





