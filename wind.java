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
//		super.paint(g);//�̳���������ӵ�еķ���
//		System.out.println("���ػ�");
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
		   this.setTitle("��һ��ͼ");
			this.setSize(600, 600);
			this.setLocationRelativeTo(null);
			this.setDefaultCloseOperation(3);
			this.setLayout(new FlowLayout());
	//		this.setLayout(null);
			
		 
			
		    JPanel panel = (JPanel)this.getContentPane();
			panel.setOpaque(false);//����ContentPaneΪ͸��
			this.setBackground(Color.WHITE);

			
			
			windlistener dl = new windlistener();
			
			
			// 4.�ڳ�ʼ�����淽����ʵ������ť������ӵ�������
					// ����һ���ַ������飬�����洢ͼ�ΰ�ť������
					String[] shapeArray = { "����","ˢ��","��Ƥ","ֱ��", "����","������", "Բ","���Բ","����","��仡��","Բ�Ǿ���","���Բ�Ǿ���","3D����","���3D����",
							"�����","�������","�ַ�","ͼƬ","ɫ��","����","����","Բ��","��","�̶�Բ��","����","��״"};
					// ѭ����������
					for (int i = 0; i < shapeArray.length; i++) {
						JButton button = new JButton(shapeArray[i]);
						button.setPreferredSize(new Dimension(150,20));
						//8.��ÿһ����ť���addActionListener()����������ָ��DrawListener��Ķ�����
						button.addActionListener(dl);
						this.add(button);
						
					}
					
					JLabel labelName = new JLabel("�����ַ���");//�ı��������ַ���
					this.add(labelName);
					JTextField textName = new JTextField("0.0");
					textName.setPreferredSize(new java.awt.Dimension(210,30));
					this.add(textName);
					dl.setParameter(textName, this);
					
					JLabel large = new JLabel("����������С��");//�ı���ˢ�Ӵ�С
					this.add(large);
					JTextField largenumber = new JTextField("5");
					textName.setPreferredSize(new java.awt.Dimension(210,30));
					this.add(largenumber);
					dl.setParameter1(largenumber, this);
					
					JLabel largeside = new JLabel("�������α�����");//����α���
					this.add(largeside);
					JTextField sidenumber = new JTextField("4");
					textName.setPreferredSize(new java.awt.Dimension(210,30));
					this.add(sidenumber);
					dl.setParameter2(sidenumber, this);
					
					Color [] colorbow={Color.BLACK,Color.BLUE,Color.GREEN,Color.red,
							new Color(185,55,227)};
					for (int i = 0; i < colorbow.length; i++) {
						JButton button = new JButton();
						button.setBackground(colorbow[i]);//���ð�ť�ı���ɫ
						button.setPreferredSize(new Dimension(30,30));//���ð�ť�Ĵ�С
						//8.��ÿһ����ť���addActionListener()����������ָ��DrawListener��Ķ�����
						button.addActionListener(dl);
						this.add(button);
						
					}
					
//			JPanel panel=new JPanel();
//		    panel.setOpaque(false);
//		    panel.setSize(300, 300);
//			panel.setBackground(Color.WHITE);
//			this.add(panel);
			
	
			
			this.setVisible(true);//֮ǰ
					//7.��DrawFrame���У�ʵ����DrawListener��Ķ���
					
					Graphics g=this.getGraphics();//֮��
					
					
					dl.setG(g);
					dl.setG2(g);
					this.addMouseListener(dl);
					this.addMouseMotionListener(dl);
					System.out.print(g);//�ػ�����д
					
					
	   }
}
