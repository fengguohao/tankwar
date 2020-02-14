package com.fguohao;

import java.awt.*;
import java.io.Writer;

public class Bullet {
    private final int SPEED=PropertyMgr.getInt("bulletSpeed");
    private int x,y;
    private final int WIDTH=10,HEIGHT=10;
    private Dir dir=Dir.UP;
    private Group group;
    private boolean live=true;
    private Tank tank=null;
    private TankFrame tf;
    private Rectangle rect=new Rectangle();
    public static int Width=ResourceMgr.bulletD.getWidth();
    public static int Height=ResourceMgr.bulletD.getHeight();

    public Bullet(int x, int y, Dir dir, Tank tank) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tank=tank;
        this.group=tank.getGroup();
        this.tf=tank.getTf();

        rect.x=x;
        rect.y=y;
        rect.width=Bullet.Width;
        rect.height=Bullet.Height;
    }

    public Rectangle getBulletRec() {
        return rect;
    }

    public void die() {
        this.live = false;
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


    public void paint(Graphics g){
        if(!live){
            tank.getTf().bullets.remove(this);
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
        rect.x=x;
        rect.y=y;
    }

    public void collidewith(Tank tank){
        if(tank.getGroup()!=this.group){
            if(tank.isLive()&&this.live&&tank.getTankRec().intersects(this.getBulletRec())){
                tank.die();
                this.die();
                tank.getTf().explodes.add(new Explode(tank.getX(),tank.getY(),tank.getTf()));
            }
        }

    }
}
