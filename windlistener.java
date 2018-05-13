package DrawingBoard20160422;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.ImageObserver;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;


public class windlistener extends MouseAdapter implements ActionListener,ImageObserver{
	// 

		private String shape="Line";//声明存储图形属性
		private Color color = Color.black;//声明存储颜色属性
		private int side=4;
		private int large=5;
		
		//10.定义一个方法接收Graphics画笔画布对象
		private Graphics2D g2;
		private Graphics g ;//声明一个画笔画布对象属性
	    


		public void setG(Graphics g){
	    	this.g=g;
	    }
	    public void setG2(Graphics g2){
		this.g2 = (Graphics2D)g2;
	    this.g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);//设置抗锯齿  
		}   
		ImageIcon image = new ImageIcon(this.getClass().getResource("0001.JPG"));//从这个包中获取“名字”的图片
	    Image I=image.getImage();
	    
	    private JTextField textName;//文本框输入字符串
	    private JTextField textName1;
	    private JTextField textName2;
		private wind wi;//窗体界面对象
		
		public void setParameter(JTextField textName, 
				wind wi) {
			this.textName = textName;
			this.wi = wi;}
		public void setParameter1(JTextField textName, 
				wind wi) {
			this.textName1 = textName;
			this.wi = wi;}
		public void setParameter2(JTextField textName, 
				wind wi) {
			this.textName2 = textName;
			this.wi = wi;}
		
//		public void changcolor(){//颜色渐变方法
//			 ired=ired+2;iblue=iblue+2;igreen=igreen+2;
//	        	if(ired>255){ired=255;}if(iblue>255){iblue=255;}if(igreen>255){igreen=255;}
//	        	g.setColor(new Color(ired,igreen,iblue));
//		}
		
		private int x1,y1,x2,y2;//声明存储按下和释放动作时的坐标值
		private Font f=new Font("Times",Font.BOLD,50);//字体类，设置字体属性
		/**
		 * 5.实现接口中的抽象方法。
		 * 只要你在事件源(JButton)上发送动作事件，就会自动的执行此方法
		 */
	    public void actionPerformed(ActionEvent e){
	    	//6.在实现的方法中，获取图形和颜色
	    	if(!"".equals(e.getActionCommand())){
	    		shape=e.getActionCommand();
	    		System.out.println("shape="+shape);
	    	}else{
	    		JButton button=(JButton)e.getSource();//获取事件源对象,返回：最初发生 Event 的对象
	    		color = button.getBackground();//获取按钮的背景色
	    		System.out.println("color="+color);
	    	}
	    			
	    }
	    
	    /**
	     * 9.实现接口中的抽象方法
	     * 鼠标在事件源上发生鼠标点击动作时执行的方法
	     */
	    public void mouseClicked(MouseEvent e){
	    	
	    }

	    /**
	     * 9.实现接口中的抽象方法
	     * 鼠标在事件源上发生鼠标按下动作时执行的方法
	     */
	    public void mousePressed(MouseEvent e){
	      x1=e.getX();
	      y1=e.getY();
	      g.setColor(color);
	      this.large=Integer.parseInt(this.textName1.getText());//从文本框获取数字
	      this.g2.setStroke(new BasicStroke(large));//设置线条粗细
//	      switch (this.shape){
//	      case"刷子":g2.fillRect(x1, y1, this.large,this.large);
//	      break;
//		  
//	      }
	    }

	    /**
	     * 
	     * 9.实现接口中的抽象方法
	     * 鼠标在事件源上发生鼠标释放（松开）动作时执行的方法
	     */
	    public void mouseReleased(MouseEvent e){
	    	x2 = e.getX();
	    	y2 = e.getY();
//	    	int xx[]={x1,x1+30,x1+50,x2,x2+10,x1};
//	    	int yy[]={y1,y1+30,y1+50,y2,y2+10,y1};
	    	windlistener wm=new windlistener();
	    	this.side=Integer.parseInt(this.textName2.getText());
	    	int xx []=new int[side];
	    	int yy []=new int[side];
	    	String name= this.textName.getText();
	    	double x21=x1;double x22=x2;
	        double y21=y1;double y22=y2;
	        int xless1=Math.min(x1, x2);int yless1=Math.min(y1, y2);
	        int xmore1=Math.max(x1, x2);int ymore1=Math.max(y1, y2);
	        int xless2=Math.abs(x1-x2);int yless2=Math.abs(y1-y2);
//	        int ired=color.getRed();int iblue=color.getBlue();int igreen=color.getGreen();
	    	switch (this.shape)
	    	{case"直线":g.drawLine(x1, y1, x2, y2);
	    	            break;
	    	case"矩形": g.drawRect(x1, y1, Math.abs(x1-x2),Math.abs(y1-y2));
	    	            break;
	    	case"圆":  g.drawOval(x1, y1, Math.abs(x1-x2),Math.abs(y1-y2));
	                     break;
	    	case"弧线":      g.drawArc(x1, y1, Math.abs(x1-x2), Math.abs(y1-y2), Math.abs(x1-x2), Math.abs(y1-y2));
	    	              break;
	    	case"填充矩形":        g.fillRect(x1, y1, Math.abs(x1-x2), Math.abs(y1-y2));
	    	              break;
	    	case"圆角矩形":  g.drawRoundRect(x1, y1,Math.abs(x1-x2),  Math.abs(y1-y2), 30, 30);
	    	          break;
	    	case"填充圆角矩形": g.fillRoundRect(x1, y1,Math.abs(x1-x2),  Math.abs(y1-y2),30, 30);
	    	        break;
	    	case"3D矩形": g.draw3DRect(x1, y1,Math.abs(x1-x2),  Math.abs(y1-y2),false);
	    	        break;
	    	case"填充3D矩形": g.fill3DRect(x1, y1, Math.abs(x1-x2),  Math.abs(y1-y2), false);
	    	        break;
	    	case"填充弧线": g.fillArc(x1, y1, Math.abs(x1-x2), Math.abs(y1-y2), Math.abs(x1-x2), Math.abs(y1-y2));
	    	        break;
	    	case"填充圆": g.fillOval(x1, y1, Math.abs(x1-x2),Math.abs(y1-y2));
	    	        break;
	    	case"多边形": 
	    		    Random sj=new Random();
	    	        for(int i=0;i<this.side;i++){
	    	        	xx[i]=sj.nextInt(600);}
	    	        for(int i=0;i<this.side;i++){
	    	        	yy[i]=sj.nextInt(600);}
	    	        g.drawPolygon(xx,yy, this.side);
	    	         break;
	    	case"填充多边形": g.fillPolygon(xx, yy, 6);
	    	      break;
	    	case"字符":    
	    		           g.setFont(f); 
	    		           g.drawString(name, x1, y1);
	    		           break;
	    	case"图片": g.drawImage(I, x1, y1, 100, 100, Color.GREEN, this); 
	                break;
	        case"色子": suijidian[] a=new suijidian[4];
	        for(int j=0;j<4;j++){
	        	a[j]=new suijidian();
	        }
	    	for(int j=0;j<10000;j++){
	    		sezi s=new sezi(a[0],a[1],a[2],a[3]);
	    		g.setColor(new Color(250-j%250,j%250,j%250));
	    		g.drawLine(a[3].x, a[3].y,a[3].x, a[3].y);
	    		}
	    		break;
	        case"蜗形": 
	                    for(int i=0;i<10000;i++){
	                    	x22=x21;y22=y21;
	                    	x21=Math.sin(-2*y22)-Math.cos(-2*x22);
	                    	y21=Math.sin(-1.2*x22)-Math.cos(2*y22);
	                    	
	                    	x2=300+(int)(100*x21);y2=300+(int)(100*y21);
	                    	g.setColor(new Color(250-i%250,i%250,i%250));
	                    	g.drawLine(x2, y2,x2, y2);
	                    }
	                     break;
	        case"环形":for(int i=0;i<10000;i++){
            	x22=x21;y22=y21;
            	x21=-6.56*Math.sin(1.4*x22)-Math.sin(1.56*y22);
            	y21=1.4*Math.cos(1.4*x22)+Math.cos(1.56*y22);
            	x2=300+(int)(30*x21);y2=300+(int)(30*y21);
            	g.setColor(new Color(250-i%250,(i+150)%250,(i+350)%250));
            	g.drawLine(x2, y2,x2, y2);}
            break;
	        case"圆网":for(int j=0;j<1000;j++){
	        	for(int i=0;i<1000;i++){
            	x22=x21;y22=y21;
            	x21=y22-Math.signum(x22)*Math.sqrt(Math.abs(60*x22+60));
            	y21=2-x22;
            	x2=300+(int)(0.5*x21);y2=300+(int)(0.5*y21);//System.out.println("y2="+y2);
            	g.setColor(new Color(250-i%250,i%250,i%250));
            	g.drawLine(x2, y2,x2, y2);}
	        	x21+=10;y21+=10;
	        	}
	        	break;
	        case"球":
	            for(int i=0;i<Math.abs(x1-x2);i++){
	        	if(i%2==0){xless1++; yless1++;}
	        	xless2--;yless2--;
	        	this.changcolor();
	        	g.fillOval(xless1, yless1, xless2,yless2);}
	        	break;
	        case"固定圆柱":double slx=xless1;double sly=(y1+y2)/2;
	                       int centx=(x1+x2)/2;int centy=(y1+y2)/2;
	                       g.fillOval(xless1, yless1, xless2,yless2);
	        	for(int i=x1;i<centx;i++){
	        		double isly=Math.sqrt((Math.abs(y1-y2)/2)*Math.abs((y1-y2)/2)-(slx-centx)*(slx-centx)*(Math.abs(y1-y2)/2)*Math.abs((y1-y2)/2)/((centx-xless1)*(centx-xless1)));
	        	    int ssx =(int)slx; int ssy=(int) (sly+isly);//System.out.print(ssy+"  ");
//	        	    ired=ired+2;iblue=iblue+2;igreen=igreen+2;
//		        	if(ired>255){ired=255;}if(iblue>255){iblue=255;}if(igreen>255){igreen=255;}
//		        	g.setColor(new Color(ired,igreen,iblue));
	        	    this.changcolor();
	        	    g.drawLine(ssx, ssy, ssx, ssy+100);
	        	   slx++;}
	        	for(int i=centx;i<x2;i++){
	        		double isly=Math.sqrt((Math.abs(y1-y2)/2)*Math.abs((y1-y2)/2)-(slx-centx)*(slx-centx)*(Math.abs(y1-y2)/2)*Math.abs((y1-y2)/2)/((centx-xless1)*(centx-xless1)));
	        	    int ssx =(int)slx; int ssy=(int) (sly+isly);System.out.print(ssy+"  ");
	        	    this.changcolor();
	        	     g.drawLine(ssx, ssy, ssx, ssy+100);
	        	   slx++;}
	        	   break;
	        case"方形":int []xf=new int[4];int []yf=new int[4];
	          xf[0]=xless1;yf[0]=yless1;
	        	for(int i=0;i<Math.abs(x1-x2);i++){
	        	xless1++;yless1++;xmore1++;ymore1++;
	        	this.changcolor();
	        	g.drawLine(xless1, yless1, xmore1,ymore1);}
	        	xf[1]=xless1;yf[1]=yless1;
	        	for(int i=0;i<Math.abs(y1-y2);i++){
	        	xless1++;yless1--;xmore1++;ymore1--;
	        	this.changcolor();
	        	g.drawLine(xless1, yless1, xmore1,ymore1);}
	        	xf[2]=xless1;yf[2]=yless1;
	        	xf[3]=xf[2]-(xf[1]-xf[0]);yf[3]=yf[2]-(yf[1]-yf[0]);
	        	g.fillPolygon(xf, yf, 4);
	        break;
	        case"胚状":for(int j=0;j<1000;j++){
	        	for(int i=0;i<10000;i++){
            	x22=x21;y22=y21;
            	x21=y22-Math.signum(x22)*Math.sqrt(Math.abs(0.1*x22-10));
            	y21=-1000-x22;
            	x2=300+(int)(x21*2);y2=300+(int)(y21*2);//System.out.println("y2="+y2);
            	g.setColor(new Color(250-i%250,i%250,i%250));
            	g.drawLine(x2, y2,x2, y2);
	        }
	        	x21+=100;y21+=100;}
	        	break;
	    	}
	    	
	    }
	    private void changcolor(){
	    	int ired=color.getRed();int iblue=color.getBlue();int igreen=color.getGreen();
	    	ired=ired+2;iblue=iblue+2;igreen=igreen+2;
        	if(ired>255){ired=255;}if(iblue>255){iblue=255;}if(igreen>255){igreen=255;}
        	this.color=new Color(ired,igreen,iblue);
        	g.setColor(new Color(ired,igreen,iblue));
	    }

	    /**
	     * 9.实现接口中的抽象方法
	     * 鼠标进入事件源上时执行的方法
	     */
	    public void mouseEntered(MouseEvent e){
	    	
	    }
	    public void mouseDragged(MouseEvent e) {
	    	x2 = e.getX();
			y2 = e.getY();
			switch (this.shape){
			case"画笔":g2.drawLine(x1, y1,x2, y2);x1 = x2;y1 = y2;
			break;
			case"刷子":g2.fillRect(x1, y1, this.large,this.large);x1 = x2;y1 = y2;
			break;
			case"橡皮":g2.clearRect(x1, y1, this.large,this.large);x1 = x2;y1 = y2;
			break;
			}
	    }
	    
	    /**
	     * 9.实现接口中的抽象方法
	     * 鼠标离开事件源上时执行的方法
	     */
	    public void mouseExited(MouseEvent e){
	    	
	    }

		@Override
		public boolean imageUpdate(Image img, int infoflags, int x, int y,
				int width, int height) {
			// TODO Auto-generated method stub
			return false;
		}

		

	}


