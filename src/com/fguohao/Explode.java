package com.fguohao;

import java.awt.*;

public class Explode {
    public static final int Height=ResourceMgr.explored[0].getHeight(),Width=ResourceMgr.explored[0].getWidth();
    private int x,y;
    private boolean live=true;
    private TankFrame tf;
    private int step=0;

    public Explode(int x, int y, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.tf = tf;
    }

    public void paint(Graphics g){
        if(this.live){
            g.drawImage(ResourceMgr.explored[step++],x,y,null);
        }
        if(step==16){
            this.live=false;
        }
    }
}
