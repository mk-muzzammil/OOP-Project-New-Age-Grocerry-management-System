package ProductCataloague.Food.PerishableGoods;

import ProductCataloague.Food.Food;

public abstract class PerishableGoods extends Food {
    public PerishableGoods() {
    }

    public PerishableGoods(int price, String weightUnits, int quantity, String name, boolean status,String brand) {
        super(price, weightUnits, quantity, name, status,brand,"perishable");
    }


}
