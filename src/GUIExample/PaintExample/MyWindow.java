package GUIExample.PaintExample;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyWindow extends Frame {
    public MyWindow(String name){
        super(name);
        setSize(500,500);
        setVisible(true);
        pack();
        //windowClose(this);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                setVisible(false);
            }

            @Override
            public void windowActivated(WindowEvent e) {
                setTitle("asdasd");
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
                super.windowDeactivated(e);
            }
        });
    }

    private static void windowClose(Frame frame){
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Frame f = (Frame)e.getSource();
                f.setVisible(false);
                //System.exit(0);
            }
        });
    }
}
