package com.fguohao;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ResourceMgr {
    public static BufferedImage tankL,tankR,tankU,tankD,tankLD,tankLU,tankRD,tankRU;
    public static BufferedImage bulletL,bulletR,bulletU,bulletD;
    public static BufferedImage[] explored=new BufferedImage[16];
    static {
        try {
            tankL=ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("image/tankL.gif"));
            tankR=ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("image/tankR.gif"));
            tankU=ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("image/tankU.gif"));
            tankD=ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("image/tankD.gif"));
            tankLD=ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("image/tankLD.gif"));
            tankLU=ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("image/tankLU.gif"));
            tankRD=ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("image/tankRD.gif"));
            tankRU=ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("image/tankRU.gif"));

            bulletL=ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("image/bulletL.gif"));
            bulletR=ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("image/bulletR.gif"));
            bulletU=ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("image/bulletU.gif"));
            bulletD=ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("image/bulletD.gif"));
            for(int i=1;i<=16;i++){
                explored[i-1]=ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("image/e"+i+".gif"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
