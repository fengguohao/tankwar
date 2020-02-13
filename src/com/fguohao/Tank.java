package com.fguohao;

import java.awt.*;
import java.util.ArrayList;

public class Tank {
    private int x=350,y=400;
    private final int SPEED=5;
    private Dir dir=Dir.UP;
    private Group group;
    private boolean moving=false;
    private TankFrame tf=null;
    private boolean live=true;
    public static int Width=ResourceMgr.tankD.getWidth();
    public static int Height=ResourceMgr.tankD.getHeight();

    public Tank(int x, int y, Dir dir,Group group, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group=group;
        this.tf=tf;
    }

    public TankFrame getTf() {
        return tf;
    }

    public void die() {
        this.live=false;
    }

    public boolean isLive() {
        return live;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public Rectangle getTankRec() {
        return new Rectangle(this.getX(),this.getY(),Tank.Width,Tank.Height);
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
        tf.bullets.add(new Bullet(x+20,y+20,dir,this)) ;
    }
}
