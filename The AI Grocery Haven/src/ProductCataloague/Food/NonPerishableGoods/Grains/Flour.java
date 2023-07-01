package ProductCataloague.Food.NonPerishableGoods.Grains;

public class Flour extends Grain{
    public Flour() {
    }

    public Flour(int price, String weightUnits, int quantity, boolean status,String brand) {
        super(price, weightUnits, quantity, status,brand);
    }
}
