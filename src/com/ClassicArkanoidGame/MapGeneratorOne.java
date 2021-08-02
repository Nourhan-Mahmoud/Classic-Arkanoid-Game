package com.ClassicArkanoidGame;

import java.awt.*;

public class MapGeneratorOne extends Levels{
    public int map[][];
    public static int brickWidth;
    public static  int brickHeight;
    public static final int totalbricks = 60;
    private  int raw =7;
    private  int col = 10;

    public MapGeneratorOne(){
        map = new int[raw][col];

        for (int i = 0 ; i < map.length ; i++ ){
            for (int j = 0 ; j < map[0].length ; j++){
                if(i% 2 ==0 || j%3 ==0) {
                    map[i][j]=1;
                }else{
                    map[i][j]=2;
                }
                if(i==3) {
                    map[i][j]=0;
                }

            }

        }




        brickWidth = 300/raw;
        brickHeight = 300/col;
    }

    @Override
    public void draw(Graphics2D g){
        for (int i = 0 ; i < map.length ; i++ ) {
            for (int j = 0; j < map[0].length; j++) {
                if(map [i][j] > 0){
                    if(map[i][j] == 1) {
                        g.setColor(new Color(100,50,60));
                        g.fill3DRect(j * brickWidth + 80, i * brickHeight + 80, brickWidth, brickHeight, true);
                        g.setStroke(new BasicStroke(20));
                        g.setColor(new Color(180, 128, 128));
                        g.draw3DRect(j * brickWidth + 80, i * brickHeight + 80, brickWidth, brickHeight, true);
                    }
                    if(map[i][j] == 2) {
                        g.setColor(new Color(205,92,92));
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
