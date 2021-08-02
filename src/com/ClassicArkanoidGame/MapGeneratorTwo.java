package com.ClassicArkanoidGame;

import java.awt.*;

public class MapGeneratorTwo extends Levels{
    public int map[][];
    public static int brickWidth;
    public static int brickHeight;
    public static final int totalbricks = 94;
    private  int raw =10;
    private  int col = 13;

    public MapGeneratorTwo(){
        map = new int[raw][col];


        for (int i = 0 ; i < map.length ; i++ ){
            for (int j = 0 ; j < map[0].length ; j++){

                if(i==0 || i==9 || i==1  || i==8  )
                {
                    map[i][j]=1;
                }
                 if   (i==2 || i==7 )
                {
                    map[i][j]=2;
                }
                if ( i==3 || i==6 )
                {
                    map[i][j]=3;
                }
                 if ( i==4 || i==5 )
                {
                    map[i][j]=4;
                }
                 if ((i==1&&j==0) || (i==2&&j==0) || (i==2&&j==1)
                        || (i==3&&j==0) || (i==3&&j==1) || (i==3&&j==2)
                        ||(i==4&&j==0) || (i==4&&j==1) || (i==4&&j==2)
                        || (i==5&&j==0) || (i==5&&j==1) || (i==5&&j==2)
                        || (i==6&&j==0) || (i==6&&j==1) || (i==6&&j==2)
                        || (i==8&&j==0) || (i==7&&j==0) || (i==7&&j==1)
                        ||(i==1&&j==12) || (i==2&&j==11) || (i==2&&j==12)
                        || (i==3&&j==10) || (i==3&&j==11) || (i==3&&j==12)
                        ||(i==4&&j==10) || (i==4&&j==11) || (i==4&&j==12)
                        || (i==5&&j==10) || (i==5&&j==11) || (i==5&&j==12)
                        || (i==6&&j==10) || (i==6&&j==11) || (i==6&&j==12)
                        || (i==8&&j==12) || (i==7&&j==11) || (i==7&&j==12))
                {
                    map[i][j]=0;
                }

            }

        }




        brickWidth = 350/raw;
        brickHeight = 350/col;
    }

@Override
    public void draw(Graphics2D g){
        for (int i = 0 ; i < map.length ; i++ ) {
            for (int j = 0; j < map[0].length; j++) {
                if(map [i][j] > 0){
                    if(map[i][j] == 1) {
                        g.setColor(new Color(255, 0, 128));
                        g.fill3DRect(j * brickWidth + 80, i * brickHeight + 80, brickWidth, brickHeight, true);
                        g.setStroke(new BasicStroke(20));
                        g.setColor(new Color(180, 128, 128));
                        g.draw3DRect(j * brickWidth + 80, i * brickHeight + 80, brickWidth, brickHeight, true);
                    }
                    if(map[i][j] == 2) {
                        g.setColor(new Color(255, 0, 153));
                        g.fill3DRect(j * brickWidth + 80, i * brickHeight + 80, brickWidth, brickHeight, true);
                        g.setStroke(new BasicStroke(20));
                        g.setColor(new Color(180, 128, 128));
                        g.draw3DRect(j * brickWidth + 80, i * brickHeight + 80, brickWidth, brickHeight, true);
                    }
                    if(map[i][j] == 3) {
                        g.setColor(new Color(255, 0, 204));
                        g.fill3DRect(j * brickWidth + 80, i * brickHeight + 80, brickWidth, brickHeight, true);
                        g.setStroke(new BasicStroke(20));
                        g.setColor(new Color(180, 128, 128));
                        g.draw3DRect(j * brickWidth + 80, i * brickHeight + 80, brickWidth, brickHeight, true);
                    }
                    if(map[i][j] == 4) {
                        g.setColor(new Color(255, 69, 255));
                        g.fill3DRect(j * brickWidth + 80, i * brickHeight + 80, brickWidth, brickHeight, true);
                        g.setStroke(new BasicStroke(20));
                        g.setColor(new Color(180, 128, 128));
                        g.draw3DRect(j * brickWidth + 80, i * brickHeight + 80, brickWidth, brickHeight, true);
                    }




                }
            }
        }
    }

    public void setbrickvalue(int value,int row,int col)
    {
        map[row][col]=value;
    }
}
