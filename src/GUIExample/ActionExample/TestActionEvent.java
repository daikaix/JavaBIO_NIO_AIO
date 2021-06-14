package GUIExample.ActionExample;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

// 第一个界面
public class TestActionEvent {
    public static void main(String[] args) {
        Frame frame = new Frame();
        Button button = new Button();

        button.addActionListener(new MyActionListener());
        frame.add(button);
        frame.pack(); // 最优布局
        frame.setVisible(true);
        windowClose(frame);

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

class MyActionListener implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("aaa");
    }
}