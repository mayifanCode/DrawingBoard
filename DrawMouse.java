package com.myf.draw1025;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;

public class DrawMouse implements MouseListener, ActionListener,MouseMotionListener {
	private Graphics gr;
	private int x1, y1, x2, y2, x3, y3;
	private double x;
	private double y;	
	private int xf,yf,xl,yl,x0,y0;
	private String name;
    private int flag=0;
    private int flagq=0;
    private int step=1;
    private int flag_line=0;
    private Color color = Color.black;
    private double a=-1.2;
    private double b=1.6;
    private double c=-1;
    private double d=-1.5;
    private int index=0;
    private Shape[] arrayShape;
	public void setGr(Graphics g) {
		gr = g;
	}

	public void setArrayShape(Shape[] arrayShape)
	{
		this.arrayShape=arrayShape;
	}
	
	public void mouseClicked(MouseEvent e) {

		
		if ("任意边形".equals(name)){
			if(flag==0)
			{
				x0 = e.getX();
				y0 = e.getY();
				xf = e.getX();
				yf = e.getY();				
				flag=1;
			}
			else
			{
				xl = e.getX();
				yl = e.getY();
				gr.drawLine(xf, yf, xl, yl);
				set_shape(xf, yf, xl, yl,"直线",color);
				xf=xl;
			    yf=yl;
				if(e.getClickCount()==2)
				{
					flag=0;
					gr.drawLine(x0, y0, xl, yl);
					set_shape(x0, y0, xl, yl,"直线",color);
				}
			}
			
		}
		if("三角形".equals(name)){
			System.out.println(step); 
			   switch(step)
			   {
			   case 1:
				   x1=e.getX();
				   y1=e.getY();
				   step++;
				   break;
			   case 2:
				   x2=e.getX();
				   y2=e.getY();
				   gr.drawLine(x1, y1, x2, y2);
				   step++;
			       break;
			   case 3:
				   x3=e.getX();
				   y3=e.getY();
				   set_shape(x1,y1,x2,y2,"直线",color);
				   set_shape(x2,y2,x3,y3,"直线",color);
				   set_shape(x1,y1,x3,y3,"直线",color);
				   step=1;
				   gr.drawLine(x2, y2, x3, y3);
				   gr.drawLine(x1, y1, x3, y3);
				   break;		   
			   default:;
			   }
			 
			   
		}
		if("迭代图像".equals(name))
		{
			x=e.getX();
			y=e.getY();
			iterate(x,y); 
			//set_shape((int)x, (int)y, 0, 0,"迭代图像",color);
		}
		if("递归".equals(name))
		{
			  int xa=1+(int)(Math.random()*800);
			  int ya=1+(int)(Math.random()*800);
			  int xb=1+(int)(Math.random()*800);
			  int yb=1+(int)(Math.random()*800);
			  int xc=1+(int)(Math.random()*800);
			  int yc=1+(int)(Math.random()*800);
			  int xp=1+(int)(Math.random()*800);			  
			  int yp=1+(int)(Math.random()*800);		
			  int turn=1;
			  System.out.println("xa"+xa+"ya"+ya+"xb"+xb+"yb"+yb+"xc"+xc+"yc"+yc+"xp"+xp+"yp"+yp);
			  for(int i=0;i<10000;i++)
			  {
				  turn=1+(int)(Math.random()*3);
				  switch(turn)
				  {
				  case 1:
					  
					  xp=(xa+xp)/2;
					  yp=(ya+yp)/2;
					  gr.drawLine(xp, yp, xp, yp);
					  break;
				  case 2:
					  
					  xp=(xb+xp)/2;
					  yp=(yb+yp)/2;
					  gr.drawLine(xp, yp, xp, yp);					  
					  break;
				  case 3:
					  
					  xp=(xc+xp)/2;
					  yp=(yc+yp)/2;
					  gr.drawLine(xp, yp, xp, yp);				  
					  break	;			  
				  }
				  
				  
			  }
			
			
			
		}
	}

	public void mousePressed(MouseEvent e) {
		System.out.println("按下");
		if("矩形".equals(name)||"椭圆".equals(name))
		{
		x1 = e.getX();
		y1 = e.getY();
		}
		//System.out.println(name);
    	if ("曲线".equals(name))
    	{
    		flagq=1;
    		//System.out.println(flagq);
    		xf=e.getX();
    		yf=e.getY();
    	}
    	if("直线".equals(name))
    	{
    		x0=e.getX();
    		y0=e.getY();    		
    		x1=e.getX();
    		y1=e.getY();   		
    		flag_line=1;
    		
    	}
	}

	public void mouseReleased(MouseEvent e) {
		System.out.println("释放");
		
		if("矩形".equals(name)||"椭圆".equals(name))
		{
		x2 = e.getX();
		y2 = e.getY();
		}
		/*if ("直线".equals(name)) {
			// 画线
			gr.drawLine(x1, y1, x2, y2);
		}*/
		if ("矩形".equals(name)) {
			gr.drawRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1 - x2), Math.abs(y1 - y2));
			set_shape(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1 - x2), Math.abs(y1 - y2),"矩形",color);
    		
		}
		if("椭圆".equals(name)){
			gr.drawOval(Math.min(x1, x2),Math.min(y1, y2), Math.abs(x1-x2),Math.abs(y1-y2));
			set_shape(Math.min(x1, x2),Math.min(y1, y2), Math.abs(x1-x2),Math.abs(y1-y2),"椭圆",color);    		
		}
    	if ("曲线".equals(name))
    	{
    		flagq=0;
    		System.out.println(flagq);
    	}
    	if("直线".equals(name))
    	{
    		flag_line=0;
			set_shape(x0,y0,x2,y2,"直线",color);
    	}
		
		
	}

	public void mouseEntered(MouseEvent e) {
		//System.out.println("进入");

	}

	public void mouseExited(MouseEvent e) {
		//System.out.println("退出");

	}

	public void actionPerformed(ActionEvent e) {
		
		
		if("".equals(e.getActionCommand())){
			//获取当前事件源
			JButton jbu = (JButton)e.getSource();
			//获取按钮的背景色
			color = jbu.getBackground();
			//设置画笔颜色
			gr.setColor(color);
		}else{
			// 获取按钮内容
			name = e.getActionCommand();
		}
		
		System.out.println("name = " + name);
	}
	
    public void mouseDragged(MouseEvent e)
    {
    	//System.out.print("x坐标:"+e.getX()+"  y坐标:"+e.getY());
    	if (flagq==1)
    	{
    		xl=e.getX();
    		yl=e.getY();
    		gr.drawLine(xf, yf, xl, yl);
    		set_shape(xf, yf, xl, yl,"直线",color);
    		xf=xl;
    		yf=yl;
    	}
    	if("橡皮擦".equals(name))
    	{

    		x1=e.getX();
    		y1=e.getY(); 
    		gr.setColor(Color.white);
    		gr.fillRect(x1-5, y1-5, 10, 10);
    		gr.setColor(color); 
    		//gr.clearRect(x1-5, y1-5, 10, 10);
    		set_shape(x1-5, y1-5, 10, 10,"橡皮擦",color);
  		
    	}
    	if("直线".equals(name)&&flag_line==1)
    	{
    		x2=e.getX();
    		y2=e.getY();
    		gr.setColor(Color.white);
    		gr.drawLine(x0, y0, x1, y1);
    		
    	    
			gr.setColor(color);  		
    		
    		gr.drawLine(x0, y0, x2, y2);
    		
    		x1=x2;
    		y1=y2;
    		
    	}
  	
    }
    public void mouseMoved(MouseEvent e)
    {
    	//System.out.print("鼠标动");
    }
	
	public void set_shape(int x1,int y1,int x2,int y2,String name,Color color)
	{
		
   		Shape shape=new Shape(x1,y1,x2,y2,name,color);   		
	  		
		arrayShape[index++] = shape;
		
	}
 
   public void iterate(double x,double y)
   {
	   System.out.println("打印");
	   for(int i=0;i<25500;i++)
		 {         
			 double temx= Math.sin(a*y)+c*Math.cos(a*x); 			 
			 double temy=Math.sin(b*x)+d*Math.cos(b*y);              
			 int x1= (int)(temx*130+400);          //对x1,y1转型，放大，移动到屏幕坐标系
			 int y1= (int)(temy*130+400);  
			 //System.out.println("x1: "+x1+" y1: "+y1);           //颜色根据佚代次数加深         
			 gr.setColor(new Color(i/200,0,i/100));    
			 gr.drawLine(x1, y1, x1,y1);       
			 x=temx;           
			 y=temy;			 
		}
   }
  
	
	

}