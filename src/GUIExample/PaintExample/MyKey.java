package GUIExample.PaintExample;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class MyKey extends Frame {

    public MyKey(String name){
        super(name);

        setBounds(1,2,500,500);
        setVisible(true);
        pack();
        windowClose(this);

        //针对窗口的鼠标监听器
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();  //每个键盘上的键对应一个值
                if (keyCode == KeyEvent.VK_UP){
                    System.out.println("shangjian");
                }
            }
        });
    }

    private static void windowClose(Frame frame){
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
