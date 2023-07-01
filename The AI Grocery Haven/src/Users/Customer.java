package Users;

public class Customer extends Person{
   private Cart cart=new Cart();
  public Customer() {
    }

    public Customer(String firstName, String lastName, String username, String email, String password, String city, DateOfBirth DOB,String cnic) {
        super(firstName, lastName, username, email, password, city, DOB,cnic);


    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", city='" + city + '\'' +
                ", CNIC='" + CNIC + '\'' +
                ", DOB=" + DOB +
                '}';
    }
}
