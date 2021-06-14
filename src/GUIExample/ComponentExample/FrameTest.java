package GUIExample.ComponentExample;

import java.awt.*;

// 第一个界面
public class FrameTest {
    public static void main(String[] args) {
        //Frame对象
        Frame frame = new Frame();

        frame.setVisible(true);
        frame.setSize(400,400);
        frame.setBackground(new Color(70, 128, 70));
        frame.setLocation(200,200);
        frame.setResizable(true);
    }
}