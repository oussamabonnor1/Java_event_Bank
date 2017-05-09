package com.company;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.JPasswordField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginPanel extends JFrame {
    private JTextField textField;
    private JPasswordField passwordField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    LoginPanel frame = new LoginPanel();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public LoginPanel() {
        int screenPositionX = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 2 - 210;
        int screenPositionY = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 2 - 290;
        setTitle("Bank Simulator");
        setResizable(false);
        setSize(419, 584);
        setLocation(screenPositionX, screenPositionY);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 255, 255));
        getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        JLabel lblBankSimulator = new JLabel("Bank Simulator");
        lblBankSimulator.setHorizontalAlignment(SwingConstants.CENTER);
        lblBankSimulator.setFont(new Font("Century Gothic", Font.BOLD, 36));
        lblBankSimulator.setForeground(new Color(0, 204, 153));
        lblBankSimulator.setBounds(79, 56, 265, 51);
        panel.add(lblBankSimulator);

        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
        lblUsername.setForeground(new Color(0, 204, 153));
        lblUsername.setFont(new Font("Century Gothic", Font.BOLD, 20));
        lblUsername.setBounds(38, 172, 110, 45);
        panel.add(lblUsername);

        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
        lblPassword.setForeground(new Color(0, 204, 153));
        lblPassword.setFont(new Font("Century Gothic", Font.BOLD, 20));
        lblPassword.setBounds(38, 242, 110, 45);
        panel.add(lblPassword);

        JLabel lblPasswordJavaday = new JLabel("Password: JavaDay");
        lblPasswordJavaday.setHorizontalAlignment(SwingConstants.CENTER);
        lblPasswordJavaday.setForeground(new Color(0, 204, 153));
        lblPasswordJavaday.setFont(new Font("Century Gothic", Font.BOLD, 20));
        lblPasswordJavaday.setBounds(50, 467, 306, 69);
        panel.add(lblPasswordJavaday);
        lblPasswordJavaday.setVisible(false);

        textField = new JTextField();
        textField.setForeground(new Color(0, 204, 153));
        textField.setBounds(199, 186, 145, 22);
        panel.add(textField);
        textField.setColumns(10);

        passwordField = new JPasswordField();
        passwordField.setForeground(new Color(0, 204, 153));
        passwordField.setBounds(199, 256, 145, 22);
        panel.add(passwordField);

        JButton btnLogin = new JButton("Login");
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(textField.getText().isEmpty()){

                    lblPasswordJavaday.setVisible(true);
                    lblPasswordJavaday.setText("Please enter a Username");
                    return;
                }
                if(passwordField.getText().isEmpty()){
                    lblPasswordJavaday.setVisible(true);
                    lblPasswordJavaday.setText("Please enter a Password");
                    return;
                }

                if(textField.getText().length() < 3){
                    lblPasswordJavaday.setVisible(true);
                    lblPasswordJavaday.setText("Username needs +2 letters");
                    return;
                }

                if(passwordField.getPassword().length < 8){
                    lblPasswordJavaday.setVisible(true);
                    lblPasswordJavaday.setText("Password needs +7 letters");
                    return;
                }

                char[] input = passwordField.getPassword();

                if(!String.valueOf(input).equals("JavaDay")){
                    lblPasswordJavaday.setVisible(true);
                    lblPasswordJavaday.setText("Wrong Password");
                    return;
                }else{
                    setVisible(false);
                    ControlPanel controlPanel = new ControlPanel(textField.getText());
                    controlPanel.setVisible(true);
                }
            }
        });
        btnLogin.setBackground(new Color(0, 204, 153));
        btnLogin.setForeground(new Color(255, 255, 255));
        btnLogin.setFont(new Font("Century Gothic", Font.BOLD, 14));
        btnLogin.setBounds(120, 380, 167, 25);
        panel.add(btnLogin);

        JButton btnForgtoPassword = new JButton("Forgt password ? ");
        btnForgtoPassword.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lblPasswordJavaday.setVisible(true);
                lblPasswordJavaday.setText("Password: JavaDay");
                return;
            }
        });
        btnForgtoPassword.setBackground(new Color(0, 204, 153));
        btnForgtoPassword.setForeground(new Color(255, 255, 255));
        btnForgtoPassword.setFont(new Font("Century Gothic", Font.BOLD, 14));
        btnForgtoPassword.setBounds(120, 429, 167, 25);
        panel.add(btnForgtoPassword);



    }
}

