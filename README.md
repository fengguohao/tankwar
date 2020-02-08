# tankwar
 试着写一个带GUI的java程序，并且带着学习一下git
 根据马士兵老师的坦克大战进行
 //2.7  
 实现了Frame 的继承，继承到了TankFrame
 setVisible()  
 实现了按键时间监听 使用MyKeyListener extends KeyAdapter implements KeyListener extends EventListener

 定义了两个重载方法keyPressed 与keyReleased

 实现了paint方法的override

 实现了利用Thread.sleep阻塞线程实现刷新重绘（repaint）

//2.8
实现了class Tank 与 Bullet
封装思想，paint方法传递
实现了枚举类Dir
实现了双缓冲解决闪烁
