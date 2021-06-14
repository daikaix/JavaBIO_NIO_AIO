package GUIExample.ActionExample;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

// 第一个界面
public class TestActionEvent2 {
    public static void main(String[] args) {
        Frame frame = new Frame();
        Button button1 = new Button("start");
        Button button2 = new Button("end");

        button2.setActionCommand("button2-stop");
        button1.addActionListener(e->{
            System.out.println(e.getActionCommand());
        });
        button2.addActionListener(e->{
            System.out.println(e.getActionCommand());
        });
        frame.add(button1);
        frame.add(button2);
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
