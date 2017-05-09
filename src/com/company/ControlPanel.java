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

    public float getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(float currentBalance) {
        this.currentBalance = currentBalance;
    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ControlPanel frame = new ControlPanel("user", 1000);
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
    public ControlPanel(String userName, float currentBalance) {
        this.userName = userName;
        this.currentBalance = currentBalance;

        int screenPositionX = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 2 - 300;
        int screenPositionY = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 2 - 280;


        setTitle("Welcome " + userName);
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

        JLabel lblCurrentAcount = new JLabel("Current Amount: " + getCurrentBalance() + " Da");
        lblCurrentAcount.setHorizontalAlignment(SwingConstants.CENTER);
        lblCurrentAcount.setForeground(new Color(0, 204, 153));
        lblCurrentAcount.setFont(new Font("Century Gothic", Font.PLAIN, 25));
        lblCurrentAcount.setBounds(86, 146, 426, 45);
        panel.add(lblCurrentAcount);


        textField = new JTextField();
        textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
        textField.setForeground(new Color(0, 204, 153));
        textField.setBounds(156, 213, 278, 28);
        panel.add(textField);
        textField.setColumns(10);


        JLabel lblError = new JLabel("Error: ");
        lblError.setHorizontalAlignment(SwingConstants.CENTER);
        lblError.setForeground(new Color(0, 204, 153));
        lblError.setFont(new Font("Century Gothic", Font.PLAIN, 25));
        lblError.setBounds(86, 264, 426, 35);
        panel.add(lblError);

        JButton btnCashoutAmount = new JButton("Cashout Amount: " + getCurrentBalance() + " Da");
        btnCashoutAmount.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

            }
        });
        btnCashoutAmount.setForeground(Color.WHITE);
        btnCashoutAmount.setFont(new Font("Century Gothic", Font.BOLD, 16));
        btnCashoutAmount.setBackground(new Color(0, 204, 153));
        btnCashoutAmount.setBounds(209, 390, 167, 35);
        panel.add(btnCashoutAmount);

        JButton btnShowHistory = new JButton("Show history");
        btnShowHistory.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

            }
        });
        btnShowHistory.setForeground(Color.WHITE);
        btnShowHistory.setFont(new Font("Century Gothic", Font.BOLD, 16));
        btnShowHistory.setBackground(new Color(0, 204, 153));
        btnShowHistory.setBounds(209, 456, 167, 35);
        panel.add(btnShowHistory);

        JButton btnAddAmount = new JButton("Add Amount");
        btnAddAmount.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                float addedValue = Float.valueOf(textField.getText());
                setCurrentBalance(getComponentCount() + addedValue);
                textField.setText("");
                lblCurrentAcount.setText("Current Amount: " + getCurrentBalance());
            }
        });
        btnAddAmount.setBackground(new Color(0, 204, 153));
        btnAddAmount.setForeground(new Color(255, 255, 255));
        btnAddAmount.setFont(new Font("Century Gothic", Font.BOLD, 16));
        btnAddAmount.setBounds(209, 326, 167, 35);
        panel.add(btnAddAmount);
    }

}

