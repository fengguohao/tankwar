package com.fguohao;

import java.awt.*;
import java.util.ArrayList;

public class Tank {
    public ArrayList<Bullet> bullets = new ArrayList<Bullet>();
    private int x=350,y=400;
    private final int SPEED=5;
    private Dir dir=Dir.UP;
    private boolean moving=false;
    private TankFrame tf=null;
    private boolean live=true;
    public static int Width=ResourceMgr.tankD.getWidth();
    public static int Height=ResourceMgr.tankD.getHeight();

    public boolean isLive() {
        return live;
    }

    public void setLive(boolean live) {
        this.live = live;
    }

    public Tank(int x, int y, Dir dir, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf=tf;
    }

    public void paint(Graphics g){
        this.move(moving);
        switch (dir){
            case UP:
                g.drawImage(ResourceMgr.tankU,x,y,null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.tankD,x,y,null);
                break;
            case LEFT:
                g.drawImage(ResourceMgr.tankL,x,y,null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.tankR,x,y,null);
                break;
            case LEFTDOWN:
                g.drawImage(ResourceMgr.tankLD,x,y,null);
                break;
            case LEFTUP:
                g.drawImage(ResourceMgr.tankLU,x,y,null);
                break;
            case RIGHTDOWN:
                g.drawImage(ResourceMgr.tankRD,x,y,null);
                break;
            case RIGHTUP:
                g.drawImage(ResourceMgr.tankRU,x,y,null);
                break;
            default:
        }

    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    private void move(boolean moving){
        if(moving){
            switch(dir){
                case UP:
                    y-=SPEED;
                    break;
                case DOWN:
                    y+=SPEED;
                    break;
                case LEFT:
                    x-=SPEED;
                    break;
                case RIGHT:
                    x+=SPEED;
                    break;
                case LEFTUP:
                    x-=SPEED;
                    y-=SPEED;
                    break;
                case LEFTDOWN:
                    x-=SPEED;
                    y+=SPEED;
                    break;
                case RIGHTUP:
                    x+=SPEED;
                    y-=SPEED;
                    break;
                case RIGHTDOWN:
                    x+=SPEED;
                    y+=SPEED;
                    break;
                default:;
            }
        }

    }

    public void fire(){
        bullets.add(new Bullet(x+20,y+20,dir,this)) ;
    }
}
