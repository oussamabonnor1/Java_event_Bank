package com.company;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.border.MatteBorder;

public class HistoryViewer extends JFrame {

    private JPanel contentPane;
    String[] transactions;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    String[] holder = {"What you did reacently:"};
                    HistoryViewer frame = new HistoryViewer(holder);
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
    public HistoryViewer(String[] transactions) {
        this.transactions = transactions;

        int screenPositionX = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 2 - 210;
        int screenPositionY = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 2 - 290;
        setTitle("Bank Simulator");
        setResizable(false);
        setSize(419, 584);
        setLocation(screenPositionX, screenPositionY);
        setDefaultCloseOperation(HIDE_ON_CLOSE);

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

        JLabel lblUsername = new JLabel("Reacent Transactions");
        lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
        lblUsername.setForeground(new Color(0, 204, 153));
        lblUsername.setFont(new Font("Century Gothic", Font.BOLD, 21));
        lblUsername.setBounds(79, 133, 265, 45);
        panel.add(lblUsername);

        JList list = new JList();
        list.setFont(new Font("Tahoma", Font.BOLD, 13));
        list.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 204, 102)));
        list.setModel(new AbstractListModel() {

            public int getSize() {
                return transactions.length;
            }

            public Object getElementAt(int index) {
                return transactions[index];
            }
        });
        list.setForeground(new Color(0, 204, 102));
        list.setBounds(79, 214, 265, 279);
        panel.add(list);


    }
}

