package com.fguohao;

import java.awt.*;
import java.io.Writer;

public class Bullet {
    private final int SPEED=10;
    private int x,y;
    private final int WIDTH=10,HEIGHT=10;
    private Dir dir=Dir.UP;
    private boolean live=true;
    private Tank tank=null;
    public static int Width=ResourceMgr.bulletD.getWidth();
    public static int Height=ResourceMgr.bulletD.getHeight();

    public Bullet(int x, int y, Dir dir,Tank tank) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tank=tank;
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

    public void paint(Graphics g){
        if(!live){
            tank.bullets.remove(this);
        }

        switch (dir){
            case UP:
                g.drawImage(ResourceMgr.bulletU,x,y,null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.bulletD,x,y,null);
                break;
            case LEFT:
                g.drawImage(ResourceMgr.bulletL,x,y,null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.bulletR,x,y,null);
                break;
            default:

        }
        move();
    }

    private void move(){
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
        if(this.x<0||this.y<0||this.x>TankFrame.GAME_WIDTH||this.y>TankFrame.GAME_HEIGHT){
            this.live=false;
        }
    }

    public void collidewith(Tank tank){
        Rectangle tankRec=new Rectangle(tank.getX(),tank.getY(),Tank.Width,Tank.Height);
        Rectangle bulletRec=new Rectangle(this.getX(),this.getY(),Bullet.Width,Bullet.Height);
        if(tankRec.intersects(bulletRec)){
            tank.setLive(false);
            this.live=false;
        }
    }
}
