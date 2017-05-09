package com.company;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ControlPanel extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    private String userName;
    private float currentBalance;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ControlPanel frame = new ControlPanel("");
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
    public ControlPanel(String userName) {
        this.userName = userName;


        int screenPositionX = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 2 - 300;
        int screenPositionY = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 2 - 280;


        setTitle("Welcome "+userName);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(screenPositionX, screenPositionY, 599, 565);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 255, 255));
        contentPane.add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        JLabel lblBankSimulator = new JLabel("Bank Simulator");
        lblBankSimulator.setHorizontalAlignment(SwingConstants.CENTER);
        lblBankSimulator.setFont(new Font("Century Gothic", Font.BOLD, 36));
        lblBankSimulator.setForeground(new Color(0, 204, 153));
        lblBankSimulator.setBounds(156, 57, 278, 51);
        panel.add(lblBankSimulator);

        JLabel lblPasswordJavaday = new JLabel("Current Account: ");
        lblPasswordJavaday.setHorizontalAlignment(SwingConstants.CENTER);
        lblPasswordJavaday.setForeground(new Color(0, 204, 153));
        lblPasswordJavaday.setFont(new Font("Century Gothic", Font.PLAIN, 25));
        lblPasswordJavaday.setBounds(86, 146, 426, 45);
        panel.add(lblPasswordJavaday);

        JButton btnForgtoPassword = new JButton("Add Amount");
        btnForgtoPassword.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        btnForgtoPassword.setBackground(new Color(0, 204, 153));
        btnForgtoPassword.setForeground(new Color(255, 255, 255));
        btnForgtoPassword.setFont(new Font("Century Gothic", Font.BOLD, 16));
        btnForgtoPassword.setBounds(209, 301, 167, 35);
        panel.add(btnForgtoPassword);

        textField = new JTextField();
        textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
        textField.setForeground(new Color(0, 204, 153));
        textField.setBounds(156, 213, 278, 28);
        panel.add(textField);
        textField.setColumns(10);

        JButton btnCashoutAmount = new JButton("Cashout Amount");
        btnCashoutAmount.setForeground(Color.WHITE);
        btnCashoutAmount.setFont(new Font("Century Gothic", Font.BOLD, 16));
        btnCashoutAmount.setBackground(new Color(0, 204, 153));
        btnCashoutAmount.setBounds(209, 363, 167, 35);
        panel.add(btnCashoutAmount);

        JButton btnShowHistory = new JButton("Show history");
        btnShowHistory.setForeground(Color.WHITE);
        btnShowHistory.setFont(new Font("Century Gothic", Font.BOLD, 16));
        btnShowHistory.setBackground(new Color(0, 204, 153));
        btnShowHistory.setBounds(209, 429, 167, 35);
        panel.add(btnShowHistory);

    }

}

