package Users;

import ProductCataloague.Product;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Cart implements Serializable {
    private ArrayList<Product> products=new ArrayList<>();
    private double total;

    public Cart(){
        total=calculateTotal();

    }


    public double calculateTotal(){
        double total=0;
        for (Product product: products){
            total+=(product.getPrice())* product.getQuantity();
        }
        return total;
    }
    public void addProduct(Product p){
        products.add(p);
    }
    public void removeProduct(Product p){
        products.remove(p);
    }


    public ArrayList<Product> getProducts() {
        return products;
    }



    public double getTotal() {
        return total;
    }

}
