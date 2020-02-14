package com.fguohao;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ResourceMgr {
    public static BufferedImage[] goodTankL=new BufferedImage[2],
            goodTankR=new BufferedImage[2],
            goodTankU=new BufferedImage[2],
            goodTankD=new BufferedImage[2],
            goodTankLD=new BufferedImage[2],
            goodTankLU=new BufferedImage[2],
            goodTankRD=new BufferedImage[2],
            goodTankRU=new BufferedImage[2];
    public static BufferedImage[] badTankL=new BufferedImage[2],
            badTankR=new BufferedImage[2],
            badTankU=new BufferedImage[2],
            badTankD=new BufferedImage[2];
    public static BufferedImage bulletL,bulletR,bulletU,bulletD;
    public static BufferedImage[] explored=new BufferedImage[16];
    static {
        try {
            goodTankU[0]=ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("image/GoodTank1.png"));
            goodTankL[0]=ImageUtil.rotateImage(goodTankU[0],-90);
            goodTankR[0]=ImageUtil.rotateImage(goodTankU[0],90);
            goodTankD[0]=ImageUtil.rotateImage(goodTankU[0],180);
            goodTankLD[0]=ImageUtil.rotateImage(goodTankU[0],-135);
            goodTankLU[0]=ImageUtil.rotateImage(goodTankU[0],-45);
            goodTankRD[0]=ImageUtil.rotateImage(goodTankU[0],135);
            goodTankRU[0]=ImageUtil.rotateImage(goodTankU[0],45);

            goodTankU[1]=ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("image/GoodTank2.png"));
            goodTankL[1]=ImageUtil.rotateImage(goodTankU[1],-90);
            goodTankR[1]=ImageUtil.rotateImage(goodTankU[1],90);
            goodTankD[1]=ImageUtil.rotateImage(goodTankU[1],180);
            goodTankLD[1]=ImageUtil.rotateImage(goodTankU[1],-135);
            goodTankLU[1]=ImageUtil.rotateImage(goodTankU[1],-45);
            goodTankRD[1]=ImageUtil.rotateImage(goodTankU[1],135);
            goodTankRU[1]=ImageUtil.rotateImage(goodTankU[1],45);

            badTankU[0]=ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("image/BadTank1.png"));
            badTankL[0]=ImageUtil.rotateImage(badTankU[0],-90);
            badTankR[0]=ImageUtil.rotateImage(badTankU[0],90);
            badTankD[0]=ImageUtil.rotateImage(badTankU[0],180);

            badTankU[1]=ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("image/BadTank2.png"));
            badTankL[1]=ImageUtil.rotateImage(badTankU[1],-90);
            badTankR[1]=ImageUtil.rotateImage(badTankU[1],90);
            badTankD[1]=ImageUtil.rotateImage(badTankU[1],180);

            bulletU=ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("image/bulletU.png"));
            bulletL=ImageUtil.rotateImage(bulletU,-90);
            bulletR=ImageUtil.rotateImage(bulletU,90);
            bulletD=ImageUtil.rotateImage(bulletU,180);

            for(int i=1;i<=16;i++){
                explored[i-1]=ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("image/e"+i+".gif"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
