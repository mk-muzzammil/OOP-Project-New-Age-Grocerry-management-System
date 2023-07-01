package ProductCataloague.HouseholdCleaning;

public class Detergent extends HouseholdCleaning {
    public Detergent() {
    }

    public Detergent(int price, String weightUnits, int quantity, boolean status, String brandName) {
        super(price, weightUnits, quantity,"deteregent", status, brandName);
    }


}
