package com.ClassicArkanoidGame;

import java.util.Random;
import java.awt.*;

import static com.ClassicArkanoidGame.GamePlay.*;


public class PowerUps {
    public static boolean  eatbrick;
    public static boolean orange;
    public static boolean red;
    public static boolean blue;
    public static boolean green;
    public static boolean gray;
    public static int powerYdir= 2;
    public static int powerXdir= 0;
    public static int powerXpos, powerYpos;



    public static double get_randNum() {
        double min= 0.0, max = 1.0;
        Random random = new Random();
        double randomValue = (min + (max - min) * random.nextDouble());
        return randomValue;
    }

    public static int isPowerUps()
    {
        int min_ = 1 ,max_ = 5;
        int rand_ = (int)(Math.random() * (max_ - min_ + 1) + min_);
        return rand_;
    }


    public void powerUpVector(Graphics2D g) {


        if (level1 && !level2 && !level3 && !levelM) {
            g.fillOval(powerXpos,powerYpos,MapGenerator.brickWidth,MapGenerator.brickHeight);
            powerYpos= powerYpos+ powerYdir;

        }
        if (!level1 && level2 && !level3 && !levelM ) {

            g.fillOval(powerXpos,powerYpos,MapGeneratorOne.brickWidth,MapGeneratorOne.brickHeight);
            powerYpos= powerYpos+ powerYdir;

        }
        if (!level1 && !level2 && level3 && !levelM) {

            g.fillOval(powerXpos,powerYpos,MapGeneratorTwo.brickWidth,MapGeneratorTwo.brickHeight);
            powerYpos= powerYpos+ powerYdir;

        }
        if (!level1 && !level2 && !level3 && levelM) {

            g.fillOval(powerXpos,powerYpos,MapGeneratorMonster.brickWidth,MapGeneratorMonster.brickHeight);
            powerYpos= powerYpos+ powerYdir;
        }


    }



    public PowerUps()  {


        if (eatbrick) {
            switch (isPowerUps())
            {
                case 1:
                {

                    blue = true;
                    red= false;
                    green= false;
                    orange= false;
                    gray = false;

                    break;
                }
                case 2:
                {
                    blue = false;
                    red= true;
                    green= false;
                    orange= false;
                    gray = false;

                    break;
                }
                case 3:
                {
                    blue = false;
                    red= false;
                    green= true;
                    orange= false;
                    gray = false;

                    break;
                }
                case 4:
                {
                     blue = false;
                     red= false;
                    green= false;
                    orange= true;
                    gray = false;

                    break;
                }
                case 5:
                {
                    blue = false;
                    red= false;
                    green= false;
                    orange= false;
                    gray = true;

                    break;
                }

                default:
                    break;
            }
        }
    }
    public void powwer(Graphics2D g) {

        //blue
        if (blue)
        {

            if (level1 && !level2 && !level3 && !levelM) {
                g.setColor(new Color(0, 0, 250));
                g.fillOval(powerXpos,powerYpos,MapGenerator.brickWidth,MapGenerator.brickHeight);

            }
            if (!level1 && level2 && !level3 && !levelM ) {
                g.setColor(new Color(0, 0, 250));
                g.fillOval(powerXpos,powerYpos,MapGeneratorOne.brickWidth,MapGeneratorOne.brickHeight);

            }
            if (!level1 && !level2 && level3 && !levelM) {
                g.setColor(new Color(0, 0, 250));
                g.fillOval(powerXpos,powerYpos,MapGeneratorTwo.brickWidth,MapGeneratorTwo.brickHeight);

            }
            if (!level1 && !level2 && !level3 && levelM) {
                g.setColor(new Color(0, 0, 250));
                g.fillOval(powerXpos,powerYpos,MapGeneratorMonster.brickWidth,MapGeneratorMonster.brickHeight);

            }

        }
        // red
        else if (red)
        {

            if (level1 && !level2 && !level3 && !levelM) {
                g.setColor(new Color(250, 0, 0));
                g.fillOval(powerXpos,powerYpos,MapGenerator.brickWidth,MapGenerator.brickHeight);

            }
            if (!level1 && level2 && !level3 && !levelM ) {
                g.setColor(new Color(250, 0, 0));
                g.fillOval(powerXpos,powerYpos,MapGeneratorOne.brickWidth,MapGeneratorOne.brickHeight);

            }
            if (!level1 && !level2 && level3 && !levelM) {
                g.setColor(new Color(250, 0, 0));
                g.fillOval(powerXpos,powerYpos,MapGeneratorTwo.brickWidth,MapGeneratorTwo.brickHeight);

            }
            if (!level1 && !level2 && !level3 && levelM) {
                g.setColor(new Color(250, 0, 0));
                g.fillOval(powerXpos,powerYpos,MapGeneratorMonster.brickWidth,MapGeneratorMonster.brickHeight);

            }
        }
        // green
        else if (green)
        {

            if (level1 && !level2 && !level3 && !levelM) {
                g.setColor(new Color(0, 167, 0));
                g.fillOval(powerXpos,powerYpos,MapGenerator.brickWidth,MapGenerator.brickHeight);

            }
            if (!level1 && level2 && !level3 && !levelM ) {
                g.setColor(new Color(0, 167, 0));
                g.fillOval(powerXpos,powerYpos,MapGeneratorOne.brickWidth,MapGeneratorOne.brickHeight);

            }
            if (!level1 && !level2 && level3 && !levelM) {
                g.setColor(new Color(0, 167, 0));
                g.fillOval(powerXpos,powerYpos,MapGeneratorTwo.brickWidth,MapGeneratorTwo.brickHeight);

            }
            if (!level1 && !level2 && !level3 && levelM) {
                g.setColor(new Color(0, 167, 0));
                g.fillOval(powerXpos,powerYpos,MapGeneratorMonster.brickWidth,MapGeneratorMonster.brickHeight);

            }

        }

        // orange
        else if (orange)
        {

            if (!level1 && level2 && !level3 && !levelM ) {
                g.setColor(new Color(250, 100, 0));
                g.fillOval(powerXpos,powerYpos,MapGeneratorOne.brickWidth,MapGeneratorOne.brickHeight);

            }
            if (!level1 && !level2 && level3 && !levelM) {
                g.setColor(new Color(250, 100, 0));
                g.fillOval(powerXpos,powerYpos,MapGeneratorTwo.brickWidth,MapGeneratorTwo.brickHeight);

            }
            if (!level1 && !level2 && !level3 && levelM) {
                g.setColor(new Color(250, 100, 0));
                g.fillOval(powerXpos,powerYpos,MapGeneratorMonster.brickWidth,MapGeneratorMonster.brickHeight);

            }

        }
        // gray
        else if (gray)
        {

            if (level1 && !level2 && !level3 && !levelM) {
                g.setColor(new Color(159, 159, 160, 255));
                g.fillOval(powerXpos,powerYpos,MapGenerator.brickWidth,MapGenerator.brickHeight);

            }
            if (!level1 && level2 && !level3 && !levelM ) {
                g.setColor(new Color(159, 159, 160, 255));
                g.fillOval(powerXpos,powerYpos,MapGeneratorOne.brickWidth,MapGeneratorOne.brickHeight);

            }
            if (!level1 && !level2 && level3 && !levelM) {
                g.setColor(new Color(159, 159, 160, 255));
                g.fillOval(powerXpos,powerYpos,MapGeneratorTwo.brickWidth,MapGeneratorTwo.brickHeight);

            }
            if (!level1 && !level2 && !level3 && levelM) {
                g.setColor(new Color(159, 159, 160, 255));
                g.fillOval(powerXpos,powerYpos,MapGeneratorMonster.brickWidth,MapGeneratorMonster.brickHeight);

            }

        }

        powerUpVector((Graphics2D) g);
    }




}
