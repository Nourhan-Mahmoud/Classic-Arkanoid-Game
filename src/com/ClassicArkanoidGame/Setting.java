package com.ClassicArkanoidGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Setting extends JFrame {

    public Setting(){

        this.setBounds(10, 10, 400, 450);
        this.setTitle("Setting");
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLayout(null);
        JLabel label=new JLabel("Setting");
        label.setFont(new Font("serif", 7, 70));
        label.setBounds(100,10,200,100);
        this.add(label);
        Button button1 = new Button("Mute Sound");
        button1.setBackground(new Color(162, 229, 246));
        button1.addActionListener(this::button1ActionPerformed);
        button1.setBounds(70, 180, 250, 50);
        button1.setFont(new Font("serif", 5, 36));
        this.add(button1);
        Button button2 = new Button("Play Sound");
        button2.setBackground(new Color(162, 229, 246));
        button2.addActionListener(this::button2ActionPerformed);
        button2.setBounds(70, 250, 250, 50);
        button2.setFont(new Font("serif", 5, 36));
        this.add(button2);
        Button button4 = new Button("Back");
        button4.setBackground(new Color(162, 229, 246));
        button4.addActionListener(this::button4ActionPerformed);
        button4.setBounds(70, 315, 250, 50);
        button4.setFont(new Font("serif", 5, 36));
        this.add(button4);

    }


    GamePlay gamePlay = new GamePlay();


    private void button1ActionPerformed(ActionEvent actionEvent) {
        gamePlay.playSound = false;
    }

    private void button2ActionPerformed(ActionEvent actionEvent) {
        gamePlay.playSound = true;
    }


    private void button4ActionPerformed(ActionEvent actionEvent) {
        MainMenu menu = new MainMenu();
        menu.setVisible(true);
        dispose();
    }
}
