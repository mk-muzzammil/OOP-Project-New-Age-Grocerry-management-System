package ProductCataloague.Food;
import ProductCataloague.Product;
import java.awt.*;

public abstract class Food extends Product {



    private String type;

    public Food(){

    }

    public Food(int price, String weightUnits, int quantity, String name, boolean status,String brand,String type) {
        super(price, weightUnits, quantity, name, status,brand,"Food");
        this.type=type;

    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    @Override
    public String toString() {
        return "{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                ", weightUnits='" + weightUnits + '\'' +
                ", quantity=" + quantity +
                ", status =" +isStatus() +
                '}';
    }
}
