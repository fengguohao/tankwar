package com.fguohao;

import java.awt.*;
import java.io.Writer;

public class Bullet {
    private final int SPEED=10;
    private int x,y;
    private final int WIDTH=10,HEIGHT=10;
    private Dir dir=Dir.UP;

    public Bullet(int x, int y, Dir dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    public void paint(Graphics g){
        Color c=g.getColor();
        g.setColor(Color.red);
        g.fillOval(x,y, WIDTH,HEIGHT);
        g.setColor(c);
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
    }
}
