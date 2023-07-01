package ProductCataloague.HouseholdCleaning;

import ProductCataloague.Food.NonPerishableGoods.NonPerishableGoods;

public class DishSoap extends HouseholdCleaning {
    public DishSoap() {
    }

    public DishSoap(int price, String weightUnits, int quantity, boolean status, String brandName) {
        super(price, weightUnits, quantity,"dishSoap", status, brandName);
    }
}
