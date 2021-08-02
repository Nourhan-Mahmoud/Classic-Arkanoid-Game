package com.ClassicArkanoidGame;

import javax.swing.*;

public class MainFrame extends JFrame {

    GamePlay gamePlay = new GamePlay() ;


   public MainFrame(){

       this.setBounds(10, 10, 600, 700);
       this.setTitle("Classic Arkanoid Game");
       this.setResizable(false);
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       this.add(gamePlay);  //For that i extends JPanel in GamePlay class.
       this.setVisible(true);
   }
}
