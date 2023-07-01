package ProductCatalogueManagement;
import ProductCataloague.*;
import ProductCataloague.Food.NonPerishableGoods.Grains.*;
import ProductCataloague.Food.NonPerishableGoods.Snaks.*;
import ProductCataloague.Food.PerishableGoods.Fruit.*;
import ProductCataloague.Food.PerishableGoods.Meats.*;
import ProductCataloague.Food.PerishableGoods.PerishableGoods;
import ProductCataloague.Food.PerishableGoods.Vegetable.*;
import ProductCataloague.HouseholdCleaning.*;
import ProductCataloague.PersonalHygine.*;
import ProductCataloague.Food.PerishableGoods.Dairy.*;

import java.util.HashMap;
public class WritingProdcutCatalogueToNewStore {
    private static HashMap<Product,Boolean> hashMap=new HashMap<>();



    public HashMap<Product,Boolean> getHashMap(){
        return hashMap;
    }
    public WritingProdcutCatalogueToNewStore(){
        Flour flour = new Flour(850,"Kg",10,true,"Floor");
        Lentils lentils = new Lentils(450, "Gram", 20,true,"Lentile");
        Rice rice = new Rice(750,"Kg",15,true,"Rice");
        Wheat wheat = new Wheat(950,"Kg",10,true,"Wheat");


        Buiscuits buiscuits = new Buiscuits(450, "Boxes",10,true,"Bisconi");
        Chips chips = new Chips(100, "Packets", 50, true,"Lays");
        Choclate choclate = new Choclate(75, "Packets", 30,true,"Cadbury");


        Cheese cheese = new Cheese(450,"Grams",20,true,"Cheese");
        Eggs eggs = new Eggs(140, "Dozens", 20,true,"Eggs");
        Milk milk = new Milk(200, "Liters",30,true,"Olpers" );
        Yougurt yougurt = new Yougurt(350,"Kg",30,true,"Adma's Yougurt");


        Apple apple = new Apple(200,"kg",100,true,"Red Apple");
        Bananna bananna = new Bananna(120, "kg", 50,true,"Bananas");
        Mango mango = new Mango(300, "kg", 50,true,"Mangoes");
        Orange orange = new Orange(200, "kg", 50,true,"Oranges");
        WaterMelon waterMelon = new WaterMelon(350, "kg", 25,true,"Water Melon");


        Beef beef = new Beef(1000,"kg",250,true,"Beef");
        Chicken chicken = new Chicken(350,"kg",50,true,"Chicken");
        Fish fish = new Fish(650,"kg",75,true,"Fish");
        Mutton mutton = new Mutton(750,"kg",75,true,"Mutton");


        Cucumber cucumber = new Cucumber(250,"kg",35,true,"Cucumber");
        Onion onion = new Onion(150,"kg",36,true,"Onion");
        Potatos potatos = new Potatos(350,"kg",36,true,"Potatos");
        Tomato tomato = new Tomato(250,"kg",38,true,"Tomato");


        HandSanitizer handSanitizer = new HandSanitizer(500, "ml", 10,true,"Siena");
        Shampoo shampoo = new Shampoo(750, "ml", 50,true,"Sunslik" );
        Soap soap = new Soap(500, "ml", 60,true,"LUX");
        Shampoo shampoo1=new Shampoo();

        Detergent detergent = new Detergent(600, "ml", 60,true,"Tide");
        DishSoap dishSoap = new DishSoap(800, "ml", 50,true,"Dawn" );
        WashrooomCleaner washrooomCleaner = new WashrooomCleaner(900, "ml", 60,true,"Harpic ");

        hashMap.put(rice,rice.isStatus());

        hashMap.put(flour, flour.isStatus());
        hashMap.put(lentils, lentils.isStatus());

        hashMap.put(wheat, wheat.isStatus());
//
        hashMap.put(buiscuits,buiscuits.isStatus());
//
        hashMap.put(chips, chips.isStatus());
//
        hashMap.put(choclate, choclate.isStatus());
//
        hashMap.put(cheese, cheese.isStatus());
//
        hashMap.put(eggs, eggs.isStatus());
//
        hashMap.put(milk, milk.isStatus());
//
        hashMap.put(yougurt, yougurt.isStatus());
//
        hashMap.put(apple,apple.isStatus());

        hashMap.put(bananna,bananna.isStatus());

        hashMap.put(mango, mango.isStatus());

        hashMap.put(orange, orange.isStatus());

        hashMap.put(waterMelon, waterMelon.isStatus());

        hashMap.put(beef, beef.isStatus());

        hashMap.put(chicken, chicken.isStatus());

        hashMap.put(fish,fish.isStatus());

        hashMap.put(mutton,mutton.isStatus());

        hashMap.put(cucumber, cucumber.isStatus());

        hashMap.put(onion,onion.isStatus());

        hashMap.put(potatos,potatos.isStatus());

        hashMap.put(tomato, tomato.isStatus());

        hashMap.put(handSanitizer, handSanitizer.isStatus());

        hashMap.put(shampoo, shampoo.isStatus());


        hashMap.put(soap,soap.isStatus());

        hashMap.put(detergent,detergent.isStatus());

        hashMap.put(dishSoap, dishSoap.isStatus());

        hashMap.put(washrooomCleaner, washrooomCleaner.isStatus());
    }


}
