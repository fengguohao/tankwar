package com.fguohao;


import java.util.Random;

public class Main {

    public static void main(String[] args) throws InterruptedException{
        TankFrame f=new TankFrame();
        Random rand=new Random();
        int initTankCount=PropertyMgr.getInt("initTankCount");
        for(int i=0;i<initTankCount;i++){
            f.tanks.add(new Tank(rand.nextInt(200),rand.nextInt(600), Dir.RIGHT,Group.BAD,f));
            f.tanks.get(i).setMoving(true);
        }
        while(true) {
            Thread.sleep(50);
            f.repaint();
        }
    }
}
