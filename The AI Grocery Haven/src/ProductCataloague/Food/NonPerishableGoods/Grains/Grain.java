package ProductCataloague.Food.NonPerishableGoods.Grains;

import ProductCataloague.Food.NonPerishableGoods.NonPerishableGoods;

public abstract class Grain extends NonPerishableGoods {
    public Grain() {
    }

    public Grain(int price, String weightUnits, int quantity, boolean status,String brand ) {
        super(price, weightUnits, quantity, "Grain", status,brand);
    }
}
