package DrawingBoard20160422;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class wind extends JFrame {
	String array_paint[][];
	public static void main(String [] args)
	   {
		   wind wi= new wind();
		   wi.makewindow();
	   }
	
//	public void getScrean(){
//		point1=wi.dpaper.getLocationOnScreen();
//		Rectangle rect=new REctangle((int)point.getX(),(int)point.getY(),
//				wi.dpaper.getHeight());
//		Bufferedlmage image=robot.createSrceenCaputure(rect);
//		for(int i=0;i<image.getWidth();i++){
//			for(int j=0;j<image.getHeight();j++){
//				wi.array_paint[i][j]=image.getRGB(i,j);
//			}
//		}
//	}
//	
//	public void paint(Graphics g){
//		super.paint(g);//继承他本身所拥有的方法
//		System.out.println("已重绘");
//	    for(int i=0;i<array_paint.length;i++){
//	    	for(int j=0;j<array_paint.length;j++){
//	    		Color color =new Color(array_paint[i][j]);
//	    		g.setColor(color);
//	    		g.drawLine(i, j, i, j);
//	    	}
//	    }
//	}	

	
	//private Graphics getGraphics;
	   public void makewindow()
	   {
		   this.setTitle("第一画图");
			this.setSize(600, 600);
			this.setLocationRelativeTo(null);
			this.setDefaultCloseOperation(3);
			this.setLayout(new FlowLayout());
	//		this.setLayout(null);
			
		 
			
		    JPanel panel = (JPanel)this.getContentPane();
			panel.setOpaque(false);//设置ContentPane为透明
			this.setBackground(Color.WHITE);

			
			
			windlistener dl = new windlistener();
			
			
			// 4.在初始化界面方法中实例化按钮对象，添加到窗体上
					// 定义一个字符串数组，用来存储图形按钮的文字
					String[] shapeArray = { "画笔","刷子","橡皮","直线", "矩形","填充矩形", "圆","填充圆","弧线","填充弧线","圆角矩形","填充圆角矩形","3D矩形","填充3D矩形",
							"多边形","填充多边形","字符","图片","色子","蜗形","环形","圆网","球","固定圆柱","方形","胚状"};
					// 循环遍历数组
					for (int i = 0; i < shapeArray.length; i++) {
						JButton button = new JButton(shapeArray[i]);
						button.setPreferredSize(new Dimension(150,20));
						//8.给每一个按钮添加addActionListener()监听方法，指定DrawListener类的对象名
						button.addActionListener(dl);
						this.add(button);
						
					}
					
					JLabel labelName = new JLabel("输入字符：");//文本框输入字符串
					this.add(labelName);
					JTextField textName = new JTextField("0.0");
					textName.setPreferredSize(new java.awt.Dimension(210,30));
					this.add(textName);
					dl.setParameter(textName, this);
					
					JLabel large = new JLabel("输入线条大小：");//文本框刷子大小
					this.add(large);
					JTextField largenumber = new JTextField("5");
					textName.setPreferredSize(new java.awt.Dimension(210,30));
					this.add(largenumber);
					dl.setParameter1(largenumber, this);
					
					JLabel largeside = new JLabel("输入多边形边数：");//多边形边数
					this.add(largeside);
					JTextField sidenumber = new JTextField("4");
					textName.setPreferredSize(new java.awt.Dimension(210,30));
					this.add(sidenumber);
					dl.setParameter2(sidenumber, this);
					
					Color [] colorbow={Color.BLACK,Color.BLUE,Color.GREEN,Color.red,
							new Color(185,55,227)};
					for (int i = 0; i < colorbow.length; i++) {
						JButton button = new JButton();
						button.setBackground(colorbow[i]);//设置按钮的背景色
						button.setPreferredSize(new Dimension(30,30));//设置按钮的大小
						//8.给每一个按钮添加addActionListener()监听方法，指定DrawListener类的对象名
						button.addActionListener(dl);
						this.add(button);
						
					}
					
//			JPanel panel=new JPanel();
//		    panel.setOpaque(false);
//		    panel.setSize(300, 300);
//			panel.setBackground(Color.WHITE);
//			this.add(panel);
			
	
			
			this.setVisible(true);//之前
					//7.在DrawFrame类中，实例化DrawListener类的对象
					
					Graphics g=this.getGraphics();//之后
					
					
					dl.setG(g);
					dl.setG2(g);
					this.addMouseListener(dl);
					this.addMouseMotionListener(dl);
					System.out.print(g);//重绘须再写
					
					
	   }
}
