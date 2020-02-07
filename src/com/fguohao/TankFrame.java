package com.fguohao;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class   TankFrame extends Frame {
    int x=10,y=10;
    TankFrame(){

        setSize(800,600);
        setTitle("tank war");
        setVisible(true);

        this.addKeyListener(new MyKeyListener());
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
    @Override
    public void paint(Graphics g){

        System.out.println("paint");
        g.fillRect(x,y,100,100);
        x+=10;


    }

    class  MyKeyListener extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            System.out.println("key pressed");
            repaint();
        }

        @Override
        public void keyReleased(KeyEvent e) {
            System.out.println("key released");
            repaint();
        }
    }

}
