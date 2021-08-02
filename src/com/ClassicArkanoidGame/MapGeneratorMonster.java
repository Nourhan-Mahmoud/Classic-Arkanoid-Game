package com.ClassicArkanoidGame;

import java.awt.*;

public class MapGeneratorMonster extends Levels {

    public int map[][];
    public static int brickWidth;
    public static int brickHeight;
    public static final int totalbricks = 25;
    private final int raw = 21;
    private final int col = 42;
    private int cont = 0;

    public MapGeneratorMonster() {
        map = new int[raw][col];


        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (i == 0 && (j == 18 || j == 23)) {
                    map[i][j] = 1;
                }
                if (i == 1 && (j == 18 || j == 23)) {
                    map[i][j] = 1;
                }
                if (i == 2 && (j == 18 || j == 23)) {
                    map[i][j] = 1;
                }
                if (i == 3 && (j == 19 || j == 22)) {
                    map[i][j] = 1;
                }
                if (i == 4 && j >= 19 && j <= 22) {
                    map[i][j] = 1;
                }
                if (i == 5 && j >= 17 && j <= 24) {
                    map[i][j] = 1;
                }
                if (i == 6 && j >= 15 && j <= 26) {
                    map[i][j] = 1;
                }
                if (i == 7 && j >= 13 && j <= 28) {
                    map[i][j] = 1;
                }
                if (i == 8 && j >= 11 && j <= 30 && j != 19 && j != 22 && j != 18 && j != 23 && j != 17 && j != 24) {
                    map[i][j] = 1;
                }
                if (i == 9 && j >= 11 && j <= 30 && j != 19 && j != 22 && j != 17 && j != 24) {
                    map[i][j] = 1;
                }
                if (i == 10 && j >= 11 && j <= 30 && j != 19 && j != 22 && j != 17 && j != 24) {
                    map[i][j] = 1;
                }
                if (i == 11 && j >= 11 && j <= 30 && j != 19 && j != 22 && j != 18 && j != 23 && j != 17 && j != 24) {
                    map[i][j] = 1;
                }
                if (i == 12 && j >= 11 && j <= 30) {
                    map[i][j] = 1;
                }
                if (i == 13 && j >= 11 && j <= 30) {
                    map[i][j] = 1;
                }
                if (i == 14 && j >= 11 && j <= 30 && j != 19 && j != 22 && j != 18 && j != 23 && j != 17 && j != 24 && j != 20 && j != 21 && j != 16 && j != 25) {
                    map[i][j] = 1;
                }
                if (i == 15 && j >= 11 && j <= 30 && j != 19 && j != 22 && j != 18 && j != 23 && j != 17 && j != 24 && j != 20 && j != 21 && j != 16 && j != 25) {
                    map[i][j] = 1;
                }
                if (i == 16 && j >= 11 && j <= 30) {
                    map[i][j] = 1;
                }
                if (i == 17 && j >= 13 && j <= 28) {
                    map[i][j] = 1;
                }
                if (i == 18 && j >= 15 && j <= 26) {
                    map[i][j] = 1;
                }
                if (i == 19 && j >= 17 && j <= 24) {
                    map[i][j] = 1;
                }
                if (i == 20 && j >= 19 && j <= 22) {
                    map[i][j] = 1;
                }

            }

        }


        brickWidth = 300 / raw;
        brickHeight = 550 / col;
    }
@Override
    public void draw(Graphics2D g) {

                for (int i = 0; i < map.length; i++) {
                    for (int j = 0; j < map[0].length; j++) {
                        if (map[i][j] > 0) {

                            g.setColor(new Color(2, 93, 248));
                            g.fillRect(j * brickWidth, i * brickHeight + 90, brickWidth, brickHeight);

                        }
                    }
                }



    }

    public void setbrickvalue(int value,int row,int col)
    {
        map[row][col]=value;
    }
}
