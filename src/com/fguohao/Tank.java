package com.fguohao;

import javax.xml.bind.annotation.XmlList;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Tank {
    private int x=350,y=400;
    private final int SPEED=PropertyMgr.getInt("tankSpeed");
    private Dir dir=Dir.UP;
    private Group group;
    private boolean moving=false;
    private TankFrame tf=null;
    private boolean live=true;
    public static int Width=ResourceMgr.goodTankD[0].getWidth();
    public static int Height=ResourceMgr.goodTankD[0].getHeight();
    private Rectangle rect=new Rectangle();
    private Random rand=new Random();
    private int state=0;

    public Tank(int x, int y, Dir dir,Group group, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group=group;
        this.tf=tf;

        rect.x= x+2;
        rect.y=y+2;
        rect.width=Tank.Width-4;
        rect.height= Tank.Height-4;
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
        return rect;
    }

    public void paint(Graphics g){
        this.move(moving);
        switch (dir){
            case UP:
                g.drawImage(this.group==Group.GOOD?ResourceMgr.goodTankU[state++>8?0:1]:ResourceMgr.badTankU[state++>8?0:1],x,y,null);
                break;
            case DOWN:
                g.drawImage(this.group==Group.GOOD?ResourceMgr.goodTankD[state++>8?0:1]:ResourceMgr.badTankD[state++>8?0:1],x,y,null);
                break;
            case LEFT:
                g.drawImage(this.group==Group.GOOD?ResourceMgr.goodTankL[state++>8?0:1]:ResourceMgr.badTankL[state++>8?0:1],x,y,null);
                break;
            case RIGHT:
                g.drawImage(this.group==Group.GOOD?ResourceMgr.goodTankR[state++>8?0:1]:ResourceMgr.badTankR[state++>8?0:1],x,y,null);
                break;
            case LEFTDOWN:
                g.drawImage(ResourceMgr.goodTankLD[state++>8?0:1],x,y,null);
                break;
            case LEFTUP:
                g.drawImage(ResourceMgr.goodTankLU[state++>8?0:1],x,y,null);
                break;
            case RIGHTDOWN:
                g.drawImage(ResourceMgr.goodTankRD[state++>8?0:1],x,y,null);
                break;
            case RIGHTUP:
                g.drawImage(ResourceMgr.goodTankRU[state++>8?0:1],x,y,null);
                break;
            default:
        }
        if(state==16){
            state=0;
        }

    }

    private void move(boolean moving){
        if(this.getGroup()==Group.BAD){
           if(rand.nextInt(100)>95){
               randomDir();
           }

        }

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
        boundscheck();
        rect.x= x+2;
        rect.y=y+2;
    }

    private void randomDir(){
        this.dir=Dir.values()[rand.nextInt(4)];
    }

    public void boundscheck(){
        if(x<0) {
            x=0;
        }
        if(x>TankFrame.GAME_WIDTH-Tank.Width){
            x=TankFrame.GAME_WIDTH-Tank.Width;
        }
        if(y<50) {
            y=50;
        }
        if(y>TankFrame.GAME_HEIGHT-Tank.Height){
            y=TankFrame.GAME_HEIGHT-Tank.Height;
        }
    }

    public void fire(){
        tf.bullets.add(new Bullet(x+Tank.Width/2-Bullet.Width/2,y+ Tank.Height/2-Bullet.Height/2,dir,this)) ;
    }
}
