package GUIExample.PaintExample;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyPaint extends Frame {
    MyPaint(){
        setSize(500,500);
        setVisible(true);
        pack();
        windowClose(this);
    }

    private static void windowClose(Frame frame){
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }


    @Override
    public void paint(Graphics g) {
        g.setColor(new Color(1,1,1));
        //g.drawOval(100,100,100,100);
        g.fillOval(100,100,100,100);

        g.setColor(Color.green);
        g.fillRect(150,200,200,200);

    }
}
