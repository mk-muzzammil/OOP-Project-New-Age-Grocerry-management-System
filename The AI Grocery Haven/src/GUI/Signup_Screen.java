package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.regex.Pattern;

import Login_SignUp_Validation.credentialsVerification;
import Stores.MyStore;
import Users.Customer;
import Users.DateOfBirth;
import Users.Person;
import Users.UserWriter;


public class Signup_Screen implements ActionListener {
    JFrame signupFrame;
    JLabel signUpImage, firstName, lastName, username, userEmail, mobileNo, CNIC, location, password, retypePassword;
    JTextField forEmail, forUsername, forFirstName, forLastName, forMobileNo, forCNIC;
    JComboBox<String> locationComboBox;
    JPasswordField forPassword, forRetypePassword;

    ArrayList<MyStore> storesList = new ArrayList<>();
    JCheckBox acceptTerms;
    JButton register;
    String[] forLocation;


    public Signup_Screen() {
        this.storesList = UserWriter.LoadStoresList(storesList);

        this.forLocation = getLocationsList();

        signupFrame = new JFrame("Sign up");
        signupFrame.setSize(600, 600);
        signupFrame.setLayout(null);
        signupFrame.setLocationRelativeTo(null);
        signupFrame.getContentPane().setBackground(Color.WHITE);
        signupFrame.setLayout(null);
        signupFrame.setResizable(false);

        ImageIcon image = new ImageIcon("images/login_sign_pic.png");
        signUpImage = new JLabel();
        signUpImage.setIcon(image);
        signUpImage.setBounds(215, 10, image.getIconWidth(), image.getIconHeight());

        firstName = new JLabel();
        firstName.setText("First Name:");
        firstName.setBounds(20, 140, 100, 20);


        forFirstName = new JTextField();
        forFirstName.setBounds(110, 140, 140, 20);


        lastName = new JLabel();
        lastName.setText("Last Name:");
        lastName.setBounds(300, 140, 100, 20);

        forLastName = new JTextField();
        forLastName.setBounds(390, 140, 140, 20);

        username = new JLabel();
        username.setText("Username: ");
        username.setBounds(20, 180, 100, 20);
        forUsername = new JTextField();
        forUsername.setBounds(110, 180, 140, 20);

        userEmail = new JLabel();
        userEmail.setText("Email: ");
        userEmail.setBounds(340, 180, 80, 20);

        forEmail = new JTextField();
        forEmail.setBounds(390, 180, 140, 20);

        mobileNo = new JLabel();
        mobileNo.setText("Cell Number:");
        mobileNo.setBounds(20, 220, 100, 20);

        forMobileNo = new JTextField();
        forMobileNo.setBounds(110, 220, 140, 20);

        CNIC = new JLabel();
        CNIC.setText("CNIC: ");
        CNIC.setBounds(347, 220, 100, 20);

        forCNIC = new JTextField();
        forCNIC.setBounds(390, 220, 140, 20);

        location = new JLabel();
        location.setText("Location: ");
        location.setBounds(20, 260, 100, 20);


        locationComboBox = new JComboBox<>(forLocation);
        locationComboBox.setSelectedItem(forLocation[0]);
        locationComboBox.setBounds(110, 260, 140, 20);


        password = new JLabel();
        password.setText("Password: ");
        password.setBounds(308, 260, 100, 20);
        forPassword = new JPasswordField();
        forPassword.setBounds(390, 260, 140, 20);

        retypePassword = new JLabel();
        retypePassword.setText("Confirm Pass:");
        retypePassword.setBounds(10, 300, 100, 20);
        forRetypePassword = new JPasswordField();
        forRetypePassword.setBounds(110, 300, 140, 20);






        acceptTerms = new JCheckBox("By clicking on Register, you agree to our Terms & Conditions");
        acceptTerms.setFont(new Font("Arial", Font.BOLD, 12));
        acceptTerms.setForeground(Color.BLACK);
        acceptTerms.setBackground(Color.WHITE);

        acceptTerms.setBounds(20, 370, 500, 20);


        register = new JButton();
        register.setText("REGISTER");
        register.setBackground(new Color(38, 250, 52));
        register.setBounds(200, 430, 200, 50);
        register.setBorder(BorderFactory.createLineBorder(Color.lightGray, 1, true));
        register.setFont(new Font("Arial", Font.BOLD, 14));
        register.setFocusable(false);
        register.addActionListener(this);


        // Add more components as needed
        signupFrame.add(signUpImage);
        signupFrame.add(firstName);
        signupFrame.add(forFirstName);
        signupFrame.add(lastName);
        signupFrame.add(forLastName);
        signupFrame.add(forUsername);
        signupFrame.add(username);
        signupFrame.add(userEmail);
        signupFrame.add(forEmail);
        signupFrame.add(mobileNo);
        signupFrame.add(forMobileNo);
        signupFrame.add(CNIC);
        signupFrame.add(forCNIC);
        signupFrame.add(location);
        signupFrame.add(locationComboBox);

        signupFrame.add(password);
        signupFrame.add(forPassword);
        signupFrame.add(retypePassword);
        signupFrame.add(forRetypePassword);
        signupFrame.add(acceptTerms);
        signupFrame.add(register);

        signupFrame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        //Fetching text from Text Fields
        String getFirstName = forFirstName.getText();
        String getLastName = forLastName.getText();
        String getUsername = forUsername.getText();
        String getPassword = new String(forPassword.getPassword());
        String getRetypePassword = new String(forRetypePassword.getPassword());
        String getEmail = forEmail.getText();
        String getCNIC = forCNIC.getText();
        String getMobileNumber = forMobileNo.getText();
        String getLocation = forLocation[0];
        if (e.getSource() == register) {
            // Get the selected item from the JComboBox as a string
            getLocation = (String) locationComboBox.getSelectedItem();
        }


        //first check if any of the field is empty or not
        if (!getFirstName.isEmpty() && !getLastName.isEmpty() && !getUsername.isEmpty() && !getPassword.isEmpty() && !getRetypePassword.isEmpty() && !getEmail.isEmpty() && !getCNIC.isEmpty() && !getMobileNumber.isEmpty()) {
//
            if (checkUsername(getUsername)) {
//                //Now check if username already exists, then throw error, otherwise proceed further
//
//
                if (getPassword.equals(getRetypePassword)) {

                    if (isValidPassword(getPassword)) {

                        if (validateEmail(getEmail)) {
//                            //Now check if email already exists, then throw error, otherwise proceed further

                            if (validateCNIC(getCNIC)) {
//                                //Now check if CNIC already exists, then throw error, otherwise proceed further
//
                                if (isValidMobileNumber(getMobileNumber)) {

                                    //After validating all above constraints, then check if Terms & conditions is accepted by executing below code
                                    if (acceptTerms.isSelected()) {
                                        Customer customer = new Customer(getFirstName, getLastName, getUsername, getEmail, getPassword, getLocation, new DateOfBirth("", "", ""), getCNIC);
//                                      UserWriter userWriter = new UserWriter(customer);
//
                                        ArrayList<Person> customerList = new ArrayList<>();
                                        customerList = UserWriter.LoadArrayList(customerList, "customer");
//
                                        if (customerList != null) {

                                            credentialsVerification c = new credentialsVerification("customer");
                                            if (c.isUnique(getUsername)) {
                                                if (c.isUnique(getEmail)) {
                                                    if (c.isUnique(getCNIC)) {

                                                    } else {
                                                        JOptionPane.showMessageDialog(null, "CNIC already exists.");
                                                        return;
                                                    }

                                                } else {
                                                    JOptionPane.showMessageDialog(null, "Email already exists.");
                                                    return;

                                                }
                                            } else {
                                                JOptionPane.showMessageDialog(null, "Username already exists.");
                                                return;

                                            }

                                        }
                                        if (customerList == null) {
                                            customerList = new ArrayList<>();
                                        }
                                        customerList.add(customer);
//
                                        UserWriter.WriteToFile(customerList, "customer");
                                        JOptionPane.showMessageDialog(null, "Registered SuccessFully");

                                        signupFrame.dispose();
                                        //procedd to Customer panel


                                    } else {
                                        JOptionPane.showMessageDialog(null, "Please accept Terms & Conditions");
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(null, getMobileNumber + " is an invalid Mobile number.");
                                }


                            } else {
                                JOptionPane.showMessageDialog(null, getCNIC + " is an invalid CNIC.");

                            }

                        } else {
                            JOptionPane.showMessageDialog(null, getEmail + " is an invalid email address.\nOnly Gmail,Hotmail and Yahoo mail are supported");

                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "Password does not meet requirements");

                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Password mismatch");


                }

            } else {
                JOptionPane.showMessageDialog(null, getUsername + " is an invalid username.");

            }

        } else {
            JOptionPane.showMessageDialog(null, "Some of the fields are empty");

        }

    }



    public static boolean checkUsername(String username) {
        // Define the regular expression pattern for valid usernames
        String pattern = "^[a-zA-Z0-9_]+$";

        // Create a Pattern object from the pattern string
        Pattern usernamePattern = Pattern.compile(pattern);

        // Check if the username matches the pattern
        return usernamePattern.matcher(username).matches();
    }

    private static boolean isValidPassword(String password) {
        // Define the password criteria or rules for validation
        int minLength = 8;  // Minimum password length
        int minUpperCase = 1;  // Minimum uppercase letters required
        int minLowerCase = 1;  // Minimum lowercase letters required
        int minDigits = 1;  // Minimum digits required
        int minSpecialChars = 1;  // Minimum special characters required

        // Perform the password validation
        if (password.length() < minLength) {
            return false;
        }

        int upperCaseCount = 0;
        int lowerCaseCount = 0;
        int digitCount = 0;
        int specialCharCount = 0;

        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                upperCaseCount++;
            } else if (Character.isLowerCase(ch)) {
                lowerCaseCount++;
            } else if (Character.isDigit(ch)) {
                digitCount++;
            } else {
                specialCharCount++;
            }
        }

        return upperCaseCount >= minUpperCase &&
                lowerCaseCount >= minLowerCase &&
                digitCount >= minDigits &&
                specialCharCount >= minSpecialChars;
    }

    public static boolean validateEmail(String email) {
        // Define the regular expression pattern for valid email addresses
        String pattern = "^[a-zA-Z0-9_.+-]+@(gmail|hotmail|yahoo)\\.com$";

        // Create a Pattern object from the pattern string
        Pattern emailPattern = Pattern.compile(pattern);

        // Check if the email matches the pattern
        return emailPattern.matcher(email).matches();
    }

    public static boolean validateCNIC(String cnic) {
        // Remove any spaces or hyphens from the CNIC string
        cnic = cnic.replaceAll("[\\s-]", "");

        // Check if the CNIC consists of 13 digits
        if (cnic.length() != 13 || !cnic.matches("\\d+")) {
            return false;
        }

        return true;
    }

    public static boolean isValidMobileNumber(String mobileNumber) {
        if (mobileNumber.startsWith("03")) {
            // Mobile number starts with 03, should have 11 digits
            return mobileNumber.length() == 11 && mobileNumber.matches("\\d+");
        } else if (mobileNumber.startsWith("92")) {
            // Mobile number starts with 92, should have 10 digits
            return mobileNumber.length() == 12 && mobileNumber.matches("\\d+");
        }

        return false;
    }

    public String[] getLocationsList() {
        String[] str = new String[storesList.size()];
        int i = 0;
        for (MyStore store : storesList) {
            str[i++] = store.getLocation();
        }
        return str;
    }

    public static void main(String[] args) {
        new Signup_Screen();
    }
}
