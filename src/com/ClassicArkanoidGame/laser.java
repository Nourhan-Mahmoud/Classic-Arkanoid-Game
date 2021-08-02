package com.ClassicArkanoidGame;

import java.awt.*;

public class laser {

    public int startx,starty,speed=5;

    public void setStartx(int startx) {

        this.startx = startx;
    }

    public void setStarty(int starty) {

        this.starty = starty;
    }
    public void newlaser()
    {
        setStartx(GamePlay.playerX+(GamePlay.playerWidth/2));
        setStarty(600);

    }




    public void laserspeed(Graphics2D g)
    {

        if(GamePlay.laserIntersect == false)
        {
            g.setColor(new Color(250, 0, 0));
            g.fillOval(startx,starty,10,10);

            starty =starty - speed;
        }



    }

}
