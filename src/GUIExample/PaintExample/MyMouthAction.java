package GUIExample.PaintExample;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class MyMouthAction extends Frame {
    ArrayList<Point> points;

    public MyMouthAction(String name){
        super(name);

        points = new ArrayList<>();

        setSize(500,500);
        setVisible(true);
        pack();
        windowClose(this);

        //针对窗口的鼠标监听器
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                MyMouthAction f = (MyMouthAction)e.getSource();
                // 点击触发paint事件
                Point point = new Point(e.getX(),e.getY());
                points.add(point);

                //点击鼠标重画一遍
                f.repaint();
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

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.green);
        for (int i=0; i<points.size(); i++){
            g.fillOval(points.get(i).x,points.get(i).y,10,10);
        }
    }
}
