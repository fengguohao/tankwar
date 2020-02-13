package com.fguohao;


public class Main {

    public static void main(String[] args) throws InterruptedException{
        TankFrame f=new TankFrame();
        for(int i=0;i<=4;i++){
            f.tanks.add(new Tank(50+i*80,200,Dir.DOWN,f));
        }
        while(true) {
            Thread.sleep(50);
            f.repaint();
        }
    }
}
