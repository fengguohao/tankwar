package com.fguohao;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Random;

public class  TankFrame extends Frame {
    Random rand=new Random();
    static final int  GAME_WIDTH=PropertyMgr.getInt("GAME_WIDTH"),GAME_HEIGHT=PropertyMgr.getInt("GAME_HEIGHT");
    Tank myTank=new Tank(350,400,Dir.UP,Group.GOOD,this);
    Bullet bl=new Bullet(350,350,Dir.UP,myTank);
    public ArrayList<Bullet> bullets = new ArrayList<Bullet>();
    ArrayList<Tank> tanks=new ArrayList<>();
    ArrayList<Explode> explodes=new ArrayList<>();
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
        //画主战坦克
        if(myTank.isLive()){
            myTank.paint(g);
        }

        //画主战坦克子弹
        for(int i=0;i<bullets.size();i++){
            bullets.get(i).paint(g);
        }
        //画敌人坦克
        for(int i=0;i<tanks.size();i++){
            if(!tanks.get(i).isLive()){
                tanks.remove(i);
                continue;
            }
            if(rand.nextInt(10)>8){
                tanks.get(i).fire();
            }
            tanks.get(i).paint(g);
        }

        //检测是否被摧毁
        for(int k=0;k<bullets.size();k++){
            bullets.get(k).collidewith(myTank);
            for(int i=0;i<tanks.size();i++){
                bullets.get(k).collidewith(tanks.get(i));
            }
        }

        //爆炸
        for(int i=0;i<explodes.size();i++){
            explodes.get(i).paint(g);
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
                    if(myTank.isLive()){
                        myTank.fire();
                    }

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
