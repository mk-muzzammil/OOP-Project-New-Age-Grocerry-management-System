package ProductCataloague.HouseholdCleaning;

import ProductCataloague.Product;

public abstract class HouseholdCleaning extends Product {
    public HouseholdCleaning(){

    }

    public HouseholdCleaning(int price, String weightUnits, int quantity, String name, boolean status, String brand) {
        super(price, weightUnits, quantity, name, status,brand,"houseHoldCleaning");
    }



    @Override
    public String toString() {
        return "{" +
                "Brand ='" + this.getBrand() + '\'' +
                ", price=" + price +
                ", weightUnits='" + weightUnits + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
