package ProductCataloague;
import java.io.Serializable;

public abstract class Product implements Serializable {
    protected String name;
    protected int price;
    protected String weightUnits;
    protected int quantity;
    protected boolean Status;
    protected String brand;
    protected String mainCategory;


    public Product(){

    }



    public Product(int price, String weightUnits, int quantity, String name, boolean status, String brand, String mainCategory){
        this.price=price;
        this.weightUnits=weightUnits;
        this.quantity=quantity;
        this.Status=status;
        this.name=name;
        this.brand=brand;
        this.mainCategory = mainCategory;


    }


    public String getMainCategory() {
        return mainCategory;
    }

    public void setMainCategory(String mainCategory) {
        this.mainCategory = mainCategory;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isStatus() {
        return Status;
    }

    public void setStatus(boolean status) {
        this.Status = status;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getWeightUnits() {
        return weightUnits;
    }

    public void setWeightUnits(String weightUnits) {
        this.weightUnits = weightUnits;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public abstract String toString();
}

