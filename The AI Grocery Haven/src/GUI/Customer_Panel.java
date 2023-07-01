package GUI;

import ProductCataloague.Food.Food;
import ProductCataloague.Product;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import ProductCatalogueManagement.ProductCatalogueManagement;
import Stores.MyStore;
import Users.*;
import GUI.*;


public class Customer_Panel extends JFrame implements ActionListener {
    ImageIcon icon;

    JLabel categoryFilter, grandTotalLabel;
    JButton buyFromCart, placeOrder, confirmCartButton, shopOnline, viewAccount, cart, logOut, food, houseHold, personalHygiene, perishabale, nonPersishable, buy, addToCart, removeFromCart,searchFood;
    JPanel grandTotalPanel, foodFilter, customerMainBUttonPanel, customerNavBar, customerLeftBar, customerFooter;
    JFrame customerPanel;
    JPanel foodCenterPanel;

    //    JPanel  foodCenterPanel, perishabaleCenter, nonPersishableCenter, houseHoldCenter, personalHygieneCenter, cartcenter;
    JTable foodTable;
//            , houseHoldTable, personalHygieneTable, perishabaleTable, nonPersishableTable, viewCartTable;
    //    JScrollPane foodScrollPane, houseHoldScrollPane, personalHygieneScrollPane, perishabaleScrollPane, nonPersishableScrollPane, viewCartScrollPane;
    JScrollPane foodScrollPane;
    JTextField brandTextField, quantityTextField;
    private Customer customer;
    private ArrayList<MyStore> stores;
    private MyStore store;
    private HashMap<Product, Boolean> products;
    ArrayList<Product> cartProduct;
    JFrame cartFrame;
    private String quantity;
    private double totalprice;
    JPanel imageContainer;

    DefaultTableModel model;

    public Customer_Panel() {

        ImageIcon customerScreen = new ImageIcon("images/customer_screen.png");

        JLabel label = new JLabel();
        label.setIcon(customerScreen);

        imageContainer = new JPanel();
        imageContainer.add(label);

        this.loadCurrentCustomer();

        this.fetchingStoreAccToLocation();

        //=======================Loading Loginned Customer====================================
        stores = new ArrayList<>();
        this.stores = UserWriter.LoadStoresList(stores);

        this.store = getStore();
        icon = new ImageIcon("images/Company_Logo.png");
        customerPanel = new JFrame("Task Tracker");
        customerPanel.setSize(1000, 800);
        customerPanel.setIconImage(icon.getImage());
        customerPanel.setLocationRelativeTo(null);
        customerPanel.setLayout(new BorderLayout(0, 1));
        customerPanel.getContentPane().setBackground(Color.WHITE);
        customerPanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        shopOnline = new customButton("Shop");
        cart = new customButton("Cart");
        viewAccount = new customButton("Account");
        logOut = new customButton("Log Out");
        food = new customButton("Food");
        personalHygiene = new customButton("Hygienics");
        houseHold = new customButton("Household");
        searchFood=new customButton("Seach Item");
        perishabale = new customButton("Perishable");
        perishabale.setBackground(Color.green);

        nonPersishable = new customButton("Non Perishable");
        nonPersishable.setBackground(Color.green);

        confirmCartButton = new customButton("Confirm");
        placeOrder = new customButton("Place Order");
        buyFromCart = new customButton("Check Out");

        categoryFilter = new JLabel();
        categoryFilter.setText("Filter");
        categoryFilter.setBackground(Color.BLACK);
        categoryFilter.setForeground(Color.WHITE);

        grandTotalLabel = new JLabel();
        grandTotalLabel.setForeground(Color.WHITE);
        grandTotalLabel.setBackground(Color.BLACK);


        buy = new customButton("Buy");
        addToCart = new customButton("Add to Cart");
        removeFromCart = new customButton("Remove Product");


        shopOnline.setPreferredSize(new Dimension(80, 20));
        cart.setPreferredSize(new Dimension(80, 20));
        viewAccount.setPreferredSize(new Dimension(80, 20));
        logOut.setPreferredSize(new Dimension(100, 20));
        food.setPreferredSize(new Dimension(130, 30));
        personalHygiene.setPreferredSize(new Dimension(130, 30));
        houseHold.setPreferredSize(new Dimension(130, 30));
        perishabale.setPreferredSize(new Dimension(150, 20));
        nonPersishable.setPreferredSize(new Dimension(150, 20));
       searchFood.setPreferredSize(new Dimension(150, 20));


        foodFilter = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 20));
        foodFilter.setBackground(Color.BLACK);
        foodFilter.add(categoryFilter);
        foodFilter.add(perishabale);
        foodFilter.add(nonPersishable);


        grandTotalPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 20));
        grandTotalPanel.add(grandTotalLabel);
        grandTotalPanel.setBackground(Color.BLACK);


        customerMainBUttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 20));
        customerMainBUttonPanel.setBackground(Color.BLACK);
        customerMainBUttonPanel.add(shopOnline);
        customerMainBUttonPanel.add(cart);
        customerMainBUttonPanel.add(viewAccount);
        customerMainBUttonPanel.add(logOut);
        customerMainBUttonPanel.add(searchFood);

        customerNavBar = new JPanel(new BorderLayout());
        customerNavBar.setPreferredSize(new Dimension(customerPanel.getWidth(), 60));
        customerNavBar.setBackground(Color.BLACK);

        customerNavBar.add(customerMainBUttonPanel, BorderLayout.WEST);
        customerNavBar.add(foodFilter, BorderLayout.EAST);
        customerNavBar.add(grandTotalPanel, BorderLayout.CENTER);


        customerLeftBar = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 17));
        customerLeftBar.setPreferredSize(new Dimension(160, customerPanel.getHeight()));
        customerLeftBar.setBackground(Color.ORANGE);

        customerLeftBar.add(food);
        customerLeftBar.add(houseHold);
        customerLeftBar.add(personalHygiene);

        foodCenterPanel = new JPanel(new BorderLayout());
        foodCenterPanel.setBackground(Color.WHITE);


        model = new DefaultTableModel();



        customerFooter = new JPanel(new FlowLayout(FlowLayout.CENTER));
        customerFooter.setPreferredSize(new Dimension(customerPanel.getWidth(), 40));
        customerFooter.setBackground(Color.BLACK);
        customerFooter.add(buy);
        customerFooter.add(addToCart);
        customerFooter.add(removeFromCart);
        customerFooter.add(buyFromCart);

        model = new DefaultTableModel();


        shopOnline.addActionListener(this);
        viewAccount.addActionListener(this);
        cart.addActionListener(this);
        addToCart.addActionListener(this);
        removeFromCart.addActionListener(this);
        buy.addActionListener(this);
        logOut.addActionListener(this);
        food.addActionListener(this);
        personalHygiene.addActionListener(this);
        houseHold.addActionListener(this);
        perishabale.addActionListener(this);
        nonPersishable.addActionListener(this);
        confirmCartButton.addActionListener(this);
        placeOrder.addActionListener(this);
        buyFromCart.addActionListener(this);
        searchFood.addActionListener(this);

        customerLeftBar.setVisible(false);


        foodCenterPanel.setVisible(false);
        customerFooter.setVisible(false);
        foodFilter.setVisible(false);
        grandTotalPanel.setVisible(false);


        customerPanel.add(customerLeftBar, BorderLayout.WEST);
        customerPanel.add(customerNavBar, BorderLayout.NORTH);
        customerPanel.add(imageContainer, BorderLayout.CENTER);
        customerPanel.setVisible(true);

    }


    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public void actionPerformed(ActionEvent e) {
        imageContainer.setVisible(false);
        customerFooter.remove(buy);
        customerFooter.remove(addToCart);
        customerFooter.remove(buyFromCart);
        customerFooter.remove(removeFromCart);


        grandTotalPanel.setVisible(false);
        customerFooter.setVisible(false);
        foodFilter.setVisible(false);


        if (e.getSource() == shopOnline) {

            customerPanel.revalidate();

            foodCenterPanel.setVisible(false);


            customerLeftBar.setVisible(true);


            customerPanel.revalidate();


        } else if (e.getSource() == food) {


            model.setColumnCount(0);
            model.setRowCount(0);

            foodFilter.setVisible(true);
            customerFooter.setVisible(true);

            customerFooter.add(buy);
            customerFooter.add(addToCart);


            customerPanel.revalidate();


            customerLeftBar.setVisible(true);
            foodCenterPanel.setVisible(true);

            fetchingStoreAccToLocation();
            //Creating Table and setting table
            String[][] rows = getRequiredProduct("Food");
            String[] coloumns = {"Name", "Price", "Weight Units", "Availability", "Brand"};

            model.setColumnIdentifiers(coloumns);

            for (String[] row : rows) {
                model.addRow(row);
            }


            foodTable = new JTable(model);


            // Custom header renderer to change the color
            DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
            headerRenderer.setBackground(Color.BLUE);
            headerRenderer.setForeground(Color.WHITE);
            headerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
            foodTable.getTableHeader().setDefaultRenderer(headerRenderer);

            foodScrollPane = new JScrollPane(foodTable);
            foodScrollPane.setBorder(BorderFactory.createEmptyBorder()); // Remove border around scroll pane
            foodCenterPanel.add(foodScrollPane);


            customerPanel.add(foodCenterPanel, BorderLayout.CENTER);
            customerPanel.add(customerFooter, BorderLayout.SOUTH);


            customerPanel.revalidate();


        }
        else if(e.getSource() == searchFood){

            String brandName=JOptionPane.showInputDialog(null,"Enter brand Name of item ");

            while(brandName==null){
                 brandName=JOptionPane.showInputDialog(null,"Enter brand Name of item Again ur field is empty ");

            }

            System.out.printf("brandName "+brandName);
            Product product=ProductCatalogueManagement.SearchItem(brandName,getCustomer().getCity());

            if(product==null){
                JOptionPane.showMessageDialog(null,"Item not available with this brand Name ");
            }
            else{
                JOptionPane.showMessageDialog(null,"Item found with this information: \n +"+"Product Type:" +product.getName() +"\nProduct Quantity ::" +product.getQuantity()+"\nProduct Price :" + product.getPrice()+"\nproduct WeightUnits  :"+product.getWeightUnits());



            }











        }
        else if (e.getSource() == perishabale) {

            model.setRowCount(0);
            model.setColumnCount(0);

            foodFilter.setVisible(true);
            customerFooter.setVisible(true);

            customerFooter.add(buy);
            customerFooter.add(addToCart);


            customerPanel.revalidate();
            // foodNavBar.setVisible(true);
            customerPanel.revalidate();

            foodCenterPanel.setVisible(true);

            customerLeftBar.setVisible(true);
            fetchingStoreAccToLocation();

            //Creating Table and setting table
            String[][] rows = getRequiredFoodProduct("Food", "perishable");
            String[] coloumns = {"Name", "Price", "Weight Units", "Availability", "Brand"};

            model.setColumnIdentifiers(coloumns);

            for (String[] row : rows) {
                model.addRow(row);
            }

            foodTable = new JTable(model);


            // Custom header renderer to change the color
            DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
            headerRenderer.setBackground(Color.BLUE);
            headerRenderer.setForeground(Color.WHITE);
            headerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
            foodTable.getTableHeader().setDefaultRenderer(headerRenderer);

            foodScrollPane = new JScrollPane(foodTable);
            foodScrollPane.setBorder(BorderFactory.createEmptyBorder()); // Remove border around scroll pane

            foodCenterPanel.add(foodScrollPane);


            //  perishabaleCenter.add(foodNavBar, BorderLayout.NORTH);
            customerPanel.add(foodCenterPanel, BorderLayout.CENTER);
            customerPanel.add(customerFooter, BorderLayout.SOUTH);

            customerPanel.revalidate();

        } else if (e.getSource() == nonPersishable) {
            model.setColumnCount(0);
            model.setRowCount(0);

            foodFilter.setVisible(true);
            customerFooter.setVisible(true);
            customerPanel.revalidate();

            customerFooter.add(buy);
            customerFooter.add(addToCart);


            foodCenterPanel.setVisible(true);


            customerLeftBar.setVisible(true);

            fetchingStoreAccToLocation();
            //Creating Table and setting table
            String[][] rows = getRequiredFoodProduct("Food", "nonPerishable");
            String[] coloumns = {"Name", "Price", "Weight Units", "Availability", "Brand"};

            model.setColumnIdentifiers(coloumns);

            for (String[] row : rows) {
                model.addRow(row);
            }


            foodTable = new JTable(model);


            // Custom header renderer to change the color
            DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
            headerRenderer.setBackground(Color.BLUE);
            headerRenderer.setForeground(Color.WHITE);
            headerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
            foodTable.getTableHeader().setDefaultRenderer(headerRenderer);

            foodScrollPane = new JScrollPane(foodTable);
            foodScrollPane.setBorder(BorderFactory.createEmptyBorder()); // Remove border around scroll pane

            foodCenterPanel.add(foodScrollPane);



            customerPanel.add(foodCenterPanel, BorderLayout.CENTER);

            customerPanel.revalidate();

        } else if (e.getSource() == personalHygiene) {
            model.setRowCount(0);
            model.setColumnCount(0);

            customerFooter.setVisible(true);

            customerFooter.add(buy);
            customerFooter.add(addToCart);

            foodCenterPanel.setVisible(true);

            customerLeftBar.setVisible(true);

            fetchingStoreAccToLocation();
            String[][] rows = getRequiredProduct("personalHygiene");
            String[] coloumns = {"Name", "Price", "Weight Units", "Availability", "Brand"};


            model.setColumnIdentifiers(coloumns);

            for (String[] row : rows) {
                model.addRow(row);
            }

            foodTable = new JTable(model);

            // Custom header renderer to change the color
            DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
            headerRenderer.setBackground(Color.BLUE);
            headerRenderer.setForeground(Color.WHITE);
            headerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
            foodTable.getTableHeader().setDefaultRenderer(headerRenderer);

            foodScrollPane = new JScrollPane(foodTable);
            foodScrollPane.setBorder(BorderFactory.createEmptyBorder()); // Remove border around scroll pane

            foodCenterPanel.add(foodScrollPane);


            customerPanel.revalidate();


            customerPanel.add(foodCenterPanel, BorderLayout.CENTER);
            customerPanel.revalidate();

        } else if (e.getSource() == houseHold) {

            model.setColumnCount(0);
            model.setRowCount(0);


            customerPanel.revalidate();
            customerFooter.setVisible(true);

            customerFooter.add(buy);
            customerFooter.add(addToCart);

            foodCenterPanel.setVisible(true);

            customerLeftBar.setVisible(true);

            fetchingStoreAccToLocation();

            String[][] rows = getRequiredProduct("houseHoldCleaning");
            String[] coloumns = {"Name", "Price", "Weight Units", "Availability", "Brand"};


            model.setColumnIdentifiers(coloumns);

            for (String[] row : rows) {
                model.addRow(row);
            }


            foodTable = new JTable(model);


            // Custom header renderer to change the color
            DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
            headerRenderer.setBackground(Color.BLUE);
            headerRenderer.setForeground(Color.WHITE);
            headerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
            foodTable.getTableHeader().setDefaultRenderer(headerRenderer);

            foodScrollPane = new JScrollPane(foodTable);
            foodScrollPane.setBorder(BorderFactory.createEmptyBorder()); // Remove border around scroll pane

            foodCenterPanel.add(foodScrollPane);


            customerPanel.revalidate();
            customerPanel.add(foodCenterPanel, BorderLayout.CENTER);
            customerPanel.revalidate();

        } else if (e.getSource() == viewAccount) {
            customerPanel.revalidate();
            customerFooter.setVisible(false);

            foodCenterPanel.setVisible(false);

            customerLeftBar.setVisible(false);

            JOptionPane.showMessageDialog(null, "Full Name : " + customer.getFirstName() + " " + customer.getLastName() + "\nUsername :" + customer.getUsername() + "\nEmail        : " + customer.getEmail() + "\nPassword  :" + customer.getPassword() + "\nLocation  : " + customer.getCity());


            customerPanel.revalidate();


        } else if (e.getSource() == cart) {

            model.setColumnCount(0);
            model.setRowCount(0);

            grandTotalLabel.setText("Grand Total: " + getGrandTotal());


            grandTotalPanel.setVisible(true);

            customerPanel.revalidate();

            customerFooter.setVisible(true);

            customerFooter.add(buyFromCart);
            customerFooter.add(removeFromCart);

            customerPanel.revalidate();

            foodCenterPanel.setVisible(true);
//            perishabaleCenter.setVisible(false);
//            nonPersishableCenter.setVisible(false);
            //  foodNavBar.setVisible(false);

//            personalHygieneCenter.setVisible(false);
//            houseHoldCenter.setVisible(false);
            customerLeftBar.setVisible(false);


            String[][] rows = getCustomerCart();
            String[] coloumns = {"Name ", "Price ", "Weight Units", "Brand", "Selected Quantity"};


            model.setColumnIdentifiers(coloumns);


            for (String[] row : rows){
                model.addRow(row);
            }

            foodTable = new JTable(model);


            // Custom header renderer to change the color
            DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
            headerRenderer.setBackground(Color.BLUE);
            headerRenderer.setForeground(Color.WHITE);
            headerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
            foodTable.getTableHeader().setDefaultRenderer(headerRenderer);

            foodScrollPane = new JScrollPane(foodTable);
            foodScrollPane.setBorder(BorderFactory.createEmptyBorder()); // Remove border around scroll pane

            foodCenterPanel.add(foodScrollPane, BorderLayout.CENTER);


          //  cartcenter.setVisible(true);

            customerPanel.add(foodCenterPanel, BorderLayout.CENTER);
            customerPanel.add(customerFooter, BorderLayout.SOUTH);


            customerPanel.revalidate();


        } else if (e.getSource() == addToCart) {
            customerFooter.add(buy);
            customerFooter.add(addToCart);

            customerFooter.setVisible(true);

            cartFrame = new JFrame();
            JLabel brandLabel = new JLabel("Product Brand ");
            brandTextField = new JTextField();
            JLabel quantityLabel = new JLabel("Product Quantity ");
            quantityTextField = new JTextField();


            cartFrame.setSize(200, 200);
            brandLabel.setBounds(20, 20, 150, 20);
            brandTextField.setBounds(20, 50, 150, 20);
            quantityLabel.setBounds(20, 80, 170, 20);
            quantityTextField.setBounds(20, 110, 150, 20);
            confirmCartButton.setBounds(45, 140, 100, 20);
            cartFrame.setLocationRelativeTo(null);
            cartFrame.setLayout(null);
            cartFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            cartFrame.setVisible(true);
            cartFrame.add(brandLabel);
            cartFrame.add(brandTextField);
            cartFrame.add(quantityLabel);
            cartFrame.add(quantityTextField);
            cartFrame.add(confirmCartButton);


        } else if (e.getSource() == confirmCartButton) {
            customerFooter.add(buy);
            customerFooter.add(addToCart);

            customerFooter.setVisible(true);

            String brandNameText = brandTextField.getText();
            String brandNameQuantity = quantityTextField.getText();


            if (!brandTextField.getText().isEmpty() && !quantityTextField.getText().isEmpty()) {
                Product p = ProductCatalogueManagement.SearchItem(brandNameText, getCustomer().getCity());
                if (p != null) {

                    if (Integer.parseInt(brandNameQuantity) <= p.getQuantity() && Integer.parseInt(brandNameQuantity) > 0) {

                        ArrayList<Customer> customers = new ArrayList<>();
                        customers = UserWriter.LoadArrayList1(customers);

                        for (Customer customer : customers) {
                            if (customer.getUsername().equalsIgnoreCase(getCustomer().getUsername())) {
                                p.setQuantity(Integer.parseInt(brandNameQuantity));
                                customer.getCart().addProduct(p);

                                //updating current logged customer
                                getCustomer().getCart().addProduct(p);

                            }

                        }

                        //if Glitch resolved, update current logged in Customer file
                        Login_Screen currntUpdation = new Login_Screen();
                        currntUpdation.writeCustomertoFile(getCustomer());

                        //updating All customers File
                        UserWriter.WriteCustomerToFile(customers);
                        cartFrame.dispose();


                    } else {
                        JOptionPane.showMessageDialog(null, "Quantity error");

                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Product does not exist");
                }

            } else {
                JOptionPane.showMessageDialog(null, "Some of the fields are empty");

            }


        } else if (e.getSource() == removeFromCart) {
            customerFooter.add(buyFromCart);
            customerFooter.add(removeFromCart);

            customerFooter.setVisible(true);
            String removeProduct = JOptionPane.showInputDialog(null, "Enter Product Brand name:");

            if (removeProduct != null) {

                ArrayList<Customer> customers = new ArrayList<>();
                customers = UserWriter.LoadArrayList1(customers);

                for (Customer customer : customers) {
                    if (customer.getUsername().equalsIgnoreCase(getCustomer().getUsername())) {
                        ArrayList<Product> pro = customer.getCart().getProducts();
                        for (Product p : pro) {
                            if (removeProduct.equalsIgnoreCase(p.getBrand())) {
                                customer.getCart().getProducts().remove(p);
                                break;
                            }
                        }

                    }

                }
                UserWriter.WriteCustomerToFile(customers);

            } else {
                JOptionPane.showMessageDialog(null, "No input");
            }

        } else if (e.getSource() == buy) {
            customerFooter.add(buy);
            customerFooter.add(addToCart);

            customerFooter.setVisible(true);

            cartFrame = new JFrame();
            cartFrame.setSize(200, 200);
            cartFrame.setTitle("Place Order");
            cartFrame.setLayout(null);
            cartFrame.setLocationRelativeTo(null);
            cartFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


            JLabel brandLabel = new JLabel("Product Brand ");
            JLabel quantityLabel = new JLabel("Enter Quantity ");

            quantityTextField = new JTextField();
            brandTextField = new JTextField();


            brandLabel.setBounds(20, 20, 150, 20);
            quantityLabel.setBounds(20, 80, 170, 20);


            brandTextField.setBounds(20, 45, 150, 20);
            quantityTextField.setBounds(20, 105, 150, 20);
            placeOrder.setBounds(25, 135, 150, 20);


            cartFrame.setVisible(true);
            cartFrame.add(brandLabel);
            cartFrame.add(brandTextField);
            cartFrame.add(quantityLabel);
            cartFrame.add(quantityTextField);
            cartFrame.add(placeOrder);


        } else if (e.getSource() == placeOrder) {

            customerFooter.add(buy);
            customerFooter.add(addToCart);
            customerFooter.setVisible(true);


            String brandNameText = brandTextField.getText();
            String brandNameQuantity = quantityTextField.getText();

            if (!brandTextField.getText().isEmpty() && !quantityTextField.getText().isEmpty()) {
                Product p = ProductCatalogueManagement.SearchItem(brandNameText, getCustomer().getCity());
                if (p != null) {

                    if (Integer.parseInt(brandNameQuantity) <= p.getQuantity() && Integer.parseInt(brandNameQuantity) > 0) {

                        int bill = Integer.parseInt(brandNameQuantity) * p.getPrice();
                        int choice = JOptionPane.showConfirmDialog(cartFrame, "Do you want to proceed?", "Confirmation", JOptionPane.YES_NO_OPTION);

                        if (choice == JOptionPane.YES_OPTION) {
                            JOptionPane.showMessageDialog(cartFrame, "Product Name: " + p.getName() + "\nProduct Brand: " + p.getBrand() + "\nPrice per: " + " " + p.getWeightUnits() + " " + p.getPrice() + "\nTotal Bill: " + bill);

                            ProductCatalogueManagement.updateItemQuantityAfterBuy(brandNameText, getCustomer().getCity(), Integer.parseInt(brandNameQuantity));


                            cartFrame.dispose();
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "Quantity error");

                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Product does not exist");

                }
            } else {
                JOptionPane.showMessageDialog(null, "Required fields are empty");
            }


        } else if (e.getSource() == buyFromCart) {
            customerFooter.add(buyFromCart);
            customerFooter.add(removeFromCart);

            customerFooter.setVisible(true);
            double bill = 0;
            ArrayList<Customer> customers = new ArrayList<>();
            customers = UserWriter.LoadArrayList1(customers);

            for (Customer customer : customers) {
                if (customer.getUsername().equalsIgnoreCase(getCustomer().getUsername())) {
                    bill = customer.getCart().calculateTotal();

                    ArrayList<Product> products = customer.getCart().getProducts();


                    Iterator<Product> iterator = products.iterator();
                    while (iterator.hasNext()) {
                        Product p = iterator.next();
                        ProductCatalogueManagement.updateItemQuantityAfterBuy(p.getBrand(), getCustomer().getCity(), p.getQuantity());
                        iterator.remove();
                        customer.getCart().removeProduct(p);
                    }


                    break;

                }
            }

            JOptionPane.showMessageDialog(null, "Grand Bill: " + bill + "\nThanks for Shopping");

            //if Glitch resolved, update current logged in Customer file
            Login_Screen currntUpdation = new Login_Screen();
            currntUpdation.writeCustomertoFile(getCustomer());

            UserWriter.WriteCustomerToFile(customers);


        } else if (e.getSource() == logOut) {
            customerPanel.dispose();
        }

    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void loadCurrentCustomer() {
        File file = new File("Database/" + "Current Login Customer.ser");
        if (!file.exists()) {
            return;

        } else {
            try {
                ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
                this.setCustomer((Customer) objectInputStream.readObject());

                System.out.println("Customer is setted ");
                objectInputStream.close();


            } catch (Exception e) {
                System.out.println("Current Customer File  Reading problem ");

            }
        }

    }

    public MyStore getStore() {
        for (MyStore s : stores) {
            if (s.getLocation().equalsIgnoreCase(customer.getCity())) {
                return s;
            }
        }
        return null;
    }

    public void fetchingStoreAccToLocation() {
        this.products = ProductCatalogueManagement.LoadDataIntoHashMap(getCustomer().getCity());
        System.out.println(getCustomer().getCity());
        ProductCatalogueManagement.viewHashmapFromFile(getCustomer().getCity());

    }

    public ArrayList<Product> getCartList() {

        System.out.println("Loading cart");

        ArrayList<Customer> per = new ArrayList<>();
        per = UserWriter.LoadArrayList1(per);

        for (Customer p : per) {
            if (p.getUsername().equalsIgnoreCase(getCustomer().getUsername())) {
                ArrayList<Product> products = p.getCart().getProducts();
                return products;


            }
        }
        return null;
    }

    public double getGrandTotal() {
        double price = getCustomer().getCart().calculateTotal();
        System.out.println("Grand total: " + price);
        return price;
    }


    public String[][] getCustomerCart() {
        getCartList();

        String[][] result = new String[getCartList().size()][];
        int i = 0;
        for (Product p : getCartList()) {
            String[] s = new String[5];
            s[0] = p.getName();
            s[1] = String.valueOf(p.getPrice());
            s[2] = p.getWeightUnits();
            s[3] = p.getBrand();
            s[4] = Integer.toString(p.getQuantity());
            result[i++] = s;
        }
        return result;

    }

    public String[][] getRequiredProduct(String productCategory) {
        System.out.println("Flag GetRequired product Function ");
        for (Map.Entry<Product, Boolean> product : products.entrySet()) {
            System.out.println(product.toString());
        }
        int i = 0;
        String[][] result = new String[products.size()][];
        for (Map.Entry<Product, Boolean> product : products.entrySet()) {
            if (product.getKey().getMainCategory().equals(productCategory)) {
                if (product.getKey().isStatus()) {
                    String[] str = new String[5];

                    str[0] = product.getKey().getName();
                    String price = String.valueOf(product.getKey().getPrice());
                    str[1] = price;
                    str[2] = product.getKey().getWeightUnits();
                    if (product.getKey().getQuantity() > 0) {
                        str[3] = "In Stock";

                    } else {
                        str[3] = "Out of Stock";
                    }

                    str[4] = product.getKey().getBrand();

                    result[i++] = str;
                }
            }
        }
        return result;
    }

    public String[][] getRequiredFoodProduct(String productCategory, String foodType) {
        System.out.println("Flag Get Required Food product Function ");
        int i = 0;
        String[][] result = new String[products.size()][];
        HashMap<Food, Boolean> foods = new HashMap<>();
        for (Map.Entry<Product, Boolean> product : products.entrySet()) {

            if ((product.getKey().getMainCategory().equalsIgnoreCase(productCategory))) {
                if (product.getKey().isStatus()) {
                    foods.put((Food) product.getKey(), product.getValue());

                }
            }
        }
        for (Map.Entry<Food, Boolean> food : foods.entrySet()) {
            if (food.getKey().getType().equals(foodType)) {
                if (food.getKey().isStatus()) {
                    String[] str = new String[5];

                    str[0] = food.getKey().getName();
                    String price = String.valueOf(food.getKey().getPrice());
                    str[1] = price;
                    str[2] = food.getKey().getWeightUnits();
                    if (food.getKey().getQuantity() > 0) {
                        str[3] = "In Stock";

                    } else {
                        str[3] = "Out of Stock";
                    }

                    str[4] = food.getKey().getBrand();

                    result[i++] = str;


                }
            }
        }
        return result;
    }

}
