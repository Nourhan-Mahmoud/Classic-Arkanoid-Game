package com.ClassicArkanoidGame;


import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;


public class MainMenu extends JFrame {
    private javax.swing.JButton jButton7;

    public MainMenu() {
        this.initComponents();
    }

    private void initComponents() {
        JPanel jPanel1 = new JPanel();
        JLabel jLabel1 = new JLabel();
        JButton jButton1 = new JButton();
        JButton jButton2 = new JButton();
        JButton jButton3 = new JButton();
        JButton jButton4 = new JButton();
        JButton jButton5 = new JButton();
        JButton jButton6 = new JButton();
        JLabel jLabel2 = new JLabel();
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jPanel1.setLayout(null);
        jLabel1.setFont(new Font("Tw Cen MT Condensed", 3, 48));
        jLabel1.setForeground(new Color(250, 0, 204));
        jLabel1.setText("   CLASSIC ARKANOID");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(10, 20, 400, 60);
        jButton1.setBackground(new Color(0, 51, 255));
        jButton1.setFont(new Font("Times New Roman", 3, 36));
        jButton1.setForeground(new Color(51, 0, 51));
        jButton1.setText("EASY");
        jButton1.addActionListener(MainMenu.this::jButton1ActionPerformed);
        jPanel1.add(jButton1);
        jButton1.setBounds(70, 80, 280, 60);
        jButton2.setBackground(new Color(0, 51, 255));
        jButton2.setFont(new Font("Times New Roman", 3, 36));
        jButton2.setForeground(new Color(51, 0, 51));
        jButton2.setText("MODERATE");
        jButton2.addActionListener(MainMenu.this::jButton2ActionPerformed);
        jPanel1.add(jButton2);
        jButton2.setBounds(70, 150, 280, 60);
        jButton3.setBackground(new Color(0, 51, 255));
        jButton3.setFont(new Font("Times New Roman", 3, 36));
        jButton3.setForeground(new Color(51, 0, 51));
        jButton3.setText("HARD");
        jButton3.addActionListener(MainMenu.this::jButton3ActionPerformed);
        jPanel1.add(jButton3);
        jButton3.setBounds(70, 220, 280, 60);
        jButton4.setBackground(new Color(0, 51, 255));
        jButton4.setFont(new Font("Times New Roman", 3, 36));
        jButton4.setForeground(new Color(51, 0, 51));
        jButton4.setText("SETTING");
        jButton4.addActionListener(MainMenu.this::jButton4ActionPerformed);
        jPanel1.add(jButton4);
        jButton4.setBounds(70, 360, 280, 60);
        jButton5.setBackground(new Color(0, 51, 255));
        jButton5.setFont(new Font("Times New Roman", 3, 36));
        jButton5.setForeground(new Color(51, 0, 51));
        jButton5.setText("EXIT");
        jButton5.addActionListener(MainMenu.this::jButton5ActionPerformed);
        jPanel1.add(jButton5);
        jButton5.setBounds(70, 430, 280, 51);
        jButton6.setBackground(new Color(0, 51, 255));
        jButton6.setFont(new Font("Times New Roman", 3, 36));
        jButton6.setForeground(new Color(51, 0, 51));
        jButton6.setText("MONSTER");
        jButton6.addActionListener(MainMenu.this::jButton6ActionPerformed);
        jPanel1.add(jButton6);
        jButton6.setBounds(70, 290, 280, 60);
        jLabel2.setIcon(new ImageIcon("C:\\Users\\User\\Desktop\\PROJECT_GAME\\src\\com\\ClassicArkanoidGame\\pinkback.jpg"));
        jPanel1.add(jLabel2);
        jLabel2.setBounds(0, 0, 420, 520);
        GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(jPanel1, GroupLayout.Alignment.TRAILING, -1, 418, 32767));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(jPanel1, GroupLayout.Alignment.TRAILING, -1, 517, 32767));
        this.pack();
    }



    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        //easy
        dispose();
        MainFrame frame=new MainFrame();
        frame.gamePlay.level1=true;
        frame.gamePlay.level2=false;
        frame.gamePlay.level3=false;
        frame.gamePlay.levelM=false;
        // TODO add your handling code here:
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        //moderate
        dispose();
        MainFrame frame=new MainFrame();
        frame.gamePlay.level1=false;
        frame.gamePlay.level2=true;
        frame.gamePlay.level3=false;
        frame.gamePlay.levelM=false;
        // TODO add your handling code here:
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        //hard
        dispose();
        MainFrame frame=new MainFrame();
        frame.gamePlay.level1=false;
        frame.gamePlay.level2=false;
        frame.gamePlay.level3=true;
        frame.gamePlay.levelM=false;
        // TODO add your handling code here:
    }

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {
       //MONSTER
        dispose();
        MainFrame frame=new MainFrame();
        frame.gamePlay.level1=false;
        frame.gamePlay.level2=false;
        frame.gamePlay.level3=false;
        frame.gamePlay.levelM=true;
        // TODO add your handling code here:
    }

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
        //setting
        dispose();
        Setting setting=new Setting();
        // TODO add your handling code here:
    }



    private void jButton5ActionPerformed(ActionEvent evt) {
        System.exit(0);
    }

}