package GUI;

import Login_SignUp_Validation.credentialsVerification;
import Users.Customer;
import Users.Manager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Login_Screen extends JFrame implements ActionListener {
    JFrame loginFrame;
    JButton loginButton;

    JTextField usernameField;
    JPasswordField passwordField;
    boolean isAdminButtonClicked;
    boolean isManagerButtonClicked;
    private Manager manager;



    private Customer customer;




    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Login_Screen(){

    }

    public Login_Screen(boolean isAdminButtonClicked, boolean isManagerButtonClicked) {
        this.isAdminButtonClicked = isAdminButtonClicked;
        this.isManagerButtonClicked = isManagerButtonClicked;

        loginFrame = new JFrame("Login");
        loginFrame.setSize(400, 400);
        loginFrame.setLocationRelativeTo(null);
        loginFrame.getContentPane().setBackground(Color.WHITE);
        loginFrame.setLayout(null);
        loginFrame.setResizable(false);

        ImageIcon image = new ImageIcon("images/login_sign_pic.png");
        JLabel loginImage = new JLabel();
        loginImage.setIcon(image);
        loginImage.setBounds(130, 15, image.getIconWidth(), image.getIconHeight());

        JLabel username = new JLabel();
        username.setText("Username: ");
        username.setBounds(90, 140, 100, 20);
        usernameField = new JTextField();
        usernameField.setBounds(180, 140, 140, 25);
        JLabel email = new JLabel();
        email.setText("Email can be used");
        email.setBounds(180, 160, 150, 25);

        JLabel password = new JLabel();
        password.setText("Password: ");
        password.setBounds(90, 190, 100, 20);
        passwordField = new JPasswordField();
        passwordField.setBounds(180, 190, 140, 20);

        loginButton = new customButton("Log in");
        loginButton.setBounds(150, 230, 80, 20);
        loginButton.addActionListener(this);


        //adding content to Frame;
        loginFrame.add(loginImage);
        loginFrame.add(username);
        loginFrame.add(usernameField);
        loginFrame.add(email);
        loginFrame.add(password);
        loginFrame.add(passwordField);
        loginFrame.add(loginButton);
        loginFrame.setVisible(true);
    }
    public Manager getManager() {
        return manager;
    }


    public void setManager(Manager manager) {
        this.manager = manager;
    }
    public void writeManagertoFile(Manager manager){
        File f=new File("Database/"+"Current Login Manager.ser");

        try{
            ObjectOutputStream objectOutputStream=new ObjectOutputStream(new FileOutputStream(f));
            objectOutputStream.writeObject(manager);

        }
        catch(EOFException e){
            return;
        }
        catch(Exception e){
            System.out.println("Excepion in  Manager Login_Screen");
        }

    }
    public void writeCustomertoFile(Customer customer){
        File f=new File("Database/" + "Current Login Customer.ser");

        try{
            ObjectOutputStream objectOutputStream=new ObjectOutputStream(new FileOutputStream(f));
            objectOutputStream.writeObject(customer);

            objectOutputStream.flush();
            objectOutputStream.close();

        }
        catch(EOFException e){
            return;
        }
        catch(Exception e){
            System.out.println("Excepion in Customer Login_Screen");
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (isAdminButtonClicked) {

            // Admin button is clicked
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            credentialsVerification login = new credentialsVerification(username, password, "admin");
            if (login.verfiyLogin()) {
                loginFrame.dispose();
                new Admin_Panel();

            } else {
                JOptionPane.showMessageDialog(null, "Invalid username or password..", "Error as Title",
                        JOptionPane.ERROR_MESSAGE);
            }


        } else if (isManagerButtonClicked) {
            // Manager button is clicked

            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            credentialsVerification login = new credentialsVerification(username, password, "manager");
            if(login.getManager() ==null){
                JOptionPane.showMessageDialog(null, "Invalid username or password..", "Login Error",
                        JOptionPane.ERROR_MESSAGE);
            }
            else if (login.verfiyLogin()) {
                this.setManager(login.getManager());
                this.writeManagertoFile(getManager());

                loginFrame.dispose();
                new Manager_Screen();

            }

        } else {
            // Default login logic for customers
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            credentialsVerification login = new credentialsVerification(username, password, "customer");
            if (login.verfiyLogin()) {
                this.setCustomer(login.getCustomer());
                this.writeCustomertoFile(this.getCustomer());
                loginFrame.dispose();
                new Customer_Panel();

            } else {
                JOptionPane.showMessageDialog(null, "Invalid username or password..", "Error as Title",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

}