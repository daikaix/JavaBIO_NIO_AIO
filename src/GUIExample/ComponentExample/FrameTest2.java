package GUIExample.ComponentExample;

import java.awt.*;

// 展示多个窗口
public class FrameTest2 {
    public static void main(String[] args) {
        MyFrame m1 = new MyFrame(100,100,200,200,Color.red);
        MyFrame m2 = new MyFrame(300,100,200,200,Color.green);
        MyFrame m3 = new MyFrame(100,300,200,200,Color.gray);
        MyFrame m4 = new MyFrame(300,300,200,200,Color.black);
    }
}

