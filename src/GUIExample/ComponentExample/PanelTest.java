package GUIExample.ComponentExample;

import java.awt.*;

// Panel 是一个空间，但不能单独存在
public class PanelTest {
    public static void main(String[] args) {
        Frame frame = new Frame();
        Panel panel = new Panel();

        frame.setLayout(null);
        frame.setBounds(300,300,500,500);
        frame.setBackground(new Color(128, 84, 70));

        // panel 设置坐标
        panel.setBounds(50,50,400,400);
        panel.setBackground(new Color(84, 70, 128));

        frame.add(panel);
        frame.setVisible(true);
    }
}