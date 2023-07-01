package ProductCatalogueManagement;

import ProductCataloague.Product;
import Stores.MyStore;
import Users.UserWriter;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ProductCatalogueManagement implements Serializable {
    private static String path="Database/";

    protected static HashMap<Product, Boolean> hashMap = new HashMap<>();

    public ProductCatalogueManagement() {
    }

    public ProductCatalogueManagement(String storeLocation) {

        LoadDataIntoHashMap(storeLocation);
    }

    public void setHashMap(HashMap<Product, Boolean> hashMap) {
        this.hashMap = hashMap;
    }

    public HashMap<Product, Boolean> getHashMap() {

        return hashMap;
    }

    public static void WriteHashMapToFile(HashMap<Product, Boolean> productSet, String fileName) {

        File f = new File(path + fileName + "Store.ser");
        try {
            FileOutputStream fout = new FileOutputStream(f);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fout);

            objectOutputStream.writeObject(productSet);
            fout.close();

            objectOutputStream.flush();
            objectOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public static void viewHashmapFromFile(String storeLocation) {
        try {
            FileInputStream fin = new FileInputStream(path + storeLocation + "Store.ser");
            ObjectInputStream oin = new ObjectInputStream(fin);

            hashMap = (HashMap<Product, Boolean>) oin.readObject();
            int count = 0;
            for (Map.Entry<Product, Boolean> product : hashMap.entrySet()) {
                count++;
                System.out.println(product.getKey().toString());


            }
            System.out.println("============================Count ==============================" + count);
            System.out.println("=============================End of Loop========================");

            fin.close();
            oin.close();

        } catch (Exception ex) {
            System.out.println("File with This Name Not exist");
        }

    }

    public static HashMap<Product, Boolean> LoadDataIntoHashMap(String storeLocation) {
        File f = new File(path + storeLocation + "Store.ser");
        try {
            if (!f.exists()) {
                f.createNewFile();
            } else {
                try {
                    FileInputStream fin = new FileInputStream(path + storeLocation + "Store.ser");
                    ObjectInputStream oin = new ObjectInputStream(fin);

                    HashMap<Product, Boolean> tempHashMap = (HashMap<Product, Boolean>) oin.readObject();
                    hashMap.clear();
                    hashMap.putAll(tempHashMap);

                    fin.close();
                    oin.close();

                    return hashMap;

                } catch (EOFException e) {

                }
                catch (Exception ex) {

                    JOptionPane.showMessageDialog(null, "No store found exception in UserWriter");
                }
            }

        } catch (Exception ex) {
            System.out.println("File with This Name Not exist");
        }
        return null;
    }


    public static void updateItemQuantityAfterBuy(String productBrand, String storeLocation, int quantity) {
        for (Map.Entry<Product, Boolean> product : hashMap.entrySet()) {

            //matching product
            if (product.getKey().getBrand().equalsIgnoreCase(productBrand)) {

                //updating quantity
                product.getKey().setQuantity(product.getKey().getQuantity() - quantity);

                hashMap.put(product.getKey(), product.getKey().isStatus());
                WriteHashMapToFile(hashMap, storeLocation);
                break;

            }


        }


    }

    public static void updateItemFromFile(String productBrand, String storeLocation, int choice) {
        boolean found = false;
        for (Map.Entry<Product, Boolean> product : hashMap.entrySet()) {

            if (product.getKey().getBrand().equalsIgnoreCase(productBrand)) {
                found = true;

                switch (choice) {
                    case 1: {

                        String quantity = JOptionPane.showInputDialog(null, "Enter new quantity of product");
                        while (quantity == null) {
                            quantity = JOptionPane.showInputDialog(null, "Invalid input\nEnter new quantity of product");

                        }
                        product.getKey().setQuantity(Integer.parseInt(quantity));
                        hashMap.put(product.getKey(), product.getKey().isStatus());
                        WriteHashMapToFile(hashMap, storeLocation);
                        break;
                    }
                    case 2: {
                        String price = JOptionPane.showInputDialog(null, "Enter new Price");
                        while (price == null) {
                            price = JOptionPane.showInputDialog(null, "Invalid input\nEnter new Price");

                        }
                        product.getKey().setPrice(Integer.parseInt(price));
                        hashMap.put(product.getKey(), product.getKey().isStatus());
                        WriteHashMapToFile(hashMap, storeLocation);
                        break;
                    }

                    default: {
                        break;
                    }
                }
            }
        }
        if (found == false) {
            JOptionPane.showMessageDialog(null, "Product not Found");

        } else {
            JOptionPane.showMessageDialog(null, "Update Successfully");

            System.out.println("==================================================");
        }
    }

    public static void updateStatus(String brandName, String storeLocation) {
        boolean found = false;
        boolean statusUpdate;
        for (Map.Entry<Product, Boolean> product : hashMap.entrySet()) {
            if (product.getKey().getBrand().equalsIgnoreCase(brandName)) {
                found = true;
                Object[] options = {"Set True", "Set False"};

                // Show the JOptionPane with custom buttons
                int result = JOptionPane.showOptionDialog(null,
                        "Choose status:", "Setting Product Status",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
                        null, options, options[0]);

                if (result == 0) {
                    statusUpdate = true;
                } else if (result == 1) {
                    statusUpdate = false;
                } else {
                    JOptionPane.showMessageDialog(null, "No option was selected");
                    return;
                }

                product.getKey().setStatus(statusUpdate);
                hashMap.put(product.getKey(), product.getKey().isStatus());
                break;
            }
        }
        if (found == false) {
            JOptionPane.showMessageDialog(null, "Product Not Found ");
        }
        else {
            WriteHashMapToFile(hashMap, "ProductCatalogue");

            ArrayList<MyStore> stores = new ArrayList<>();
            stores= UserWriter.LoadStoresList(stores);

            for (MyStore store  : stores){

                ProductCatalogueManagement.WriteHashMapToFile(hashMap, store.getLocation());


            }


            System.out.println("==========================Update Succesfully========================");
        }

    }

    //================================Remove Product From Map====================================
    public static void removeProductFromStoreFile(String productBrand, String storeLocation) {
        boolean found = false;

        for (Map.Entry<Product, Boolean> product : hashMap.entrySet()) {
            if (product.getKey().getBrand().equalsIgnoreCase(productBrand)) {
                found = true;
                hashMap.remove(product.getKey());
                break;

            }
        }
        if (found == false) {
            JOptionPane.showMessageDialog(null, "Product Not Found ");
        } else {
            WriteHashMapToFile(hashMap, storeLocation);
            System.out.println("=================Product Removed=======================");
        }
    }

    public static Product SearchItem(String brandName, String storeLocation) {
        boolean found = false;
        try {
            FileInputStream fin = new FileInputStream(path + storeLocation + "Store.ser");
            ObjectInputStream oin = new ObjectInputStream(fin);

            hashMap = (HashMap<Product, Boolean>) oin.readObject();
            for (Map.Entry<Product, Boolean> product : hashMap.entrySet()) {
                if (product.getKey().getBrand().equalsIgnoreCase(brandName)) {
                    found = true;
                    System.out.println(product.toString());


                    return product.getKey();
                }
            }

            fin.close();
            oin.close();
        } catch (EOFException e) {
            System.out.println("Reach At the end ");
        } catch (Exception ex) {
            System.out.println("File with This Name Not exist");
        }
        return null;
    }

    public static void makeNewStore() {


        WritingProdcutCatalogueToNewStore b = new WritingProdcutCatalogueToNewStore();
        hashMap = b.getHashMap();
        WriteHashMapToFile(hashMap, "ProductCatalogue");
    }

   // public static void main(String[] args) {
//        ProductCatalogueManagement pr=new ProductCatalogueManagement();
//        WritingProdcutCatalogueToNewStore writingProdcutCatalogueToNewStore=new WritingProdcutCatalogueToNewStore();
////        ProductCatalogueManagement.LoadDataIntoHashMap("Productcatalogue");
    //    ProductCatalogueManagement.makeNewStore();
////        ProductCatalogueManagement.SearchItem("Rice","Productcatalogue");
////        HashMap<Product,Boolean> hashMap1=writingProdcutCatalogueToNewStore.getHashMap();
//
   //     ProductCatalogueManagement.viewHashmapFromFile("ProductCatalogue");
//
//
//    }

}
