package com.ritesh.hospital.database.ui;
import com.ritesh.hospital.database.service.LoginService;

import javax.swing.*;

public class LoginFrame extends JFrame {
    private JTextField username;
    private JPasswordField password;

    LoginService loginService = new LoginService();

    public LoginFrame() {

        setTitle("Hospital Management System");

        setSize(500,350);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(null);

        JLabel title = new JLabel("Hospital Management System");
        title.setBounds(110,20,300,30);

        JLabel userLabel = new JLabel("Username");
        userLabel.setBounds(70,90,100,25);

        username = new JTextField();
        username.setBounds(170,90,200,25);

        JLabel passLabel = new JLabel("Password");
        passLabel.setBounds(70,140,100,25);

         password = new JPasswordField();
        password.setBounds(170,140,200,25);

        JButton login = new JButton("Login");
        login.setBounds(170,200,100,35);
        login.addActionListener(e -> {

            String user = username.getText();
            String pass = new String(password.getPassword());

            if (loginService.login(user, pass)) {

                JOptionPane.showMessageDialog(this, "Login Successful");
                new DashboardFrame();
                dispose();

            } else {

                JOptionPane.showMessageDialog(this, "Invalid Username or Password");

            }

        });

        add(title);
        add(userLabel);
        add(username);
        add(passLabel);
        add(password);
        add(login);

        setVisible(true);
    }
}