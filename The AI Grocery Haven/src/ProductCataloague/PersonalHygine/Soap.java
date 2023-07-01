package ProductCataloague.PersonalHygine;
import ProductCataloague.PersonalHygine.PersonalHygiene;

public class Soap extends PersonalHygiene {
    public Soap(){

    }

    public Soap(int price, String weightUnits, int quantity, boolean status, String brand) {
        super(price, weightUnits, quantity,"soap", status, brand);
    }


}
