package ProductCataloague.HouseholdCleaning;

public class WashrooomCleaner extends HouseholdCleaning {
    public WashrooomCleaner() {
    }

    public WashrooomCleaner(int price, String weightUnits, int quantity, boolean status, String brandName) {
        super(price, weightUnits, quantity, "washRoomCleaner", status, brandName);
    }


}
