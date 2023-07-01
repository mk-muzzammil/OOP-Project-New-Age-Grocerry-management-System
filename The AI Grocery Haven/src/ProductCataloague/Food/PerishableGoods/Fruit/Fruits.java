package ProductCataloague.Food.PerishableGoods.Fruit;

import ProductCataloague.Food.PerishableGoods.PerishableGoods;

public abstract class Fruits extends PerishableGoods {
    public Fruits() {
    }

    public Fruits(int price, String weightUnits, int quantity, boolean status,String brand) {
        super(price, weightUnits, quantity,"fruit", status,brand);
    }
}
