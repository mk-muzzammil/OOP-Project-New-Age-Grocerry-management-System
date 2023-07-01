package ProductCataloague.Food.PerishableGoods.Meats;

import ProductCataloague.Food.PerishableGoods.PerishableGoods;

public abstract class Meats extends PerishableGoods {
    public Meats() {
    }

    public Meats(int price, String weightUnits, int quantity, boolean status,String brand) {
        super(price, weightUnits, quantity, "meats", status,brand);
    }
}
