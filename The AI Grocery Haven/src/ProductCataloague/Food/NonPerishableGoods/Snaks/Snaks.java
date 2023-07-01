package ProductCataloague.Food.NonPerishableGoods.Snaks;

import ProductCataloague.Food.NonPerishableGoods.NonPerishableGoods;

public abstract class Snaks extends NonPerishableGoods {
    private String brandName;
    public Snaks() {
    }

    public Snaks(int price, String weightUnits, int quantity, boolean status, String brandName) {
        super(price, weightUnits, quantity,"snaks", status,brandName);
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }
}
