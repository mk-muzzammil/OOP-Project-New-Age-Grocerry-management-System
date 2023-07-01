package ProductCataloague.Food.NonPerishableGoods;
import ProductCataloague.Food.Food;

public abstract class NonPerishableGoods extends Food {

    public NonPerishableGoods() {
    }
    public NonPerishableGoods(int price, String weightUnits, int quantity, String name, boolean status,String brand) {
        super(price, weightUnits, quantity, name, status, brand,"nonPerishable");

    }


}
