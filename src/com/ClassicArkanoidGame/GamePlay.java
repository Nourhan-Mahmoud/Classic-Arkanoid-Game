package com.ClassicArkanoidGame;

import classicarkanoiadgame.NewJFrame;
import sound.Sound;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class GamePlay extends JPanel implements KeyListener , ActionListener {

    PowerUps powerUp;
    private boolean isDrawPower=false;

    static public boolean isgreen = false;
    static public boolean isOrange = false;
    static public boolean isred = false;
    static public boolean islaser = false;
    static public boolean laserIntersect = false;
    static public boolean finsh_power = true;

    laser lasers[] = new laser[1000];
    public static int countlaser=0;

    public static boolean level1 = false;
    public static boolean level2 = false;
    public static boolean level3 = false;
    public static boolean levelM = false;
    private MapGenerator map;
    private MapGeneratorOne map1;
    private MapGeneratorTwo map2;
    private MapGeneratorMonster mapM;

    public static boolean forGameover = false;
    public static boolean forBackToMenu = false;

    //For Sound
    public static boolean playSound = true;

    public static boolean play = false;

    private int score = 0;
    private int lives=3;

    private static int totalbricks = MapGenerator.totalbricks;
    private static int totalbricks1 = MapGeneratorOne.totalbricks;
    private static int totalbricks2 = MapGeneratorTwo.totalbricks;
    private static int totalbricksM = MapGeneratorMonster.totalbricks;

    private final Timer timer ;

    public static int playerX = 250; //the position of the stick (_____) it moves in X only ")
    public static int playerWidth = 100;

    public static int ballPosX = 120; //the position of the ball in X-axis.
    public static int ballPosY = 450; //the position of the ball in Y-axis.
    public static int ballXdir = 1;
    public static int ballYdir = 2;
    public static int ballXdirOne = 2;
    public static int ballYdirOne = 4;
    public static int ballXdirTwo = 3;
    public static int ballYdirTwo = 6;
    public static int ballXdirM = 3;
    public static int ballYdirM = 6;

    private int timeseconds = 0;
    private int timeminutes = 0;
    private int timecounter = 0;

    private boolean congrats = true;

    public Sound sound =new Sound();


    public GamePlay(){

        map=new MapGenerator();
        map1=new MapGeneratorOne();
        map2=new MapGeneratorTwo();
        mapM=new MapGeneratorMonster();

        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);

        //For the speed.
        int delay = 8;
        timer = new Timer(delay, this);
        timer.start();

    }

    public void paint (Graphics g){

        //background
        g.setColor(new Color(1, 7, 38));
        g.fillRect(1,1,692,700);

        //drawing maps
        if(level1 && !level2 && !level3 && !levelM){
            map.draw((Graphics2D) g);
        }
        if(!level1 && level2 && !level3 && !levelM){
            map1.draw((Graphics2D) g);
        }
        if(!level1 && !level2 && level3 && !levelM){
            map2.draw((Graphics2D) g);
        }
        if(!level1 && !level2 && !level3 && levelM){
            mapM.draw((Graphics2D) g);
        }


        //borders
        g.setColor(new Color(227, 218, 218, 237));
        g.fillRect(0,0,3,700);
        g.fillRect(0,0,692,3);
        g.fillRect(0,50,692,3);
        g.fillRect(592,0,3,700);

        //draw the score
        g.setColor(new Color(176,224,230));
        g.setFont(new Font("serif",Font.ITALIC,30));
        g.drawString(" Score : "+score,20,35);

        //the paddel
        g.setColor(Color.CYAN);
        g.fill3DRect(playerX,600,playerWidth,10,true);

        //the ball
        g.setColor(new Color(255,250,205));
        g.fillOval(ballPosX,ballPosY,20,20);

        //For PowerUp.
        if (isDrawPower) {
            powerUp.powwer((Graphics2D) g);
        }
        if (islaser ) {

            lasers[countlaser].laserspeed((Graphics2D) g);
            if (lasers[countlaser].starty <= 0 || laserIntersect == true) {
                if (laserIntersect == true) {
                    laserIntersect = false;
                }
                countlaser++;
                lasers[countlaser] = new laser();
                lasers[countlaser].newlaser();


            }
        }

        //show time
        g.setColor(new Color(176,224,230));
        g.setFont(new Font("serif",Font.BOLD,30));
        g.drawString(""+timeminutes+":"+""+timeseconds,280,35);



        if(totalbricks == 0 ||totalbricks1 ==0 || totalbricks2 ==0 || totalbricksM ==0){
            play = false;
            if(congrats) {
                g.setColor(new Color(96, 232, 250));
                g.setFont(new Font("serif", Font.BOLD, 75));
                g.drawString("Congratulations!", 30, 350);
                g.setColor(new Color(89, 226, 120));
                g.setFont(new Font("serif", Font.BOLD, 30));
                g.drawString("Press ENTER to NEW GAME", 110, 400);
                lives=3;
                ballYdir = 0;
                ballXdir = 0;
                ballYdirOne = 0;
                ballXdirOne = 0;
                ballYdirTwo = 0;
                ballXdirTwo = 0;
                ballYdirM = 0;
                ballXdirM = 0;
            }

        }

        if(ballPosY > 610  && play){

            play = false;
            ballYdir = 0;
            ballXdir = 0;
            ballYdirOne = 0;
            ballXdirOne = 0;
            ballYdirTwo = 0;
            ballXdirTwo = 0;
            ballYdirM = 0;
            ballXdirM = 0;

            if(playSound) {
                sound.fail();
            }

            //change the color of the ball when player lose
            g.setColor(new Color(255,69,0));
            g.fillOval(ballPosX,ballPosY,20,20);

            islaser = false;
            isgreen =false;
            isred = false;
            isOrange = false;
            playerWidth=100;


            if(level1 && !level2 && !level3 && !levelM){
                ballXdir = 1;
                ballYdir = 2;
            }
            else if(!level1 && level2 && !level3 && !levelM){
                ballXdirOne = 2;
                ballYdirOne = 4;
            }
            else if(!level1 && !level2 && level3 && !levelM){
                ballXdirTwo = 3;
                ballYdirTwo = 6;
            }
            else if(!level1 && !level2 && !level3 && levelM){
                ballXdirM = 3;
                ballYdirM = 6;
            }

        }

        //draw three lives
        g.setColor(new Color(176,224,230));
        g.setFont(new Font("serif",Font.ITALIC,30));
        g.drawString(" Lives : "+lives,400,35);

        if(ballPosY > 610&&lives>=0 ){
            live(g);

        }



        g.dispose();

    }



    @Override
    public void actionPerformed(ActionEvent e) {
        timer.start();

        if (play) {
            if (new Rectangle(ballPosX, ballPosY, 20, 20).intersects(new Rectangle(playerX, 600, playerWidth-2, 8))) {

                if (level1 && !level2 && !level3 && !levelM) {
                    ballYdir = -ballYdir;
                }
                if (!level1 && level2 && !level3 && !levelM) {
                    ballYdirOne = -ballYdirOne;
                }
                if (!level1 && !level2 && level3 && !levelM) {
                    ballYdirTwo = -ballYdirTwo;
                }
                if (!level1 && !level2 && !level3 && levelM) {
                    ballYdirM = -ballYdirM;
                }
                if(playSound) {
                    sound.badle();
                }
            }

            if (level1 && !level2 && !level3 && !levelM) {

                A:
                for (int i = 0; i < map.map.length; i++) {
                    for (int j = 0; j < map.map[0].length; j++) {
                        if (map.map[i][j] > 0) {
                            int brickX = j * map.brickWidth + 80;
                            int brickY = i * map.brickHeight + 80;
                            int brickWidth = map.brickWidth;
                            int brickHeight = map.brickHeight;
                            Rectangle rec = new Rectangle(brickX, brickY, brickWidth, brickHeight);
                            Rectangle ballrec = new Rectangle(ballPosX, ballPosY, 20, 20);
                            Rectangle brickrect=rec;
                            if (ballrec.intersects(rec)) {
                                if (playSound) {
                                    sound.blocks();
                                }
                                setBrickValue(0, i, j);
                                totalbricks--;
                                score += 5;
                                if (finsh_power == true) {
                                    if (PowerUps.get_randNum() < 0.2 && finsh_power == true) {

                                        PowerUps.powerXpos = brickX;
                                        PowerUps.powerYpos = brickY;
                                        PowerUps.eatbrick = true;
                                        isDrawPower = true;
                                        powerUp = new PowerUps();
                                        finsh_power = false;

                                    } else {
                                        PowerUps.eatbrick = false;
                                        finsh_power = true;

                                    }
                                }
                                if (isgreen != true) {

                                    if (ballPosX + 19 <= rec.x || ballPosX + 1 >= rec.x + ballrec.width) {
                                        ballXdir = -ballXdir;
                                    } else {
                                        ballYdir = -ballYdir;
                                    }
                                }
                                break A; //for breaking the out for loop;
                            }
                            if (islaser)
                            {
                                Rectangle laserrect=new Rectangle(lasers[countlaser].startx,lasers[countlaser].starty,10,10);
                                Rectangle rect_=new Rectangle(brickX,brickY,map.brickWidth,map.brickHeight);
                                if(laserrect.intersects(rect_) )
                                {
                                    if(playSound) {
                                        sound.laser();
                                    }
                                    laserIntersect = true;
                                    map.setbrickvalue(0,i,j);
                                    totalbricks--;
                                    score+=5;
                                    if (finsh_power == true)
                                    {
                                        if (PowerUps.get_randNum() < 0.2 && finsh_power==true)
                                        {

                                            PowerUps.powerXpos = brickX;
                                            PowerUps.powerYpos = brickY;
                                            PowerUps.eatbrick= true;
                                            isDrawPower= true;
                                            powerUp = new PowerUps();
                                            finsh_power = false;


                                        } else
                                        {
                                            PowerUps.eatbrick= false;
                                            finsh_power = true;

                                        }
                                    }
                                    if (isgreen!=true)
                                    {
                                        if(ballPosX+19<=brickrect.x||ballPosY+1>=brickrect.x+ brickrect.width)
                                        {
                                            ballXdir=-ballXdir;
                                        }
                                        else
                                        {
                                            ballYdir=-ballYdir;
                                        }
                                    }
                                    break A;
                                }

                            }

                            Rectangle powerRect=new Rectangle(PowerUps.powerXpos,PowerUps.powerYpos,map.brickWidth,map.brickHeight);
                            Rectangle playerRect=new Rectangle(playerX,600,playerWidth,10);

                            if (powerRect.intersects(playerRect))
                            {
                                finsh_power = true;
                                PowerUps.powerXpos = 640;

                                if (PowerUps.blue)
                                {
                                    playerWidth =130;
                                    isgreen= false;
                                    isred = false;
                                    islaser = false;
                                    ballXdir =1;
                                    ballYdir =2;
                                    isOrange = false;
                                }

                                else if (PowerUps.red)
                                {
                                    playerWidth =100;
                                    isgreen= false;
                                    isOrange = false;
                                    ballXdir =1;
                                    ballYdir =2;
                                    isred = true;

                                    if (isred)
                                    {
                                        lasers[countlaser] = new laser();
                                        lasers[countlaser].setStartx((GamePlay.playerX)+(GamePlay.playerWidth/2));
                                        lasers[countlaser].setStarty(600);
                                        islaser= true;
                                    }


                                }

                                else if (PowerUps.gray)
                                {
                                    isgreen= false;
                                    isOrange = false;
                                    isred = false;
                                    playerWidth =100;
                                    ballXdir =1;
                                    ballYdir =2;
                                    if (lives != 3 && lives !=0)
                                        lives++;


                                }
                                else if (PowerUps.green)
                                {
                                    isgreen= true;
                                    isOrange = false;
                                    isred = false;
                                    islaser = false;
                                    ballXdir =1;
                                    ballYdir =2;
                                    playerWidth =100;

                                }


                            }
                        }

                    }
                }

            }
            if (!level1 && level2 && !level3 && !levelM ) {


                A:
                for (int i = 0; i < map1.map.length; i++) {
                    for (int j = 0; j < map1.map[0].length; j++) {
                        if (map1.map[i][j] > 0) {
                            int brickX = j * map1.brickWidth + 80;
                            int brickY = i * map1.brickHeight + 80;
                            int brickWidth = map1.brickWidth;
                            int brickHeight = map1.brickHeight;
                            Rectangle rec = new Rectangle(brickX, brickY, brickWidth, brickHeight);
                            Rectangle ballrec = new Rectangle(ballPosX, ballPosY, 20, 20);
                            Rectangle brickrect=rec;
                            if (ballrec.intersects(rec)) {
                                if (playSound) {
                                    sound.blocks();
                                }
                                setBrickValue(0, i, j);
                                totalbricks1--;
                                score += 5;

                                if (finsh_power == true) {
                                    if (PowerUps.get_randNum() < 0.2 && finsh_power == true) {

                                        PowerUps.powerXpos = brickX;
                                        PowerUps.powerYpos = brickY;
                                        PowerUps.eatbrick = true;
                                        isDrawPower = true;
                                        powerUp = new PowerUps();
                                        finsh_power = false;

                                    } else {
                                        PowerUps.eatbrick = false;
                                        finsh_power = true;

                                    }
                                }
                                if (isgreen != true) {

                                    if (ballPosX + 19 <= rec.x || ballPosX + 1 >= rec.x + ballrec.width) {
                                        ballXdirOne = -ballXdirOne;
                                    } else {
                                        ballYdirOne = -ballYdirOne;
                                    }
                                }

                                break A; //for breaking the out for loop;
                            }
                            if (islaser) {
                                Rectangle laserrect = new Rectangle(lasers[countlaser].startx, lasers[countlaser].starty, 10, 10);
                                Rectangle rect_ = new Rectangle(brickX, brickY, map1.brickWidth, map1.brickHeight);
                                if (laserrect.intersects(rect_)) {
                                    if(playSound) {
                                        sound.laser();
                                    }
                                    laserIntersect = true;
                                    map1.setbrickvalue(0, i, j);
                                    totalbricks1--;
                                    score += 5;
                                    if (finsh_power == true) {
                                        if (PowerUps.get_randNum() < 0.2 && finsh_power == true) {

                                            PowerUps.powerXpos = brickX;
                                            PowerUps.powerYpos = brickY;
                                            PowerUps.eatbrick = true;
                                            isDrawPower = true;
                                            powerUp = new PowerUps();
                                            finsh_power = false;


                                        } else {
                                            PowerUps.eatbrick = false;
                                            finsh_power = true;

                                        }
                                    }
                                    if (isgreen != true) {
                                        if (ballPosX + 19 <= brickrect.x || ballPosY + 1 >= brickrect.x + brickrect.width) {
                                            ballXdirOne = -ballXdirOne;
                                        } else {
                                            ballYdirOne = -ballYdirOne;
                                        }
                                    }
                                    break A;
                                }
                            }

                            Rectangle powerRect=new Rectangle(PowerUps.powerXpos,PowerUps.powerYpos,map1.brickWidth,map.brickHeight);
                            Rectangle playerRect=new Rectangle(playerX,600,playerWidth,10);

                            if (powerRect.intersects(playerRect))
                            {
                                finsh_power = true;
                                PowerUps.powerXpos = 640;
                                if (PowerUps.blue)
                                {
                                    playerWidth =130;
                                    isgreen= false;
                                    isred = false;
                                    islaser = false;
                                    ballXdirOne =2;
                                    ballYdirOne =4;
                                    isOrange = false;
                                }

                                else if (PowerUps.red)
                                {
                                    playerWidth =100;
                                    isgreen= false;
                                    isOrange = false;
                                    ballXdirOne =2;
                                    ballYdirOne =4;
                                    isred = true;

                                    if (isred)
                                    {
                                        lasers[countlaser] = new laser();
                                        lasers[countlaser].setStartx((GamePlay.playerX)+(GamePlay.playerWidth/2));
                                        lasers[countlaser].setStarty(600);
                                        islaser= true;
                                    }

                                }

                                else if (PowerUps.orange)
                                {
                                    isgreen= false;
                                    isOrange = true;
                                    isred = false;
                                    islaser = false;
                                    playerWidth =100;

                                    if (isOrange)
                                    {
                                        ballXdirOne =1;
                                        ballYdirOne =2;
                                    }
                                }

                                else if (PowerUps.gray)
                                {
                                    isgreen= false;
                                    isOrange = false;
                                    isred = false;
                                    playerWidth =100;
                                    ballXdirOne =2;
                                    ballYdirOne=4;
                                    if (lives != 3 && lives !=0)
                                        lives++;


                                }
                                else if (PowerUps.green)
                                {
                                    isgreen= true;
                                    isOrange = false;
                                    isred = false;
                                    islaser = false;
                                    ballXdirOne =2;
                                    ballYdirOne =4;
                                    playerWidth =100;

                                }


                            }
                        }
                    }

                }
            }


        }
        if (!level1 && !level2 && level3 && !levelM) {

            A:
            for (int i = 0; i < map2.map.length; i++) {
                for (int j = 0; j < map2.map[0].length; j++) {
                    if (map2.map[i][j] > 0) {
                        int brickX = j * map2.brickWidth + 80;
                        int brickY = i * map2.brickHeight + 80;
                        int brickWidth = map2.brickWidth;
                        int brickHeight = map2.brickHeight;
                        Rectangle rec = new Rectangle(brickX, brickY, brickWidth, brickHeight);
                        Rectangle ballrec = new Rectangle(ballPosX, ballPosY, 20, 20);
                        Rectangle brickrect=rec;
                        if (ballrec.intersects(rec)) {
                            if (playSound) {
                                sound.blocks();
                            }
                            setBrickValue(0, i, j);
                            totalbricks2--;
                            score += 5;
                            if (finsh_power == true) {
                                if (PowerUps.get_randNum() < 0.2 && finsh_power == true) {

                                    PowerUps.powerXpos = brickX;
                                    PowerUps.powerYpos = brickY;
                                    PowerUps.eatbrick = true;
                                    isDrawPower = true;
                                    powerUp = new PowerUps();
                                    finsh_power = false;

                                } else {
                                    PowerUps.eatbrick = false;
                                    finsh_power = true;

                                }
                            }
                            if (isgreen != true) {

                                if (ballPosX + 19 <= rec.x || ballPosX + 1 >= rec.x + ballrec.width) {
                                    ballXdirTwo = -ballXdirTwo;
                                } else {
                                    ballYdirTwo = -ballYdirTwo;
                                }
                            }
                            break A; //for breaking the out for loop;

                        }
                        if (islaser) {
                            Rectangle laserrect = new Rectangle(lasers[countlaser].startx, lasers[countlaser].starty, 10, 10);
                            Rectangle rect_ = new Rectangle(brickX, brickY, map2.brickWidth, map2.brickHeight);
                            if (laserrect.intersects(rect_)) {
                                if(playSound) {
                                    sound.laser();
                                }
                                laserIntersect = true;
                                map2.setbrickvalue(0, i, j);
                                totalbricks2--;
                                score += 5;
                                if (finsh_power == true) {
                                    if (PowerUps.get_randNum() < 0.2 && finsh_power == true) {

                                        PowerUps.powerXpos = brickX;
                                        PowerUps.powerYpos = brickY;
                                        PowerUps.eatbrick = true;
                                        isDrawPower = true;
                                        powerUp = new PowerUps();
                                        finsh_power = false;


                                    } else {
                                        PowerUps.eatbrick = false;
                                        finsh_power = true;

                                    }
                                }
                                if (isgreen != true) {
                                    if (ballPosX + 19 <= brickrect.x || ballPosY + 1 >= brickrect.x + brickrect.width) {
                                        ballXdirTwo= -ballXdirTwo;
                                    } else {
                                        ballYdirTwo = -ballYdirTwo;
                                    }
                                }
                                break A;
                            }
                        }

                        Rectangle powerRect=new Rectangle(PowerUps.powerXpos,PowerUps.powerYpos,map2.brickWidth,map.brickHeight);
                        Rectangle playerRect=new Rectangle(playerX,600,playerWidth,10);

                        if (powerRect.intersects(playerRect))
                        {
                            finsh_power = true;
                            PowerUps.powerXpos = 640;
                            if (PowerUps.blue)
                            {
                                playerWidth =130;
                                isgreen= false;
                                isred = false;
                                islaser = false;
                                ballXdirTwo =3;
                                ballYdirTwo =6;
                                isOrange = false;
                            }

                            else if (PowerUps.red)
                            {
                                playerWidth =100;
                                isgreen= false;
                                isOrange = false;
                                ballXdirTwo =3;
                                ballYdirTwo =6;
                                isred = true;

                                if (isred)
                                {
                                    lasers[countlaser] = new laser();
                                    lasers[countlaser].setStartx((GamePlay.playerX)+(GamePlay.playerWidth/2));
                                    lasers[countlaser].setStarty(600);
                                    islaser= true;
                                }


                            }

                            else if (PowerUps.orange)
                            {
                                isgreen= false;
                                isOrange = true;
                                isred = false;
                                islaser = false;
                                playerWidth =100;

                                if (isOrange)
                                {
                                    ballXdirTwo =2;
                                    ballYdirTwo=4;
                                }
                            }

                            else if (PowerUps.gray)
                            {
                                isgreen= false;
                                isOrange = false;
                                isred = false;
                                playerWidth =100;
                                ballXdirTwo =3;
                                ballYdirTwo=6;
                                if (lives != 3 && lives !=0)
                                    lives++;


                            }
                            else if (PowerUps.green)
                            {
                                isgreen= true;
                                isOrange = false;
                                isred = false;
                                islaser = false;
                                ballXdirTwo=3;
                                ballYdirTwo=6;
                                playerWidth =100;

                            }


                        }
                    }

                }
            }


        }
        if (!level1 && !level2 && !level3 && levelM) {

            A:
            for (int i = 0; i < mapM.map.length; i++) {
                for (int j = 0; j < mapM.map[0].length; j++) {
                    if (mapM.map[i][j] > 0) {
                        int brickX = j * mapM.brickWidth;
                        int brickY = i * mapM.brickHeight + 90;
                        int brickWidth = mapM.brickWidth;
                        int brickHeight = mapM.brickHeight;
                        Rectangle rec = new Rectangle(brickX, brickY, brickWidth, brickHeight);
                        Rectangle ballrec = new Rectangle(ballPosX, ballPosY, 20, 20);
                        Rectangle brickrect=rec;
                        if (ballrec.intersects(rec)) {
                            if (playSound) {
                                sound.blocks();
                            }
                            setBrickValue(1, i, j);
                            totalbricksM--;
                            score += 10;

                            if (finsh_power == true) {
                                if (PowerUps.get_randNum() < 0.2 && finsh_power == true) {

                                    PowerUps.powerXpos = brickX;
                                    PowerUps.powerYpos = brickY;
                                    PowerUps.eatbrick = true;
                                    isDrawPower = true;
                                    powerUp = new PowerUps();
                                    finsh_power = false;

                                } else {
                                    PowerUps.eatbrick = false;
                                    finsh_power = true;

                                }
                            }
                            if (isgreen != true) {

                                if (ballPosX + 19 <= rec.x || ballPosX + 1 >= rec.x + ballrec.width) {
                                    ballXdirM = -ballXdirM;
                                } else {
                                    ballYdirM = -ballYdirM;
                                }
                            }
                            break A; //for breaking the out loop;
                        }
                        if (islaser) {
                            Rectangle laserrect = new Rectangle(lasers[countlaser].startx, lasers[countlaser].starty, 10, 10);
                            Rectangle rect_ = new Rectangle(brickX, brickY, mapM.brickWidth, mapM.brickHeight);
                            if (laserrect.intersects(rect_)) {
                                if(playSound) {
                                    sound.laser();
                                }
                                laserIntersect = true;
                                mapM.setbrickvalue(0, i, j);
                                totalbricksM--;
                                score += 5;
                                if (finsh_power == true) {
                                    if (PowerUps.get_randNum() < 0.2 && finsh_power == true) {

                                        PowerUps.powerXpos = brickX;
                                        PowerUps.powerYpos = brickY;
                                        PowerUps.eatbrick = true;
                                        isDrawPower = true;
                                        powerUp = new PowerUps();
                                        finsh_power = false;


                                    } else {
                                        PowerUps.eatbrick = false;
                                        finsh_power = true;

                                    }
                                }
                                if (isgreen != true) {
                                    if (ballPosX + 19 <= brickrect.x || ballPosY + 1 >= brickrect.x + brickrect.width) {
                                        ballXdirM = -ballXdirM;
                                    } else {
                                        ballYdirM = -ballYdirM;
                                    }
                                }
                                break A;
                            }
                        }

                        Rectangle powerRect=new Rectangle(PowerUps.powerXpos,PowerUps.powerYpos,mapM.brickWidth,map.brickHeight);
                        Rectangle playerRect=new Rectangle(playerX,600,playerWidth,10);

                        if (powerRect.intersects(playerRect))
                        {
                            finsh_power = true;
                            PowerUps.powerXpos = 640;
                            if (PowerUps.blue)
                            {
                                playerWidth =130;
                                isgreen= false;
                                isred = false;
                                islaser = false;
                                ballXdirM =3;
                                ballYdirM=6;
                                isOrange = false;
                            }

                            else if (PowerUps.red)
                            {
                                playerWidth =100;
                                isgreen= false;
                                isOrange = false;
                                ballXdirM =3;
                                ballYdirM=6;
                                isred = true;

                                if (isred)
                                {
                                    lasers[countlaser] = new laser();
                                    lasers[countlaser].setStartx((GamePlay.playerX)+(GamePlay.playerWidth/2));
                                    lasers[countlaser].setStarty(600);
                                    islaser= true;
                                }


                            }

                            else if (PowerUps.orange)
                            {
                                isgreen= false;
                                isOrange = true;
                                isred = false;
                                islaser = false;
                                playerWidth =100;

                                if (isOrange)
                                {
                                    ballXdirM =2;
                                    ballYdirM=4;
                                }
                            }

                            else if (PowerUps.gray)
                            {
                                isgreen= false;
                                isOrange = false;
                                isred = false;
                                playerWidth =100;
                                ballXdirM =3;
                                ballYdirM=6;
                                if (lives != 3 && lives !=0)
                                    lives++;


                            }
                            else if (PowerUps.green)
                            {
                                isgreen= true;
                                isOrange = false;
                                isred = false;
                                islaser = false;
                                ballXdirM =3;
                                ballYdirM =6;
                                playerWidth =100;

                            }


                        }

                    }

                }

            }
        }

        move();

        if (ballPosX < 0) { //for left border
            if (level1 && !level2 && !level3 && !levelM &&play) {
                ballXdir = -ballXdir;
            }
            if (!level1 && level2 && !level3 && !levelM &&play) {
                ballXdirOne = -ballXdirOne;
            }
            if (!level1 && !level2 && level3 && !levelM &&play) {
                ballXdirTwo = -ballXdirTwo;
            }
            if (!level1 && !level2 && !level3 && levelM &&play) {
                ballXdirM = -ballXdirM;
            }
        }
        if (ballPosY < 0 && play) { //for top border

            if (level1 && !level2 && !level3 && !levelM) {
                ballYdir = -ballYdir;
            }
            if (!level1 && level2 && !level3 && !levelM) {
                ballYdirOne = -ballYdirOne;
            }
            if (!level1 && !level2 && level3 && !levelM) {
                ballYdirTwo = -ballYdirTwo;
            }
            if (!level1 && !level2 && !level3 && levelM) {
                ballYdirM = -ballYdirM;
            }
        }
        if (ballPosX > 570  && play ) { //for right border
            if (level1 && !level2 && !level3 && !levelM) {
                ballXdir = -ballXdir;
            }
            if (!level1 && level2 && !level3 && !levelM) {
                ballXdirOne = -ballXdirOne;
            }
            if (!level1 && !level2 && level3 && !levelM) {
                ballXdirTwo = -ballXdirTwo;
            }
            if (!level1 && !level2 && !level3 && levelM) {
                ballXdirM = -ballXdirM;
            }
        }


        timecounter++;
        if (timecounter % 150 == 0) {
            timeseconds++;
            if (timeseconds == 60) {
                timeminutes++;
                timeseconds = 0;
            }
        }


        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) { }


    @Override
    public void keyPressed(KeyEvent e ) {


        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if (playerX >= 485) {
                playerX = 485;
            } else {
                MoveRight();
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            if (playerX <= 10) {
                playerX = 10;
            } else {
                MoveLeft();
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {

            if (totalbricks == 0 || totalbricks1 == 0 || totalbricks2 == 0 || totalbricksM == 0 ||forGameover) {
                if(!play)
                {
                    congrats=false;
                    play=true;
                    ballPosX=120;
                    ballPosY=350;
                    ballXdir=1;
                    ballYdir=2;
                    ballYdirOne=4;
                    ballXdirOne=2;
                    ballYdirTwo=6;
                    ballXdirTwo=3;
                    ballXdirM=3;
                    ballYdirM=6;
                    playerX=310;
                    score=0;
                    lives = 3;
                    totalbricks= MapGenerator.totalbricks;
                    totalbricks1=MapGeneratorOne.totalbricks;
                    totalbricks2=MapGeneratorTwo.totalbricks;
                    totalbricksM=MapGeneratorMonster.totalbricks;


                    if(level1 && !level2 && !level3 && !levelM){
                        map=new MapGenerator();
                    }
                    if(!level1 && level2 && !level3 && !levelM){
                        map1=new MapGeneratorOne();
                    }
                    if(!level1 && !level2 && level3 && !levelM){
                        map2=new MapGeneratorTwo();
                    }
                    if(!level1 && !level2 && !level3 && levelM){
                        mapM=new MapGeneratorMonster();
                    }
                    repaint();
                }

            }
        }

        if (e.getKeyCode() == KeyEvent.VK_P) {
            play=false;
            if (level1 && !level2 && !level3 && !levelM ) {
                ballXdir = 0;
                ballYdir = 0;

            }
            if (!level1 && level2 && !level3 && !levelM) {
                ballYdirOne=0;
                ballXdirOne=0;

            }
            if (!level1 && !level2 && level3 && !levelM) {
                ballYdirTwo=0;
                ballXdirTwo=0;

            }
            if (!level1 && !level2 && !level3 && levelM) {
                ballXdirM = 0;
                ballYdirM = 0;
            }
            new NewJFrame().setVisible(true);
        }


    }


    public void MoveRight(){
        play = true;
        playerX+=30;

    }
    public void MoveLeft(){
        play = true;
        playerX-=30;

    }
    public static void  move(){
        play=true;

        if (level1 && !level2 && !level3 && !levelM ) {
            ballPosX += ballXdir;
            ballPosY += ballYdir;
        }
        if (!level1 && level2 && !level3 && !levelM) {
            ballPosX += ballXdirOne;
            ballPosY += ballYdirOne;
        }
        if (!level1 && !level2 && level3 && !levelM ) {
            ballPosX += ballXdirTwo;
            ballPosY += ballYdirTwo;
        }
        if (!level1 && !level2 && !level3 && levelM ) {
            ballPosX += ballXdirM;
            ballPosY += ballYdirM;
        }

    }

    public void live(Graphics g)
    {
        if(lives>0)
        {
            lives--;
        }
        if(lives==2||lives==1)
        {
            ballPosX = 120; //the position of the ball in X-axis.
            ballPosY = 350; //the position of the ball in Y-axis.

            if (level1 && !level2 && !level3 && !levelM) {
                ballXdir=1;
                ballYdir=2;
            }
            if (!level1 && level2 && !level3 && !levelM) {
                ballYdirOne=4;
                ballXdirOne=2;
            }
            if (!level1 && !level2 && level3 && !levelM) {
                ballYdirTwo=6;
                ballXdirTwo=3;
            }
            if (!level1 && !level2 && !level3 && levelM) {
                ballXdirM=3;
                ballYdirM=6;
            }
        }
        if(lives==0)
        {
            if (level1 && !level2 && !level3 && !levelM && !play) {
                ballXdir=0;
                ballYdir=0;
            }
            if (!level1 && level2 && !level3 && !levelM && !play) {
                ballYdirOne=0;
                ballXdirOne=0;
            }
            if (!level1 && !level2 && level3 && !levelM && !play) {
                ballYdirTwo=0;
                ballXdirTwo=0;
            }
            if (!level1 && !level2 && !level3 && levelM && !play) {
                ballXdirM=0;
                ballYdirM=0;
            }
            g.setColor(new Color(96,232,250));
            g.setFont(new Font("serif",Font.BOLD,90));
            g.drawString("Game Over", 80, 300);
            g.setColor(new Color(31, 151, 167));
            g.setFont(new Font("serif",Font.BOLD,40));
            g.drawString("Your Score is: "+score, 170, 350);
            g.setColor(new Color(96,232,250));
            g.setFont(new Font("serif",Font.PLAIN,30));
            g.drawString("Press Enter FOR new game", 150, 400);
            forGameover = true;
            play = false;
            islaser = false;
            isgreen =false;
            isred = false;
            isOrange = false;
            playerWidth=100;

            if(level1 && !level2 && !level3 && !levelM){
                ballXdir = 1;
                ballYdir = 2;
            }
            else if(!level1 && level2 && !level3 && !levelM){
                ballXdirOne = 2;
                ballYdirOne = 4;
            }
            else if(!level1 && !level2 && level3 && !levelM){
                ballXdirTwo = 3;
                ballYdirTwo = 6;
            }
            else if(!level1 && !level2 && !level3 && levelM){
                ballXdirM = 3;
                ballYdirM = 6;
            }

        }
    }

    //Make the brick disappear.
    public void setBrickValue(int value , int raw , int col){

        if(level1 && !level2 && !level3 && !levelM){
            map.map [raw][col]=value;
        }
        else if(!level1 && level2 && !level3 && !levelM){
            map1.map [raw][col]=value;
        }
        else if(!level1 && !level2 && level3 && !levelM){
            map2.map [raw][col]=value;
        }
        else if(!level1 && !level2 && !level3 && levelM){
            mapM.map [raw][col]=value;
        }

    }



    @Override
    public void keyReleased(KeyEvent e) { }


}
