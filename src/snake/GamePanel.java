package snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.util.Random;

public class GamePanel extends JPanel implements ActionListener{

    //定义蛇的数据结构
    int length;
    int[] snakeX = new int[600];
    int[] snakeY = new int[500];
    String fx;
    //游戏状态
    boolean isStart = false;
    boolean isFalse = false;
    //定时器  1000ms - 1s
    Timer timer = new Timer(100,this);
    //食物坐标
    int foodx;
    int foody;
    Random random = new Random();
    //积分展示
    int score;


    public void init(){
        length = 3;
        snakeX[0] = 100;
        snakeY[0] = 100;
        snakeX[1] = 75;
        snakeY[1] = 100;
        snakeX[2] = 50;
        snakeY[2] = 100;
        fx = "R";
        foodx = 25 + 25*random.nextInt(34);
        foody = 75 + 25*random.nextInt(24);
        score = 0;
    }

    public GamePanel(){
        init();
        this.setFocusable(true);

        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                if (keyCode == KeyEvent.VK_SPACE){
                    if (isFalse){
                        //重新开始
                        isFalse = false;
                    }
                    else {
                        isStart = !isStart;
                    }
                    repaint();
                }
                else if (keyCode == KeyEvent.VK_LEFT){
                    fx = "L";
                }else if (keyCode == KeyEvent.VK_RIGHT){
                    fx = "R";
                }else if (keyCode == KeyEvent.VK_UP){
                    fx = "U";
                }else if (keyCode == KeyEvent.VK_DOWN){
                    fx = "D";
                }
            }
        });

        // 添加事件监听，实现定时器
        timer.start();
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);  //清屏
        this.setBackground(Color.WHITE);
        Data.getHeader().paintIcon(this,g,25,11);
//        g.setColor(Color.BLACK);
        g.fillRect(25,75,850,600);
        //画积分
        g.setColor(Color.BLACK);
        g.setFont(new Font("微软雅黑",Font.BOLD,18));
        g.drawString("长度"+length,750,30);
        g.drawString("分数"+score,750,50);

        //画食物
        Data.getFood().paintIcon(this,g,foodx,foody);

        //画头
        if (fx.equals("R")){
            Data.getRight().paintIcon(this,g,snakeX[0],snakeY[0]);
        }
        else if (fx.equals("L")){
            Data.getLeft().paintIcon(this,g,snakeX[0],snakeY[0]);
        }
        else if (fx.equals("U")){
            Data.getUp().paintIcon(this,g,snakeX[0],snakeY[0]);
        }
        else {
            Data.getDown().paintIcon(this,g,snakeX[0],snakeY[0]);
        }

        //画身体
        for(int i=1; i<length; i++){
            Data.getBody().paintIcon(this,g,snakeX[i],snakeY[i]);
        }

        // 游戏状态
        if(isStart == false){
            g.setColor(Color.WHITE);
            g.setFont(new Font("微软雅黑",Font.BOLD,40));
            g.drawString("按空格键开始游戏",300,300);
        }

        if (isFalse == true){
            g.setColor(Color.RED);
            g.setFont(new Font("微软雅黑",Font.BOLD,40));
            g.drawString("你的游戏失败了！",300,300);
        }
    }

    // 事件监听，通过固定事件来刷新，1s = 10次
    @Override
    public void actionPerformed(ActionEvent e) {
        if(isStart && !isFalse){//开始，让小蛇右移
            if(snakeX[0] == foodx && snakeY[0]==foody){
                length++;
                score+=10;
                foodx = 25 + 25*random.nextInt(34);
                foody = 75 + 25*random.nextInt(24);
            }

            for(int i=length-1; i>=1; i--){
                snakeX[i]=snakeX[i-1];
                snakeY[i]=snakeY[i-1];
            }
            if (fx == "R"){
                snakeX[0]+=25;
            }else if(fx == "L"){
                snakeX[0]-=25;
            }else if(fx == "U"){
                snakeY[0]-=25;
            }else if(fx == "D"){
                snakeY[0]+=25;
            }


            if (snakeX[0] > 850 || snakeX[0]<25
            || snakeY[0] > 650 || snakeY[0]<75 ){
                init();
                isFalse = true;
            }
            for (int i=1; i<length; i++){
                if (snakeX[0] == snakeX[i] && snakeY[0] == snakeY[i]) {
                    init();
                    isFalse = true;
                    break;
                }
            }
            repaint(); //重画页面
        }
        timer.start();
    }
}
