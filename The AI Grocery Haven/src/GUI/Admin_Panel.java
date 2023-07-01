package GUI;


import Login_SignUp_Validation.credentialsVerification;
import ProductCataloague.Product;
import ProductCatalogueManagement.ProductCatalogueManagement;
import Stores.MyStore;
import Users.*;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Admin_Panel extends JFrame implements ActionListener {

    //main panel components
    JFrame adminFrame;
    JPanel leftPanel;
    JButton manageManagers, manageCatalouge, viewAccount, managestores, logOut;


    JPanel adminFooter;
    private JTable maangerTable;


    JPanel storeNavBar;
    JPanel mainCenter;
    JButton food, houseHold, personalHygiene;

    JButton setStatus;
    private JTable foodTable, houseHoldTable, personalHygieneTable;

    JScrollPane scrollPane;
    JTable viewTable;

    JButton addStore;
    JTable storeTable;


    ImageIcon icon;
    public ArrayList<Manager> managerList;
    public ArrayList<MyStore> storeList;

    public ArrayList<Person> adminList;

    public HashMap<Product, Boolean> products;

    public HashMap<Product, Boolean> foodCategory;

    public HashMap<Product, Boolean> houseHoldCategory;
    public HashMap<Product, Boolean> personalHygieneCategory;

    DefaultTableModel model;

    public Admin_Panel() {

        model = new DefaultTableModel();

        storeList = UserWriter.LoadStoresList(storeList);


        icon = new ImageIcon("images/Company_Logo.png");
        adminFrame = new JFrame("The AI Grocery Haven-Admin Panel");
        adminFrame.setSize(800, 800);
        adminFrame.setIconImage(icon.getImage());
        adminFrame.setLocationRelativeTo(null);
        adminFrame.setLayout(new BorderLayout(0, 0));
        adminFrame.getContentPane().setBackground(Color.WHITE);
        adminFrame.setResizable(false);
        adminFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Setting necessary buttons for admin
        manageManagers = new customButton("Manager");
        manageCatalouge = new customButton("Catalogue");
        viewAccount = new customButton("Account");
        logOut = new customButton("Log out");
        managestores = new customButton("Stores");
        addStore = new customButton("ADD Store");


        manageManagers.setPreferredSize(new Dimension(150, 30));
        manageCatalouge.setPreferredSize(new Dimension(150, 30));
        managestores.setPreferredSize(new Dimension(150, 30));

        viewAccount.setPreferredSize(new Dimension(150, 30));
        logOut.setPreferredSize(new Dimension(150, 30));


        // Creating footer panel for holding buttons to manage Managers

        adminFooter = new JPanel();
        adminFooter.setBackground(Color.BLACK);
        adminFooter.setPreferredSize(new Dimension(adminFrame.getWidth(), 30));



        //creating navBar for store
        storeNavBar = new JPanel();
        storeNavBar.setBackground(Color.BLACK);
        storeNavBar.setLayout(new FlowLayout(FlowLayout.CENTER));
        storeNavBar.setPreferredSize(new Dimension(adminFrame.getWidth(), 30));


        //creating center panel for managing stores
        mainCenter = new JPanel();
        mainCenter.setLayout(new BorderLayout());
        mainCenter.setBackground(Color.WHITE);



        // Creating store Nav Bar menu for managing Stores
        food = new customButton("Food");
        houseHold = new customButton("House Holding Cleaning");
        personalHygiene = new customButton("Personal Hygiene");
        setStatus = new customButton("Set Status");


        //creating table

        maangerTable = new JTable();
        foodTable = new JTable();
        houseHoldTable = new JTable();
        personalHygieneTable = new JTable();
        viewTable = new JTable();
        storeTable = new JTable();



        adminFooter.add(setStatus);
        adminFooter.add(addStore);



        //Adding buttons to store NavBar
        storeNavBar.add(food);
        storeNavBar.add(houseHold);
        storeNavBar.add(personalHygiene);




        // Setting left panel of Frame
        leftPanel = new JPanel();
        leftPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        leftPanel.setBackground(new Color(124, 190, 213, 151));
        leftPanel.setPreferredSize(new Dimension(160, adminFrame.getHeight()));
        leftPanel.add(manageManagers);
        leftPanel.add(manageCatalouge);
        leftPanel.add(managestores);
        leftPanel.add(viewAccount);
        leftPanel.add(logOut);


        //initially setting footer panel, manager center, store Nav Bar and store Center visibility false
        adminFooter.setVisible(false);
        storeNavBar.setVisible(false);



        //Adding Action Listener to Admin panel buttons
        manageManagers.addActionListener(this);
        manageCatalouge.addActionListener(this);
        managestores.addActionListener(this);
        food.addActionListener(this);
        personalHygiene.addActionListener(this);
        houseHold.addActionListener(this);
        setStatus.addActionListener(this);
        addStore.addActionListener(this);
        viewAccount.addActionListener(this);
        logOut.addActionListener(this);


        // Adding components to Main Frame
        adminFrame.add(leftPanel, BorderLayout.WEST);
        adminFrame.setVisible(true);
    }


    public void actionPerformed(ActionEvent e) {
        adminFooter.setVisible(false);

        adminFooter.remove(addStore);
        adminFooter.remove(setStatus);


        Manage_Manager manager = new Manage_Manager();

        String[][] rows = null;



        if (e.getSource() == manageManagers) {
            mainCenter.setVisible(true);
            storeNavBar.setVisible(false);

            model.setRowCount(0);
            model.setColumnCount(0);

            if (loadManagersFromStores()) {
                rows = getManagersList();
            }



            String[] coloumns = {"ID", "Name", "Email", "Salary", "Manager At"};

            model.setColumnIdentifiers(coloumns);

            for (String[] row: rows){
                model.addRow(row);
            }


            maangerTable = new JTable(model);


            // Custom header renderer to change the color
            DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
            headerRenderer.setBackground(Color.BLUE);
            headerRenderer.setForeground(Color.WHITE);
            headerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
            maangerTable.getTableHeader().setDefaultRenderer(headerRenderer);

            scrollPane = new JScrollPane(maangerTable);
            scrollPane.setBorder(BorderFactory.createEmptyBorder()); // Remove border around scroll pane

            mainCenter.add(scrollPane);

            adminFrame.add(mainCenter, BorderLayout.CENTER);
            adminFrame.revalidate();


        }

        else if (e.getSource() == manageCatalouge) {
            mainCenter.setVisible(true);
            storeNavBar.setVisible(true);
            adminFooter.setVisible(true);
            adminFooter.add(setStatus);

            model.setRowCount(0);
            model.setColumnCount(0);


            String[] coloumn = {"Name", "Price", "Weight Units", "Quantity", "Brand", "Status"};

            rows = null;

            if (fetchingProduct()) {
                rows = getAllCatalogue();

            }

            model.setColumnIdentifiers(coloumn);

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

            scrollPane = new JScrollPane(foodTable);

            scrollPane.setBorder(BorderFactory.createEmptyBorder()); // Remove border around scroll pane



            mainCenter.add(scrollPane);



            adminFrame.add(storeNavBar, BorderLayout.NORTH);
            adminFrame.add(mainCenter, BorderLayout.CENTER);
            adminFrame.add(adminFooter, BorderLayout.SOUTH);


            adminFrame.revalidate();

        } else if (e.getSource() == food) {

            model.setRowCount(0);
            model.setColumnCount(0);

            rows = null;

            if (fetchingProduct()) {
                rows = getTwoDArrayForRequiredProduct("Food");

            }

            adminFooter.setVisible(true);
            mainCenter.setVisible(true);
            adminFooter.add(setStatus);

            String[] coloumn = {"Name", "Price", "Weight Units", "Quantity", "Brand", "Status"};

            model.setColumnIdentifiers(coloumn);

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

            scrollPane = new JScrollPane(foodTable);

            scrollPane.setBorder(BorderFactory.createEmptyBorder()); // Remove border around scroll pane



            mainCenter.add(scrollPane);

            adminFrame.add(storeNavBar, BorderLayout.NORTH);
            adminFrame.add(mainCenter, BorderLayout.CENTER);

            adminFrame.revalidate();

        } else if (e.getSource() == houseHold) {
            adminFooter.setVisible(true);
            adminFooter.add(setStatus);

            model.setRowCount(0);
            model.setColumnCount(0);

            rows = null;

            if (fetchingProduct()) {
                rows = getTwoDArrayForRequiredProduct("houseHoldCleaning");

            }


            String[] coloumn = {"Name", "Price", "Weight Units", "Quantity", "Brand", "Status"};


            model.setColumnIdentifiers(coloumn);

            for (String[] row : rows){
                model.addRow(row);
            }


            houseHoldTable = new JTable(model);


            // Custom header renderer to change the color
            DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
            headerRenderer.setBackground(Color.BLUE);
            headerRenderer.setForeground(Color.WHITE);
            headerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
            houseHoldTable.getTableHeader().setDefaultRenderer(headerRenderer);

            scrollPane = new JScrollPane(houseHoldTable);

            scrollPane.setBorder(BorderFactory.createEmptyBorder()); // Remove border around scroll pane
            mainCenter.add(scrollPane);


            mainCenter.setVisible(true);

            adminFrame.add(storeNavBar, BorderLayout.NORTH);
            adminFrame.add(mainCenter, BorderLayout.CENTER);
            adminFrame.add(adminFooter, BorderLayout.SOUTH);
            adminFrame.revalidate();

        } else if (e.getSource() == personalHygiene) {
            adminFooter.setVisible(true);
            adminFooter.add(setStatus);

            model.setRowCount(0);
            model.setColumnCount(0);

            rows = null;

            if (fetchingProduct()) {
                rows = getTwoDArrayForRequiredProduct("personalHygiene");

            }

            String[] coloumn = {"Name", "Price", "Weight Units", "Quantity", "Brand", "Status"};


            model.setColumnIdentifiers(coloumn);

            for (String[] row : rows){
                model.addRow(row);
            }



            personalHygieneTable = new JTable(model);


            // Custom header renderer to change the color
            DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
            headerRenderer.setBackground(Color.BLUE);
            headerRenderer.setForeground(Color.WHITE);
            headerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
            personalHygieneTable.getTableHeader().setDefaultRenderer(headerRenderer);


            scrollPane = new JScrollPane(personalHygieneTable);

            scrollPane.setBorder(BorderFactory.createEmptyBorder()); // Remove border around scroll pane
            mainCenter.add(scrollPane);



            mainCenter.setVisible(true);


            adminFrame.add(storeNavBar, BorderLayout.NORTH);
            adminFrame.add(mainCenter, BorderLayout.CENTER);
            adminFrame.add(adminFooter, BorderLayout.SOUTH);
            adminFrame.revalidate();

        } else if (e.getSource() == setStatus) {
            adminFooter.setVisible(true);
            adminFooter.add(setStatus);

            String brandName = JOptionPane.showInputDialog(null, "Enter brand name:");
            if (brandName != null) {
                ProductCatalogueManagement.updateStatus(brandName, "Productcatalogue");
            } else {
                JOptionPane.showMessageDialog(null, "Input field is empty");
            }


        }
        else if (e.getSource() == managestores) {
            mainCenter.setVisible(true);

            adminFooter.setVisible(true);
            adminFooter.add(addStore);

            model.setColumnCount(0);
            model.setRowCount(0);

            storeList = UserWriter.LoadStoresList(storeList);



            storeNavBar.setVisible(false);

            rows = null;
            if (fetchingStores()) {
                rows = getStoresList();
            }

            String[] coloumn = {"Location", "Manager"};

            model.setColumnIdentifiers(coloumn);
            if(rows==null){
                rows=new String[0][];
            }
            for (String[] row : rows){
                model.addRow(row);
            }

            storeTable = new JTable(model);


            // Custom header renderer to change the color
            DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
            headerRenderer.setBackground(Color.BLUE);
            headerRenderer.setForeground(Color.WHITE);
            headerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
            storeTable.getTableHeader().setDefaultRenderer(headerRenderer);

            scrollPane = new JScrollPane(storeTable);

            scrollPane.setBorder(BorderFactory.createEmptyBorder()); // Remove border around scroll pane
            mainCenter.add(scrollPane);

            adminFrame.add(mainCenter, BorderLayout.CENTER);
            adminFrame.add(adminFooter, BorderLayout.SOUTH);


            adminFrame.revalidate();



        } else if (e.getSource() == addStore) {
            adminFooter.setVisible(true);
            adminFooter.add(addStore);

            manager.addManagerFrame();

        } else if (e.getSource() == viewAccount) {
            model.setColumnCount(0);
            model.setRowCount(0);

            mainCenter.setVisible(true);


            if (fetchingAdmins()) {
                rows = getTwoDArrayForAdmin();

            }

            String[] coloumn = {"First Name", "Last Name", "Username", "Email", "Password"};


            model.setColumnIdentifiers(coloumn);

            for (String[] row : rows){
                model.addRow(row);
            }

            viewTable = new JTable(model);


            // Custom header renderer to change the color
            DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
            headerRenderer.setBackground(Color.BLUE);
            headerRenderer.setForeground(Color.WHITE);
            headerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
            viewTable.getTableHeader().setDefaultRenderer(headerRenderer);


            scrollPane = new JScrollPane(viewTable);

            mainCenter.add(scrollPane);


            adminFrame.add(mainCenter, BorderLayout.CENTER);
            adminFrame.revalidate();


        } else if (e.getSource() == logOut) {
            adminFrame.dispose();
        }

    }



    public boolean fetchingAdmins() {

        adminList = UserWriter.LoadArrayList(adminList, "admin");
        if (adminList == null) {
            return false;
        }
        return true;
    }


    public boolean fetchingProduct() {
        products = ProductCatalogueManagement.LoadDataIntoHashMap("ProductCatalogue");
        if (products == null) {
            return false;
        }
        return true;
    }

    public boolean fetchingStores() {

        if (storeList == null) {
            System.out.println("store list does not exists..Line 574");
            return false;
        }
        return true;
    }


    public boolean loadManagersFromStores() {
        managerList = new ArrayList<>();
        if (storeList != null) {
            for (MyStore store : storeList) {
                managerList.add(store.getManager());

            }
            return true;
        }
        return false;
    }


    public String[][] getManagersList() {

        int i = 0;
        String[][] result = new String[managerList.size()][];
        for (Manager m : managerList) {
            String[] str = new String[5];
            str[0] = m.getId();
            String name = m.getFirstName() + " " + m.getLastName();
            str[1] = name;
            str[2] = m.getEmail();
            str[3] = m.getSalary();
            str[4] = m.getCity();
            result[i++] = str;

        }
        return result;
    }

    public String[][] getTwoDArrayForAdmin() {

        int i = 0;
        String[][] result = new String[adminList.size()][];
        for (Person m : adminList) {
            String[] str = new String[5];
            str[0] = m.getFirstName();

            str[1] = m.getLastName();
            str[2] = m.getUsername();
            str[3] = m.getEmail();
            str[4] = m.getPassword();
            result[i++] = str;

        }
        return result;
    }

    public String[][] getTwoDArrayForRequiredProduct(String productCategory) {
        int i = 0;
        String[][] result = new String[products.size()][];
        for (Map.Entry<Product, Boolean> product : products.entrySet()) {
            if (product.getKey().getMainCategory().equals(productCategory)) {
                String[] str = new String[6];
                str[0] = product.getKey().getName();
                String price = String.valueOf(product.getKey().getPrice());
                str[1] = price;
                str[2] = product.getKey().getWeightUnits();
                String quantity = String.valueOf(product.getKey().getQuantity());
                str[3] = quantity;
                str[4] = product.getKey().getBrand();
                String stringValue = Boolean.toString(product.getKey().isStatus());
                str[5] = stringValue;

                result[i++] = str;

            }

        }
        return result;
    }


    public String[][] getAllCatalogue() {
        int i = 0;
        String[][] result = new String[products.size()][];
        for (Map.Entry<Product, Boolean> product : products.entrySet()) {

                String[] str = new String[6];
                str[0] = product.getKey().getName();
                String price = String.valueOf(product.getKey().getPrice());
                str[1] = price;
                str[2] = product.getKey().getWeightUnits();
                String quantity = String.valueOf(product.getKey().getQuantity());
                str[3] = quantity;
                str[4] = product.getKey().getBrand();
                String stringValue = Boolean.toString(product.getKey().isStatus());
                str[5] = stringValue;

                result[i++] = str;


        }
        return result;
    }






    public String[][] getStoresList() {
        String[][] ans = new String[storeList.size()][];
        int i = 0;
        for (MyStore s : storeList) {
            String[] str = new String[2];
            str[0] = s.getLocation();
            str[1] = s.getManager().getFirstName() + s.getManager().getLastName();

            ans[i++] = str;
        }
        return ans;
    }


    public static void main(String[] args) {
        Admin_Panel ad = new Admin_Panel();
//        for (MyStore s: ad.storeList){
//            System.out.println(s.getLocation());
//        }

    }


}

