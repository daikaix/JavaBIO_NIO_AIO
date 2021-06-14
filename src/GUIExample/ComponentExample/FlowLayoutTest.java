package GUIExample.ComponentExample;

import java.awt.*;

// 第一个界面
public class FlowLayoutTest {
    public static void main(String[] args) {
        Frame frame = new Frame();

        // Command+D
        Button button1 = new Button("button1");
        Button button2 = new Button("button1");
        Button button3 = new Button("button1");

        frame.setLayout(new FlowLayout(FlowLayout.CENTER));

        frame.setSize(200,200);
        frame.add(button1);
        frame.add(button2);
        frame.add(button3);

        frame.setVisible(true);
    }
}