package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Welcome_Screen extends JFrame implements ActionListener {
    JFrame frame;
    JPanel navBar;
    ImageIcon icon;
    JLabel logo;
    JButton login, signUp, admin, manager;

    public Welcome_Screen() {




        icon = new ImageIcon("images/Company_Logo.png");

        frame = new JFrame("The AI Grocery Haven");
        frame.setSize(1000, 800);
        frame.setIconImage(icon.getImage());
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout(0, 0));
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        icon = new ImageIcon("images/Company_Logo.png");

        logo = new JLabel(icon);
        logo.setText("The AI Grocery Haven");
        logo.setForeground(Color.yellow);
        logo.setVerticalAlignment(JLabel.CENTER);
        logo.setHorizontalAlignment(JLabel.CENTER);
        logo.setIconTextGap(20);

        //creating login and signUp buttons
        login = new customButton("Login");
        signUp = new customButton("Sign Up");
        admin = new customButton("Admin");
        manager = new customButton("Manager");

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.GRAY);
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 30)); // Align buttons to the right with gaps
        buttonPanel.add(admin);
        buttonPanel.add(manager);
        buttonPanel.add(login);
        buttonPanel.add(signUp);

        // Create the navigation bar panel
        JPanel navBar = new JPanel();
        navBar.setBackground(Color.gray);
        navBar.setPreferredSize(new Dimension(frame.getWidth(), 65));
        navBar.setLayout(new BorderLayout());

        navBar.add(logo, BorderLayout.WEST);
        navBar.add(buttonPanel, BorderLayout.EAST); // Add buttonPanel to the right side of navBar


        // Create a container panel for the center panels
        JPanel centerContainer = new JPanel();
        centerContainer.setBackground(Color.WHITE);
        ImageIcon icon = new ImageIcon("images/Welcome_Screen.png");
        JLabel image = new JLabel(icon);
        image.setSize(centerContainer.getWidth(),centerContainer.getHeight());

        centerContainer.add(image);



        //Adding Copy Rights Label at South Region
        int copyrightSymbolCodePoint = 169;
        String s = Character.toString(copyrightSymbolCodePoint);
        JLabel rightsLabel = new JLabel("Copyright " + s + " 2023,The AI Grocery Haven, All rights reserved.");
        rightsLabel.setFont(new Font("Arial", Font.BOLD, 12));
        rightsLabel.setHorizontalAlignment(SwingConstants.CENTER);
        rightsLabel.setBackground(Color.WHITE);

        JLabel contributionLabel = new JLabel("Developed by SP22-BCS-076| SP22-BCS-058| SP22-BCS-095");
        contributionLabel.setFont(new Font("Arial", Font.BOLD, 12));
        contributionLabel.setHorizontalAlignment(SwingConstants.CENTER);
        contributionLabel.setBackground(Color.WHITE);


        //Creating panel for south region
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BorderLayout());
        bottomPanel.setBackground(new Color(235, 181, 87));
        bottomPanel.add(rightsLabel,BorderLayout.NORTH);
        bottomPanel.add(contributionLabel,BorderLayout.CENTER);


        login.addActionListener(this);
        signUp.addActionListener(this);
        admin.addActionListener(this);
        manager.addActionListener(this);
        frame.add(navBar, BorderLayout.NORTH);
        frame.add(bottomPanel, BorderLayout.SOUTH);
      //  frame.add(leftPanel, BorderLayout.WEST);
      //  frame.add(rightPanel, BorderLayout.EAST);
        frame.add(centerContainer,BorderLayout.CENTER);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == signUp) {
            new Signup_Screen();
        } else if (e.getSource() == login) {

            new Login_Screen(false, false);

        } else if (e.getSource() == admin) {

            new Login_Screen(true, false);
        } else if (e.getSource() == manager) {

            new Login_Screen(false, true);
        }

    }
}
