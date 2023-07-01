package GUI;

import Login_SignUp_Validation.credentialsVerification;
import Stores.MyStore;
import Users.Manager;
import Users.UserWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import ProductCatalogueManagement.*;

public class Manage_Manager extends JFrame implements ActionListener {
    JFrame managerFrame;
    JLabel IDLabel, nameLabel, emailLabel, salaryLabel, storeLocationLabel, usernameLabel, passwordLabel;
    JTextField IDTextField, nameTextField, emailTextField, salaryTextField, storeLocationTextField, usernameTextField, passwordTextField;
    JButton ADD, updateManager;
    String ID;

    public Manage_Manager() {

    }
    public Manage_Manager(String ID) {
        this.ID = ID;
    }

    public void addManagerFrame() {

        managerFrame = new JFrame("Store Creation");
        managerFrame.setSize(300, 270);
        managerFrame.setLayout(null);
        managerFrame.setLocationRelativeTo(null);
        managerFrame.getContentPane().setBackground(Color.WHITE);
        managerFrame.setResizable(false);

        IDLabel = new JLabel("ID: ");
        nameLabel = new JLabel("Name: ");
        usernameLabel = new JLabel("Username: ");
        passwordLabel = new JLabel("Password: ");

        emailLabel = new JLabel("Email: ");
        salaryLabel = new JLabel("Salary: ");
        storeLocationLabel = new JLabel("Store: ");

        IDLabel.setBounds(40, 10, 50, 20);
        nameLabel.setBounds(16, 35, 50, 20);
        usernameLabel.setBounds(10, 60, 80, 20);
        passwordLabel.setBounds(16, 85, 80, 20);
        emailLabel.setBounds(16, 110, 50, 20);

        salaryLabel.setBounds(10, 135, 55, 20);
        storeLocationLabel.setBounds(16, 160, 50, 20);

        IDTextField = new JTextField();
        nameTextField = new JTextField();
        emailTextField = new JTextField();
        salaryTextField = new JTextField();
        storeLocationTextField = new JTextField();
        usernameTextField = new JTextField();
        passwordTextField = new JTextField();


        IDTextField.setBounds(100, 10, 120, 20);
        nameTextField.setBounds(100, 35, 120, 20);
        usernameTextField.setBounds(100, 60, 120, 20);
        passwordTextField.setBounds(100, 85, 120, 20);

        emailTextField.setBounds(100, 110, 120, 20);
        salaryTextField.setBounds(100, 135, 120, 20);
        storeLocationTextField.setBounds(100, 160, 120, 20);

        JPanel ADDPanel = new JPanel();
        ADDPanel.setBackground(Color.BLACK);
        ADD = new customButton("Create");

        ADDPanel.add(ADD);
        ADDPanel.setBounds(0, 210, managerFrame.getWidth(), 30);
        ADD.addActionListener(this);

        managerFrame.add(IDLabel);
        managerFrame.add(nameLabel);
        managerFrame.add(usernameLabel);
        managerFrame.add(passwordLabel);
        managerFrame.add(emailLabel);
        managerFrame.add(salaryLabel);
        managerFrame.add(storeLocationLabel);
        managerFrame.add(IDTextField);
        managerFrame.add(nameTextField);
        managerFrame.add(usernameTextField);
        managerFrame.add(passwordTextField);
        managerFrame.add(emailTextField);
        managerFrame.add(salaryTextField);
        managerFrame.add(storeLocationTextField);
        managerFrame.add(ADDPanel);
        managerFrame.setVisible(true);

    }

    public void updateManagerFrame() {

        managerFrame = new JFrame("Update Manager");
        managerFrame.setSize(300, 270);
        managerFrame.setLayout(null);
        managerFrame.setLocationRelativeTo(null);
        managerFrame.getContentPane().setBackground(Color.WHITE);
        managerFrame.setResizable(false);

        nameLabel = new JLabel("Name: ");
        usernameLabel = new JLabel("Username: ");
        passwordLabel = new JLabel("Password: ");

        emailLabel = new JLabel("Email: ");
        salaryLabel = new JLabel("Salary: ");
        storeLocationLabel = new JLabel("Store: ");

        nameLabel.setBounds(16, 35, 50, 20);
        usernameLabel.setBounds(10, 60, 80, 20);
        passwordLabel.setBounds(16, 85, 80, 20);
        emailLabel.setBounds(16, 110, 50, 20);
        salaryLabel.setBounds(10, 135, 55, 20);
        storeLocationLabel.setBounds(16, 160, 50, 20);

        nameTextField = new JTextField();
        emailTextField = new JTextField();
        salaryTextField = new JTextField();
        storeLocationTextField = new JTextField();
        usernameTextField = new JTextField();
        passwordTextField = new JTextField();


        nameTextField.setBounds(100, 35, 120, 20);
        usernameTextField.setBounds(100, 60, 120, 20);
        passwordTextField.setBounds(100, 85, 120, 20);

        emailTextField.setBounds(100, 110, 120, 20);
        salaryTextField.setBounds(100, 135, 120, 20);
        storeLocationTextField.setBounds(100, 160, 120, 20);

        JPanel ADDPanel = new JPanel();
        ADDPanel.setBackground(Color.BLACK);
        updateManager = new customButton("Update");

        ADDPanel.add(updateManager);
        ADDPanel.setBounds(0, 230, managerFrame.getWidth(), 30);
        updateManager.addActionListener(this);

        managerFrame.add(nameLabel);
        managerFrame.add(usernameLabel);
        managerFrame.add(passwordLabel);
        managerFrame.add(emailLabel);
        managerFrame.add(salaryLabel);
        managerFrame.add(storeLocationLabel);

        managerFrame.add(nameTextField);
        managerFrame.add(usernameTextField);
        managerFrame.add(passwordTextField);
        managerFrame.add(emailTextField);
        managerFrame.add(salaryTextField);
        managerFrame.add(storeLocationTextField);
        managerFrame.add(ADDPanel);
        managerFrame.setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == ADD) {
            addingStore();
            managerFrame.dispose();
        } else if (e.getSource() == updateManager) {
            updateManager(ID);
            managerFrame.dispose();
        }
    }
    public void addingStore() {
        String ID = IDTextField.getText();
        String username = usernameTextField.getText();
        String password = passwordTextField.getText();
        String name = nameTextField.getText();
        String email = emailTextField.getText();
        String salary = salaryTextField.getText();
        String location = storeLocationTextField.getText().toLowerCase();

        Manager manager = new Manager(ID, name, username, password, email, salary, location);

        ArrayList<Manager> managerList = new ArrayList<>();
        managerList = UserWriter.LoadArrayList(managerList);

        ArrayList<MyStore> storeList = new ArrayList<>();
        storeList = UserWriter.LoadStoresList(storeList);

        if (storeList != null) {
            credentialsVerification c = new credentialsVerification();
            if (c.isUniqueManager(ID)) {
                if (c.isUniqueManager(username)) {
                    if (c.isUniqueManager(email)) {

                    } else {
                        JOptionPane.showMessageDialog(null, "Manager email already exists.");
                        return;
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Manager username already exists.");
                    return;
                }

            } else {
                JOptionPane.showMessageDialog(null, "Manager ID already exists.");
                return;
            }
        } else if (storeList == null) {
            storeList = new ArrayList<>();
        }

        MyStore newStore = new MyStore(manager,location);
        newStore.createStore();
        storeList.add(newStore);
        UserWriter.WriteToFileStores(storeList);
    }

    public void updateManager(String ID) {
        //getting data to update
        String username = usernameTextField.getText();
        String password = passwordTextField.getText();
        String name = nameTextField.getText();
        String email = emailTextField.getText();
        String salary = salaryTextField.getText();
        String location = storeLocationTextField.getText();

        //Loading already existing manager file to update required manager
        ArrayList<Manager> managersList = new ArrayList<>();
        managersList = UserWriter.LoadArrayList(managersList);

        boolean isUpdate = false;
        int i = 0;
        for (Manager m : managersList) {
            if (m.getId().equals(ID)) {
                isUpdate = true;
                m.setUsername(username);
                m.setPassword(password);
                m.setFirstName(name);
                m.setLastName("");
                m.setEmail(email);
                m.setSalary(salary);
                m.setCity(location);
                managersList.set(i, m);
                UserWriter.WriteToFile(managersList);
                JOptionPane.showMessageDialog(null, "Manager has been updated");
                break;
            }
            i++;

        }
        if (!isUpdate) {
            JOptionPane.showMessageDialog(null, "Manager has not been updated");
            return;
        }

    }

    public void deleteManager() {
        String id = JOptionPane.showInputDialog(null, "Enter Manager ID: ");
        if (id != null) {
            ArrayList<Manager> managersList = new ArrayList<>();
            managersList = UserWriter.LoadArrayList(managersList);
            if (managersList == null) {
                JOptionPane.showMessageDialog(null, "No Manager exists with this ID");
                return;
            }
            boolean found = false;
            for (Manager manager : managersList) {
                if (manager.getId().equalsIgnoreCase(id)) {
                    found = true;
                    managersList.remove(manager);
                    UserWriter.WriteToFile(managersList);
                    break;
                }
            }
            if (found == false) {
                JOptionPane.showMessageDialog(null, "No Manager exists with this ID");
                return;
            }
        } else {
            JOptionPane.showMessageDialog(null, "No ID entered");
        }

    }
}


