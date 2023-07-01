package ProductCataloague.PersonalHygine;

import ProductCataloague.Product;

public abstract class  PersonalHygiene extends Product {

    public PersonalHygiene(){

    }

    public PersonalHygiene(int price, String weightUnits, int quantity, String name, boolean status, String brand) {
        super(price, weightUnits, quantity, name, status,brand,"personalHygiene");
    }




    public String toString() {
        return "{" +
                "BrandName='" + this.getBrand() + '\'' +
                ", price=" + price +
                ", weightUnits='" + weightUnits + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
