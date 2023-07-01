package GUI;
import ProductCataloague.Product;
import ProductCatalogueManagement.ProductCatalogueManagement;
import Stores.MyStore;
import Users.Manager;
import Users.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import Login_SignUp_Validation.credentialsVerification;


public class Manager_Screen extends JFrame implements ActionListener {
    JFrame frame;
    JPanel leftpanel;
    JPanel footerPanel,mainCenterPanel, storeCenterPanel;
    JButton managerStoreButton,viewManagerButton,viewCustomerButton,logOutButton;
    JButton setQuantityButton,setPriceButton,removeCustomer,removeProduct,seachCustomer;
    Manager manager;

    private ArrayList<Person>  customerList;
    private ArrayList<MyStore>  stores;
    private HashMap<Product,Boolean> storeInventory;
    MyStore store;

    DefaultTableModel model;


    public Manager_Screen(){
        this.loadLoginManager();
        stores = new ArrayList<MyStore>();

        stores=UserWriter.LoadStoresList(stores);




        //matching store Location with Manager Location
        for (MyStore st: stores){

            if (st.getLocation().equals(getManager().getCity())){
                store=st;
                break;
            }

        }
        //===================================Loading Data From files ===========================================
        this.customerList=UserWriter.LoadArrayList(customerList,"customer");


        //==================================================Rest of the Code ============================
        frame=new JFrame();
        frame.setLayout(new BorderLayout(0,0));
        frame.setSize(700,700);
        frame.setLocationRelativeTo(null);
        frame.setTitle("The AI Grocery Haven-Manager Panel");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        leftpanel=new JPanel();
        leftpanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        leftpanel.setPreferredSize(new Dimension(130,frame.getHeight()));

        leftpanel.setBackground(Color.LIGHT_GRAY);

        managerStoreButton=new customButton("Store");
        viewManagerButton=new customButton("Account");
        viewCustomerButton=new customButton("Customers");
        logOutButton=new customButton("Log Out");
        seachCustomer=new customButton("Seacrch");

        managerStoreButton.setPreferredSize(new Dimension(120,40));
        viewManagerButton.setPreferredSize(new Dimension(120,40));
        viewCustomerButton.setPreferredSize(new Dimension(120,40));
        logOutButton.setPreferredSize(new Dimension(120,40));
        seachCustomer.setPreferredSize(new Dimension(120,40));


        managerStoreButton.addActionListener(this);
        viewManagerButton.addActionListener(this);
        viewCustomerButton.addActionListener(this);
        logOutButton.addActionListener(this);
        seachCustomer.addActionListener(this);

        leftpanel.add(managerStoreButton);
        leftpanel.add(viewManagerButton);
        leftpanel.add(viewCustomerButton);
        leftpanel.add(logOutButton);


        footerPanel=new JPanel();
        footerPanel.setPreferredSize(new Dimension(frame.getWidth(),50));
        footerPanel.setBackground(Color.LIGHT_GRAY);

        setQuantityButton=new customButton("Set Quantity");
        setPriceButton=new customButton("Set Price");
        removeProduct=new customButton("Remove Product");
        removeCustomer=new customButton("Remove Customer");
        setQuantityButton.setPreferredSize(new Dimension(120,40));
        setPriceButton.setPreferredSize(new Dimension(120,40));
        removeCustomer.setPreferredSize(new Dimension(150,40));
        removeProduct.setPreferredSize(new Dimension(120,40));

        setQuantityButton.addActionListener(this);
        setPriceButton.addActionListener(this);
        removeProduct.addActionListener(this);
        removeCustomer.addActionListener(this);


        mainCenterPanel=new JPanel();
        mainCenterPanel.setBackground(Color.WHITE);
        mainCenterPanel.setLayout(new BorderLayout());




        model = new DefaultTableModel();

        mainCenterPanel.setVisible(false);
//        storeCenterPanel.setVisible(false);
        footerPanel.setVisible(false);

        frame.add(leftpanel,BorderLayout.WEST);
        frame.add(footerPanel,BorderLayout.SOUTH);
        frame.setVisible(true);


    }
    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        String brandName;

        footerPanel.setVisible(false);

        footerPanel.remove(setPriceButton);
        footerPanel.remove(setQuantityButton);
        footerPanel.remove(removeCustomer);
        footerPanel.remove(removeProduct);

        if(e.getSource() == managerStoreButton){

            model.setColumnCount(0);
            model.setRowCount(0);

            footerPanel.add(setQuantityButton);
            footerPanel.add(setPriceButton);
            footerPanel.add(removeProduct);

            mainCenterPanel.setVisible(true);
            footerPanel.setVisible(true);

            fetchingStoreAccToLocation();
            String[] coloumns = {"Name", "Price", "Weight Units", "Quantity", "Brand"};
            String[][] rows = getStoreInventory();

            model.setColumnIdentifiers(coloumns);

            for (String[] row : rows) {
                model.addRow(row);
            }


            JTable store = new JTable(model);

            JScrollPane customerScrollPane = new JScrollPane(store);

            mainCenterPanel.add(customerScrollPane);

            frame.add(mainCenterPanel,BorderLayout.CENTER);
            frame.revalidate();

        }
        else if(e.getSource() == setQuantityButton ){
            footerPanel.add(setQuantityButton);
            footerPanel.add(setPriceButton);
            footerPanel.add(removeProduct);

            mainCenterPanel.setVisible(true);
//            storeCenterPanel.setVisible(true);
            footerPanel.setVisible(true);

            brandName =  JOptionPane.showInputDialog(null,"Enter brand name: ");
            if (brandName!=null){
                ProductCatalogueManagement.updateItemFromFile(brandName,getManager().getCity(),1);
            }
            else{
                JOptionPane.showMessageDialog(null,"You did not enter anything");
            }

        }
        else if(e.getSource() == setPriceButton){
            footerPanel.add(setQuantityButton);
            footerPanel.add(setPriceButton);
            footerPanel.add(removeProduct);

            mainCenterPanel.setVisible(true);
//            storeCenterPanel.setVisible(true);
            footerPanel.setVisible(true);

            brandName =  JOptionPane.showInputDialog(null,"Enter brand name: ");
            if (brandName!=null){
                ProductCatalogueManagement.updateItemFromFile(brandName,getManager().getCity(),2);

            }
            else{
                JOptionPane.showMessageDialog(null,"You did not enter anything");
            }

        }
        else if(e.getSource() == removeProduct){
            footerPanel.add(setQuantityButton);
            footerPanel.add(setPriceButton);
            footerPanel.add(removeProduct);

            mainCenterPanel.setVisible(true);
//            storeCenterPanel.setVisible(true);
            footerPanel.setVisible(true);


            brandName =  JOptionPane.showInputDialog(null,"Enter brand name: ");
            if (brandName!=null){
                ProductCatalogueManagement.removeProductFromStoreFile(brandName,getManager().getCity());

            }
            else{
                JOptionPane.showMessageDialog(null,"You did not enter anything");
            }
        }
        else if (e.getSource() == viewManagerButton) {

            mainCenterPanel.setVisible(false);
//            storeCenterPanel.setVisible(false);

            JOptionPane.showMessageDialog(null,"Full Name : "+manager.getFirstName()+" "+manager.getLastName()+"\nUsername :"+manager.getUsername()+"\nEmail        : "+manager.getEmail()+"\nPassword  :"+manager.getPassword() +"\nSalary      : "+manager.getSalary()+ "\nLocation  : "+manager.getCity());


        }
        else if (e.getSource() == viewCustomerButton)
        {
            model.setRowCount(0);
            model.setColumnCount(0);

            footerPanel.add(seachCustomer);


            mainCenterPanel.setVisible(true);
//            storeCenterPanel.setVisible(false);
            footerPanel.setVisible(true);

            footerPanel.add(removeCustomer);
            frame.revalidate();


            this.customerList=UserWriter.LoadArrayList(customerList,"customer");

            for (Person c: customerList){
                System.out.println(c.getFirstName());
            }

            String[][] rows=getCustomers();
            String[] columns={"First Name ","Last Name ","Email","Location","CNIC"};


            model.setColumnIdentifiers(columns);

            for (String[] row : rows) {
                model.addRow(row);
            }

            JTable table=new JTable(model);

            DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
            headerRenderer.setBackground(Color.GREEN);
            headerRenderer.setForeground(Color.WHITE);
            headerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
            table.getTableHeader().setDefaultRenderer(headerRenderer);

            JScrollPane customerScrollPane = new JScrollPane(table);
            customerScrollPane.setBorder(BorderFactory.createEmptyBorder());

            mainCenterPanel.add(customerScrollPane);
            frame.add(mainCenterPanel);
            frame.revalidate();

        } else if (e.getSource()==seachCustomer) {
                String name=JOptionPane.showInputDialog(null,"Enter First name");

                for (Person c: customerList){
                    if (name.equals(c.getFirstName())){
                        JOptionPane.showMessageDialog(null,name);
                        return;
                    }
                }
            JOptionPane.showMessageDialog(null,"Not found");


        } else if(e.getSource() == removeCustomer){
            mainCenterPanel.setVisible(true);
//            storeCenterPanel.setVisible(false);
            footerPanel.setVisible(true);


            footerPanel.add(removeCustomer);
            removeCustomerAccount();
            frame.revalidate();
        }
        else if(e.getSource() == logOutButton){
            File file=new File("managerLoginned.ser");
            System.out.println(file.delete());
            frame.dispose();

        }
    }


    public void loadLoginManager(){
        File file=new File("Database/" + "Current Login Manager.ser");
        if(!file.exists()){
            return;

        }
        else{
            try{
                ObjectInputStream objectInputStream=new ObjectInputStream(new FileInputStream(file));
                setManager((Manager)objectInputStream.readObject());

                System.out.println("Manager is setted ");
                objectInputStream.close();


            }
            catch(Exception e){
                System.out.println("Manager Loginned Reading problem ");

            }
        }

    }
    public void fetchingStoreAccToLocation(){
        storeInventory = ProductCatalogueManagement.LoadDataIntoHashMap(getManager().getCity());

    }

    public String[][] getStoreInventory() {

        int i = 0;
        String[][] result = new String[storeInventory.size()][];
        for (Map.Entry<Product, Boolean> product : storeInventory.entrySet()){
            if (product.getKey().isStatus()) {
                String[] str = new String[5] ;

                str[0] = product.getKey().getName();
                str[1] = Integer.toString(product.getKey().getPrice());
                str[2] =  product.getKey().getWeightUnits();
                str[3] =  Integer.toString(product.getKey().getQuantity());
                str[4] =  product.getKey().getBrand();

                result[i++] = str;
            }
        }
        return result;

    }

    public String[][] getCustomers() {

        int i = 0;
        String[][] result = new String[customerList.size()][];
        for (Person person : customerList) {
            if(person.getCity().equalsIgnoreCase(getManager().getCity())){
                String[] str = new String[5];
                str[0] = person.getFirstName();
                str[1] = person.getLastName();
                str[2] = person.getEmail();
                str[3] = person.getCity();
                str[4] = person.getCNIC();
                result[i++] = str;
            }

        }
        return result;

    }
    public void removeCustomerAccount() {
        String cnic = JOptionPane.showInputDialog(null, "Enter Customer CNIC: ");
        if (cnic != null) {
            ArrayList<Person> customerList = new ArrayList<>();
            customerList = UserWriter.LoadArrayList(customerList,"customer");
            if (customerList == null) {
                JOptionPane.showMessageDialog(null, "No Customer exists with this CNIC");
                return;
            }
            boolean found = false;
            for (Person customer : customerList) {
                if (customer.getCNIC().equalsIgnoreCase(cnic)) {
                    found = true;
                    customerList.remove(customer);
                    UserWriter.WriteToFile(customerList,"customer");
                    break;
                }
            }
            if (found == false) {
                JOptionPane.showMessageDialog(null, "No Customer exists with this CNIC");
                return;
            }
        } else {
            JOptionPane.showMessageDialog(null, "No ID entered");
        }

    }





    public static void main(String[] args) {

        Manager_Screen manager_screen = new Manager_Screen();

    }


}
