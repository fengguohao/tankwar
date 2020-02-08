package com.fguohao;

import java.awt.*;

public class Tank {
    private int x=350,y=400;
    private final int SPEED=5;
    private Dir dir=Dir.UP;
    private boolean moving=false;

    public Tank(int x, int y, Dir dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    public void paint(Graphics g){
        this.move(moving);
        g.fillRect(x,y,10,10);
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
}
