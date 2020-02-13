package com.fguohao;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class  TankFrame extends Frame {
    static final int  GAME_WIDTH=800,GAME_HEIGHT=600;
    Tank myTank=new Tank(350,400,Dir.UP,this);
    Bullet bl=new Bullet(350,350,Dir.UP,myTank);
    ArrayList<Tank> tanks=new ArrayList<>();

    TankFrame(){

        setSize(GAME_WIDTH,GAME_HEIGHT);
        setTitle("tank war");
        setVisible(true);

        this.addKeyListener(new MyKeyListener());
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    Image offScreenImage=null;
    @Override
    public void update(Graphics g){
        if(offScreenImage==null){
            offScreenImage=this.createImage(GAME_WIDTH,GAME_HEIGHT);
        }
        Graphics gOffscreen=offScreenImage.getGraphics();
        Color c=gOffscreen.getColor();
            gOffscreen.setColor(Color.BLACK);
            gOffscreen.fillRect(0,0,GAME_WIDTH,GAME_HEIGHT);
            gOffscreen.setColor(c);
            paint(gOffscreen);
            g.drawImage(offScreenImage,0,0,null);
    }

    @Override
    public void paint(Graphics g){
        myTank.paint(g);
        for(int i=0;i<myTank.bullets.size();i++){
            myTank.bullets.get(i).paint(g);
        }
        for(int i=0;i<tanks.size();i++){
            if(!tanks.get(i).isLive()){
                tanks.remove(i);
                continue;
            }
            tanks.get(i).paint(g);
        }
        for(int i=0;i<myTank.bullets.size();i++){
            for(int j=0;j<tanks.size();j++){
                myTank.bullets.get(i).collidewith(tanks.get(j));
            }
        }
    }

    class  MyKeyListener extends KeyAdapter {
        /**
         * 四个boolean用于表示按键按下
         */
        boolean BL=false;
        boolean BR=false;
        boolean BU=false;
        boolean BD=false;

        @Override
        public void keyPressed(KeyEvent e) {
            int key=e.getKeyCode();
            switch (key){
                case KeyEvent.VK_UP:
                    BU=true;
                    break;
                case KeyEvent.VK_DOWN:
                    BD=true;
                    break;
                case KeyEvent.VK_LEFT:
                    BL=true;
                    break;
                case KeyEvent.VK_RIGHT:
                    BR=true;
                    break;
                case KeyEvent.VK_SPACE:
                    myTank.fire();
                    break;
                default:
                    ;
            }
            setMainTankDirection(myTank);
        }

        @Override
        public void keyReleased(KeyEvent e) {
               int key=e.getKeyCode();
               switch(key){
                   case KeyEvent.VK_UP:
                       BU=false;
                       break;
                   case KeyEvent.VK_DOWN:
                       BD=false;
                       break;
                   case KeyEvent.VK_LEFT:
                       BL=false;
                       break;
                   case KeyEvent.VK_RIGHT:
                       BR=false;
                       break;
                   default:;
               }
               setMainTankDirection(myTank);
        }

        private void setMainTankDirection(Tank myTank){
            if(!BR&&!BU&&!BL&&!BD){
                myTank.setMoving(false);
            }
            else {
                myTank.setMoving(true);
            }

            if(BU){
                myTank.setDir(Dir.UP);
            }
            if(BD){
                myTank.setDir(Dir.DOWN);
            }
            if(BL){
                myTank.setDir(Dir.LEFT);
            }
            if(BR){
                myTank.setDir(Dir.RIGHT);
            }
            if(BU&&BL){
                myTank.setDir(Dir.LEFTUP);
            }
            if(BU&&BR){
                myTank.setDir(Dir.RIGHTUP);
            }
            if(BD&&BL){
                myTank.setDir(Dir.LEFTDOWN);
            }
            if(BD&&BR){
                myTank.setDir(Dir.RIGHTDOWN);
            }
        }

    }

}
