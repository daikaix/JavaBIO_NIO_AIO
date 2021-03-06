# JavaBIO_NIO_AIO
Java IO模型的探究和使用



# Java GUI
IDEA Structure 查看类结构

1. 简介
基本组件，窗口，弹窗，面板，文本框，列表框
按钮，图片，监听事件，鼠标，键盘事件

Swing AWT，界面不美观，需要jre环境

2. AWT
    1. 介绍
       包含很多类和接口：GUI: 图形界面编程
       元素：窗口，按钮，文本框
       java.awt包
       组件Component => button,TextArea,Label
                       (上面被存放在容器中，add)
                    => 容器Container  => window (Frame,Dialog)
                                     => Panel(面板) => Applet
    2. 组件和容器
       Frame()  =>
           1. setVisible,setSize,setBackground
           2. 设置弹出地点，setLocation  设置大小固定，setResizable(false)
           3. 自定义MyFrame, 然后可以直接获取需要的Frame
           4. 设置布局方式：setLayout()
           5. 重写paint()：
                g.setColor => 用完还原到最初的颜色
                g.fillOval => 画点，x,y,w,h
              Frame重画界面： f.repaint()

       Panel()  [ Panel 是一个空间，但不能单独存在 ]
                => setBounds,setBackground

    3. 监听事件
        1. 窗口监听 => frame.addWindowListener
           适配器模式，new windowListener => new WindowAdapter (不能是windowListener，会重写所有方法)
           退出的函数：System.exit(0);  f.setVisible()
           由于必须使用，直接写成一个类方法
           windowClosing
           window激活

        2. button.addActionListener()
           重写actionPerformed(ActionEvent e) 该方法 => lambda: (e)->{}
           button.setActionCommand()
           可以从event中getActionCommand() 实现一个方法对不同button不同效果

        3. textField.addActionListener 通过enter键点击
           TextField t = (TextField)e.getSource();
           t.getText(); 获取输入的数据
           t.setText(""); 清空输入框

        4. 鼠标监听：想要实现鼠标画画（针对窗口的鼠标监听器）this.addMouseListener
           1. 重写 MouseAdapter() 方法 => mousePressed 鼠标按压方法
           2. 鼠标事件：event.getX() .getY()  => 把鼠标位置存储到集合之中

        5. 键盘监听
           1. addKeyListener => keyPressed键盘按压方法
              e.getKeyCode() 获取键码
              KeyEvent.VK_UP 上键

    4. 布局管理器  自动布局：.pack()
        流式布局：new FlowLayout(FlowLayout.CENTER) [ LEFT,RIGHT ]
        5分布局：frame.add(button1,BorderLayout.EAST);
        栅格布局：frame.setLayout(new GridLayout(3,2)); 一共分为6个格子 设置grid = xx 间距
        绝对布局：frame.setLayout(null); xxx.setbounds(x,x,x,x);

3. Swing
    1. JFrame
        首先 => setBounds
        关闭事件 => frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE)

        获取对应container => Container container = getContentPane();
        为容器添加布局 => container.setLayout();

        背景颜色改变：container.setBackground(Color.green);
        添加标签：container.add(new JLabel());
        设置居中：label.setHorizontalAlignment(SwingConstants.CENTER);

        最常使用图片图标：URL = file:/Users/daikaixuan/MyCode/JavaBIO_NIO_AIO/target/production/JavaBIO_NIO_AIO/GUIExample/SwingExample/0.jpg
           获取方式：MyImageIcon.class.getResource("0.jpg") => new ImageIcon(url)
           添加到Label：label.setIcon(imageIcon)

        图片按钮：通过获取Icon, button.setIcon, setToolTipText()

        为控件添加事件: xxx.addXXXListener()

        无需使用：
        添加图标 => 实现Icon接口, 传入width,height参数，重写方法
                  声明图标, new JLabel("icontest",myIcon,SwingConstants.CENTER)
        最后设置可见性： setVisible

    2. JDialog
        1. JDialog 与 JFrame 类似, 但需要对Frame进行绑定
           super(frame,"第一个JDialog窗体",true);
        2. 弹窗不需要关闭事件
        3. 调用 => new MyDialog()

    3. JPanel 与 Panel一致：new JPanel(new GridLayout(1,3))
       JTextArea => textField  => setText();
       图片按钮 => 通过获取Icon, button.setIcon, setToolTipText()
       单选框 => JRadioButton => ButtonGroup group => add进去
       多选框 => JCheckBox
                获取值 => 直接遍历Component，获取是否isSelected()

       下拉 => 事件获取信息，e.getSource()  => box.getSelectedIndex(), getSelectedItem()
       列表 => JList jList = new JList(contents); contents为列表


       文本框,密码框,文本域
             => textField.setEchoChar('*'); 设置替换符号
                JPasswordField,JTextField


    4. 使用伸缩条：JScrollPane pane = new JScrollPane(jTextArea);
                 container.add(pane);
