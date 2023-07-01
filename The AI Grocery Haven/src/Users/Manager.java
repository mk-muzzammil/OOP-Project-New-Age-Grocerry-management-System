package Users;

public class Manager extends Person {
   private String id;
   private String salary;

   public Manager() {

    }

    public Manager(String ID, String name, String username,String password, String email, String salary,String location){
        this(name,"",username,email,password,location,new DateOfBirth(" "," ","" ),ID,salary,"");

    }

    public Manager(String firstName, String lastName, String username, String email, String password, String city, DateOfBirth DOB, String id,String sal,String CNIC) {
        super(firstName, lastName, username, email, password, city, DOB,CNIC);
        this.id = id;
        this.salary=sal;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "ID = '" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", city='" + city + '\'' +
                ", DOB=" + DOB +
                '}';
    }
}
