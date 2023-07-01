package ProductCataloague.Food.PerishableGoods.Vegetable;

import ProductCataloague.Food.PerishableGoods.PerishableGoods;

public abstract class Vegetable extends PerishableGoods {
    public Vegetable() {
    }

    public Vegetable(int price, String weightUnits, int quantity, boolean status,String brand) {
        super(price, weightUnits, quantity, "vegetables", status,brand);
    }
}
